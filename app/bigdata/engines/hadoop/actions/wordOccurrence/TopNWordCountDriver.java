package bigdata.engines.hadoop.actions.wordOccurrence;

/**
 * Created by szymonidas on 4/28/17.
 */

import org.apache.commons.net.ntp.TimeStamp;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.ToolRunner;


public class TopNWordCountDriver {

    public int run(String wordToBeFound, String basePathHDFS) {
        int result = -1;
        try {
            Path pt = new Path(basePathHDFS + "mergedTweets0.3686418061949279.txt");
            Configuration conf = new Configuration();
            conf.set("fs.defaultFS", basePathHDFS);
            Job job = new Job(conf, "Word Frequency Count Job");
            job.setJarByClass(TopNWordCountDriver.class);
            job.setMapperClass(TopNWordCountMapper.class);
            job.setReducerClass(TopNWordCountReducer.class);
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(IntWritable.class);
            FileInputFormat.addInputPath(job, pt);
            TimeStamp myTs = TimeStamp.getCurrentTime();
            FileOutputFormat.setOutputPath(job, new Path(basePathHDFS + "hadoopResult" + myTs + ".txt"));
            job.waitForCompletion(true);
            if (job.isSuccessful()) {
                System.out.println("Job is Completed Successfully");
            } else {
                System.out.println("Error in job...");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return result;
    }

}


