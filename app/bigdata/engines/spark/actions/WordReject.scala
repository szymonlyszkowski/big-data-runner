package bigdata.engines.spark.actions

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

class WordReject {
  /**
    * @param sparkContext
    * @param filePath
    * @param word
    * @return numerOfWordLeftAfterRejection
    */
  def run(sparkContext: SparkContext, filePath: String, word: String, destinationFileName: String) = {
    val lines: RDD[String] = sparkContext.textFile(filePath)
    val linesContainingWord = lines.filter(line => !line.contains(word))
    linesContainingWord.saveAsTextFile(destinationFileName)
    linesContainingWord.count()
  }

}
