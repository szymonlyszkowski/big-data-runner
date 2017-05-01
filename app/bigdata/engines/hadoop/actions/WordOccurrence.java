package bigdata.engines.hadoop.actions;

import bigdata.engines.hadoop.actions.mr.FilterMapper;
import bigdata.engines.hadoop.actions.mr.SimpleReduce;
import org.apache.commons.net.ntp.TimeStamp;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class WordOccurrence {

    public long run(String basePathHDFS, String wordToBeFound) throws Exception {
        Path pt = new Path(basePathHDFS + "mergedTweets0.3686418061949279.txt");
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", basePathHDFS);
        conf.set("wordToBeFound", wordToBeFound);
        Job job = new Job(conf, "WordOccurrence");
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        job.setMapperClass(FilterMapper.class);
        job.setReducerClass(SimpleReduce.class);

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        FileInputFormat.addInputPath(job, pt);
        TimeStamp myTs = TimeStamp.getCurrentTime();
        FileOutputFormat.setOutputPath(job, new Path(basePathHDFS + "hadoopWordOccurrenceResult" + myTs));
        job.waitForCompletion(true);
        return job.getCounters().findCounter("org.apache.hadoop.mapred.Task$Counter", "MAP_OUTPUT_RECORDS").getValue();
    }

}
