package bigdata.engines.hadoop.actions.mr;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class FilterMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private final IntWritable one = new IntWritable(1);
    private Text word = new Text();

    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String wordToBeFound = context.getConfiguration().get("wordToBeFound");
        String line = value.toString();
        if (line.contains(wordToBeFound)) {
            context.write(word, one);
        }
    }
}

