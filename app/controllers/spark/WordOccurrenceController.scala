package controllers.spark

import javax.inject.Inject

import bigdata.engines.spark.SparkStreaming
import bigdata.engines.spark.actions.{WordOccurrence}
import play.api.mvc.{Action, Controller}


/**
  * Created by lyszkows on 27/04/2017.
  */
class WordOccurrenceController @Inject()(config: play.api.Configuration) extends Controller {
  def wordOccurrence(wordToBeFound: String) = Action {
    val basePathHDFS = config.getString("hadoop-base-url").get
    val sourceFileName = "mergedTweets0.3686418061949279.txt"
    val wordOccurrenceAmount = new WordOccurrence().run(SparkStreaming.sparkContext, basePathHDFS + s"$sourceFileName", wordToBeFound)
    Ok(s"Spark Map Reduce filter lines by $wordToBeFound occurrence job run result: " + wordOccurrenceAmount)
  }
}
