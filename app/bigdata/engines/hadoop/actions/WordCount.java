package bigdata.engines.hadoop.actions;

import bigdata.engines.hadoop.actions.mr.SimpleReduce;
import bigdata.engines.hadoop.actions.mr.WordCountMapper;
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

public class WordCount {
    public void run(String basePathHDFS, String tweetsPathHDFS) throws Exception {
        Path pt = new Path(basePathHDFS + "mergedTweets0.3686418061949279.txt");
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", basePathHDFS);
        Job job = new Job(conf, "WordCount");

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(SimpleReduce.class);

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        FileInputFormat.addInputPath(job, pt);
        TimeStamp myTs = TimeStamp.getCurrentTime();
        FileOutputFormat.setOutputPath(job, new Path(basePathHDFS +"hadoopWordCountResult" + myTs));
        job.waitForCompletion(true);
    }
}


