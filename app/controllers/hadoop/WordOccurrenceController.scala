package controllers.hadoop

import javax.inject.Inject

import bigdata.engines.hadoop.actions.WordOccurrence
import play.api.mvc.{Action, Controller}

/**
  * Created by szymonidas on 4/28/17.
  */
class WordOccurrenceController @Inject()(config: play.api.Configuration) extends Controller {
  def wordOccurrence(wordToBeFound: String) = Action{
    val basePathHDFS = config.getString("hadoop-base-url").get
    val sourceFileName = "mergedTweets0.3686418061949279.txt"
    val res = new WordOccurrence().run(basePathHDFS, wordToBeFound)
    Ok(s"Hadoop Map Reduce filter lines by phrase occurrence job run result: " + res)
  }
}
