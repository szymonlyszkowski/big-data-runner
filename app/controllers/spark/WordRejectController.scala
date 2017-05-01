package controllers.spark

import javax.inject.Inject

import bigdata.engines.spark.SparkStreaming
import bigdata.engines.spark.actions.WordReject
import play.api.mvc.{Action, Controller}

import scala.util.Random


/**
  * Created by lyszkows on 27/04/2017.
  */
class WordRejectController @Inject()(config: play.api.Configuration) extends Controller {

  def wordReject(wordToBeFound: String) = Action {
    val basePathHDFS = config.getString("hadoop-base-url").get
    val sourceFileName = "mergedTweets0.3686418061949279.txt"
    val destinationFileName = basePathHDFS + "sparkWordRejectResult" + new Random().nextDouble().toString
    val numerOfWordLeftAfterRejection = new WordReject().run(SparkStreaming.sparkContext, basePathHDFS + s"$sourceFileName", wordToBeFound, destinationFileName)
    Ok(s"Spark Map Reduce job reject lines containing '$wordToBeFound' done. Lines remained: " + numerOfWordLeftAfterRejection)
  }
}
