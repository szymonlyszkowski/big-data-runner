package bigdata.engines.hadoop.actions.wordOccurrence;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * Created by szymonidas on 4/28/17.
 */
public class TopNWordCountMapper extends Mapper<Object, Text, Text, IntWritable> {
    private final String wordToBeFound;

    public TopNWordCountMapper(String wordToBeFound) {
        this.wordToBeFound = wordToBeFound;
    }

    private static final IntWritable one = new IntWritable(1);
    private Text word = new Text();

    public void map(Text value, OutputCollector<Text, IntWritable> output) throws IOException, InterruptedException { /*Retrieving tokens from string input*/
        String line = value.toString();      // conversion in string
        StringTokenizer tokenizer = new StringTokenizer(line);
        while (tokenizer.hasMoreTokens()) { /*While tokens found put initial count as 1*/
            word.set(tokenizer.nextToken());
            if (line.equals(wordToBeFound)) {  //cold is the specific word to get count for
                output.collect(word, one);      // getting 1 as a count for 'cold' as if its counting only first line 'cold' and not going to next line.

            }
        }
    }
}
