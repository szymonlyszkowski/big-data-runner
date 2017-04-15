package controllers

import javax.inject.Inject
import bigdata.engines.spark.SparkStreaming
import com.google.gson.Gson
import org.apache.spark.sql.DataFrame
import org.apache.spark.streaming.twitter.TwitterUtils
import play.api.mvc.{Action, Controller}
import services.twitter.Twitter4JConfiguration

class LiveTweetResourcesSparkController @Inject() (config: play.api.Configuration) extends Controller{

  /**
    * List all tweets from dataFile
    * @return
    */


  def listSampleTweets = Action {
    val twitterInstance = new Twitter4JConfiguration(config).getTwitter4JAccess()
    val tweetStream = TwitterUtils.createStream(SparkStreaming.ssc, Option(twitterInstance.getAuthorization)).map(new Gson().toJson(_))
    var numTweetsCollected: Long = 0
    tweetStream.foreachRDD((rdd, time) => {
        val outputRDD = rdd.repartition(4)
        outputRDD.saveAsTextFile(config.getString("hadoop-tweets-url").get + "tweet_" + time.milliseconds.toString)
    })

    tweetStream.print()
    tweetStream.glom()
    SparkStreaming.ssc.start()
    Ok("started streaming")
  }

  def stopStreaming = Action{
    SparkStreaming.ssc.stop(true,true)
    Ok("stopped streaming")
  }

  private def parse(rdd: DataFrame): String = rdd.toJSON.collect.toList.mkString(",\n")
}
