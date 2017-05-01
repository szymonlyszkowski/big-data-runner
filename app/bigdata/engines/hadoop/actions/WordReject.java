package bigdata.engines.hadoop.actions;

import org.apache.commons.net.ntp.TimeStamp;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;

public class WordReject {
    public static class Map extends Mapper<LongWritable, Text, Text, IntWritable> {
        private final static IntWritable one = new IntWritable(1);
        private Text word = new Text();

        public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String wordToBeFound = context.getConfiguration().get("wordToBeFound");
            String line = value.toString();
            if (!line.contains(wordToBeFound)) {
                word.set(line);
                context.write(word, one);
            }
        }
    }

    public static class Reduce extends org.apache.hadoop.mapreduce.Reducer<Text, IntWritable, Text, IntWritable> {
        public void reduce(Text key, Iterable<IntWritable> values, Context context)
                throws IOException, InterruptedException {
            int sum = 0;
            for (IntWritable val : values) {
                sum += val.get();
            }
            context.write(key, new IntWritable(sum));
        }
    }

    public long run(String basePathHDFS, String wordToBeFound) throws Exception {
        Path pt = new Path(basePathHDFS + "mergedTweets0.3686418061949279.txt");
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", basePathHDFS);
        conf.set("wordToBeFound", wordToBeFound);
        Job job = new Job(conf, "wordFilter");
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        job.setMapperClass(Map.class);
        job.setReducerClass(Reduce.class);

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        FileInputFormat.addInputPath(job, pt);
        TimeStamp myTs = TimeStamp.getCurrentTime();
        FileOutputFormat.setOutputPath(job, new Path(basePathHDFS + "hadoopRejectResult" + myTs));
        job.waitForCompletion(true);
        return job.getCounters().findCounter("org.apache.hadoop.mapred.Task$Counter", "MAP_OUTPUT_RECORDS").getValue();
    }

}
