package bigdata.engines.spark.actions

import org.apache.spark.SparkContext

/**
  * Created by szymonidas on 4/20/17.
  */
object TweetMerge {

  def mergeTweets(sparkContext: SparkContext, sourceDirectoryPath: String, destinationFilePath: String) = {
    sparkContext.textFile(sourceDirectoryPath).coalesce(1).saveAsTextFile(destinationFilePath)
  }

}
