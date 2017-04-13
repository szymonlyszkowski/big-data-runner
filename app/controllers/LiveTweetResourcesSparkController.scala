package controllers

import javax.inject.Inject

import bigdata.engines.spark.SparkStreaming
import com.google.gson.Gson
import org.apache.spark.sql.DataFrame
import org.apache.spark.streaming.twitter.TwitterUtils
import play.api.mvc.{Action, Controller}
import services.twitter.Twitter4JConfiguration

/**
  * Created by szymonidas on 3/18/17.
  */
class LiveTweetResourcesSparkController @Inject() (config: play.api.Configuration) extends Controller{
//  val sampleTweets = new TwitterAccess().run(List(Language.Polish))
//  lazy val rdd = SparkCommons.sparkSession.sqlContext.read.json(sampleTweets.toString)

  /**
    * List all tweets from dataFile
    * @return
    */
  def listSampleTweets = Action {
    val twitterInstance = new Twitter4JConfiguration(config).getTwitter4JAccess()
    val tweetStream = TwitterUtils.createStream(SparkStreaming.ssc, Option(twitterInstance.getAuthorization)).map(new Gson().toJson(_))

    var numTweetsCollected: Long = 0
    tweetStream.foreachRDD((rdd, time) => {
      val count: Long = rdd.count()
      if (count > 0) {
        val outputRDD = rdd.repartition(4)
        outputRDD.saveAsTextFile("hdfs://127.0.0.1:8080/test/tweet_" + time.milliseconds.toString)
        numTweetsCollected += count
        println(numTweetsCollected)
      }
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
