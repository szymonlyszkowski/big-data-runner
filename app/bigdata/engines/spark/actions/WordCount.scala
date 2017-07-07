package bigdata.engines.spark.actions

import org.apache.spark.SparkContext
import org.apache.spark.storage.StorageLevel
/**
  * Created by szymonidas on 4/19/17.
  */
class WordCount {
  def run(sparkContext: SparkContext, filePath: String, wordCountResultFilePath: String, rddPersistance: StorageLevel = StorageLevel.MEMORY_ONLY) {
    val textFile = sparkContext.textFile(filePath)
    textFile.persist(rddPersistance)
    val counts = textFile.flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _)
    counts.saveAsTextFile(wordCountResultFilePath)
  }
}
