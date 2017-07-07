package bigdata.engines.spark.actions

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.storage.StorageLevel

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
  def run(sparkContext: SparkContext, filePath: String, word: String, rddPersistance: StorageLevel = StorageLevel.MEMORY_ONLY) = {
      val lines: RDD[String] = sparkContext.textFile(filePath)
      lines.persist(rddPersistance)
      val linesContainingWord = lines.filter(line => line.contains(word))
      linesContainingWord.count()
    }

}
