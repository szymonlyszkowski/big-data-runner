package bigdata.engines.hadoop.actions;

import bigdata.engines.hadoop.actions.mr.FilterMapper;
import bigdata.engines.hadoop.actions.mr.RejectMapper;
import bigdata.engines.hadoop.actions.mr.SimpleReduce;
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


    public long run(String basePathHDFS, String wordToBeFound) throws Exception {
        Path pt = new Path(basePathHDFS + "mergedTweets0.3686418061949279.txt");
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", basePathHDFS);
        conf.set("wordToBeFound", wordToBeFound);
        Job job = new Job(conf, "WordReject");
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        job.setMapperClass(RejectMapper.class);
        job.setReducerClass(SimpleReduce.class);

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        FileInputFormat.addInputPath(job, pt);
        TimeStamp myTs = TimeStamp.getCurrentTime();
        FileOutputFormat.setOutputPath(job, new Path(basePathHDFS + "hadoopWordRejectResult" + myTs));
        job.waitForCompletion(true);
        return job.getCounters().findCounter("org.apache.hadoop.mapred.Task$Counter", "MAP_OUTPUT_RECORDS").getValue();
    }

}
