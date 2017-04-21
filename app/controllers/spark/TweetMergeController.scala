package controllers.spark

import javax.inject.Inject

import bigdata.engines.spark.SparkStreaming
import bigdata.engines.spark.actions.TweetMerge
import play.api.mvc.{Action, Controller}

import scala.util.Random

/**
  * Created by szymonidas on 4/20/17.
  */
class TweetMergeController @Inject() (config: play.api.Configuration) extends Controller{

  def mergeTweets = Action{
    val tweetsFilePathPattern = config.getString("hadoop-tweets-url").get + "tweet_*"
    val randomSuffix = new Random().nextDouble()
    val hdfsBaseUrl = config.getString("hadoop-base-url").get
    val mergedFilePath = s"$hdfsBaseUrl" + s"mergedTweets$randomSuffix.txt"
    TweetMerge.mergeTweets(SparkStreaming.sparkContext, tweetsFilePathPattern, mergedFilePath)
    Ok("Tweets merged into file: " + mergedFilePath)
  }

}
