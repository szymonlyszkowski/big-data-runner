package controllers.spark

import javax.inject.Inject

import bigdata.engines.spark.SparkStreaming
import bigdata.engines.spark.actions.WordCount
import play.api.mvc.{Action, Controller}

import scala.util.Random

/**
  * Created by szymonidas on 4/21/17.
  */
class WordCountController @Inject()(config: play.api.Configuration) extends Controller {

  def wordCount = Action {
    val basePathHDFS = config.getString("hadoop-base-url").get
    val sourceFileName = "mergedTweets0.3686418061949279.txt"
    val destinationFileName = basePathHDFS + "sparkWordCountResult" + new Random().nextDouble().toString
    new WordCount().run(SparkStreaming.sparkContext, basePathHDFS + s"$sourceFileName", destinationFileName)
    Ok("Word count done via Spark")
  }

}
