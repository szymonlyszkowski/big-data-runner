package bigdata.engines.spark.actions

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.storage.StorageLevel

class WordReject {
  /**
    * @param sparkContext
    * @param filePath
    * @param word
    * @return numerOfWordLeftAfterRejection
    */
  def run(sparkContext: SparkContext, filePath: String, word: String, destinationFileName: String, rddPersistance: StorageLevel = StorageLevel.MEMORY_ONLY) = {
    val lines: RDD[String] = sparkContext.textFile(filePath)
    lines.persist(rddPersistance)
    val linesContainingWord = lines.filter(line => !line.contains(word))
    linesContainingWord.saveAsTextFile(destinationFileName)
    linesContainingWord.count()
  }

}
