package controllers.hadoop

import javax.inject.Inject

import bigdata.engines.hadoop.actions.WordReject
import play.api.mvc.{Action, Controller}

/**
  * Created by szymonidas on 4/28/17.
  */
class WordRejectController @Inject()(config: play.api.Configuration) extends Controller {
  def wordReject(wordToBeFound: String) = Action {
    val basePathHDFS = config.getString("hadoop-base-url").get
    val sourceFileName = "mergedTweets0.3686418061949279.txt"
    val linesLeftAfterRejection = new WordReject().run(basePathHDFS, wordToBeFound)
    Ok(s"Hadoop Map Reduce job reject lines containing '$wordToBeFound' done. Lines remained: " + linesLeftAfterRejection)
  }
}
