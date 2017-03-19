package controllers

import bigdata.engines.spark.SparkCommons
import org.apache.spark.sql.DataFrame
import play.api.mvc._


class EmbeddedTweetsResourcesSparkController extends Controller {
  val dataFile = "resources/tweet-json"
  lazy val rdd = SparkCommons.sparkSession.getOrCreate().sqlContext.read.json(dataFile)

  def index = Action {
    Ok("hello world")
  }

  private def toJsonString(rdd:DataFrame):String =
  "["+rdd.toJSON.collect.toList.mkString(",\n")+"]"

  /**
    * number of elements
    * @return
    */
  def countTweets = Action {
    Ok(rdd.count.toString)
  }

  /**
    * List all tweets from dataFile
    * @return
    */
  def listTweets = Action {
    Ok(toJsonString(rdd))
  }

  /**
    * Search for tweets with given text.
    * @param textToBeFiltered
    * @return
    */
  def filterByTweetsText(textToBeFiltered:String) = Action {
    Ok(toJsonString(rdd.filter(rdd("text").contains(textToBeFiltered))))
  }
}
