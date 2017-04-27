package bigdata.engines.spark.actions

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

/**
  * Created by lyszkows on 27/04/2017.
  */
class WordOccurrence {
  /**
     * @param sparkContext
    * @param filePath
    * @param word
    * @return numberOfWordOccurrence
    */
  def run(sparkContext: SparkContext, filePath: String, word: String) = {
      val lines: RDD[String] = sparkContext.textFile(filePath)
      val errors = lines.filter(line => line.contains(word))
      errors.count()
    }

}
