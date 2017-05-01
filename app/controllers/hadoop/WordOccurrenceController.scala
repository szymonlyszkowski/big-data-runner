package controllers.hadoop

import javax.inject.Inject

import bigdata.engines.hadoop.actions.WordOccurrence
import play.api.mvc.{Action, Controller}

/**
  * Created by szymonidas on 4/28/17.
  */
class WordOccurrenceController @Inject()(config: play.api.Configuration) extends Controller {
  def wordOccurrence(wordToBeFound: String) = Action {
    val basePathHDFS = config.getString("hadoop-base-url").get
    val sourceFileName = "mergedTweets0.3686418061949279.txt"
    val wordOccurrenceAmount = new WordOccurrence().run(basePathHDFS, wordToBeFound)
    Ok(s"Hadoop Map Reduce job filter lines done. Amount of lines containing '$wordToBeFound': " + wordOccurrenceAmount)
  }
}
