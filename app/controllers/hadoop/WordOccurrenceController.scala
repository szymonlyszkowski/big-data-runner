package controllers.hadoop

import javax.inject.Inject

import bigdata.engines.hadoop.actions.wordOccurrence.TestCase
import bigdata.engines.spark.SparkStreaming
import bigdata.engines.spark.actions.WordOccurrence
import play.api.mvc.{Action, Controller}

/**
  * Created by szymonidas on 4/28/17.
  */
class WordOccurrenceController @Inject()(config: play.api.Configuration) extends Controller {
  def wordOccurrence(wordToBeFound: String) = Action{
    val basePathHDFS = config.getString("hadoop-base-url").get
    val sourceFileName = "mergedTweets0.3686418061949279.txt"
    val res = new TestCase().run(basePathHDFS, wordToBeFound)
    Ok(s"Hadoop MR job run result: " + res)
  }
}
