package controllers.hadoop

import javax.inject.Inject

import bigdata.engines.hadoop.actions.WordCount
import play.api.mvc.{Action, Controller}

/**
  * Created by szymonidas on 4/13/17.
  */
class WordCountController @Inject()(config: play.api.Configuration) extends Controller {
  private val getHDFSMessage = "Couldn't get HDFS"

  def wordCount = Action {
    val tweetsPathHDFS = config.getString("hadoop-tweets-url").getOrElse(throw new RuntimeException(s"$getHDFSMessage tweets path from application configuration file!"))
    val basePathHDFS = config.getString("hadoop-base-url").getOrElse(throw new RuntimeException(s"$getHDFSMessage base path!"))
    new WordCount().run(basePathHDFS, tweetsPathHDFS)
    Ok("Word count done via Hadoop")
  }


}

