package bigdata.engines.spark.actions

import org.apache.spark.SparkContext
/**
  * Created by szymonidas on 4/19/17.
  */
class WordCount {
  def run(sparkContext: SparkContext, filePath: String, wordCountResultFilePath: String) {
    val textFile = sparkContext.textFile(filePath)
    val counts = textFile.flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _)
    counts.saveAsTextFile(wordCountResultFilePath)
  }
}
