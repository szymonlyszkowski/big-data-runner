package bigdata.engines.spark

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Created by szymonidas on 3/18/17.
  */
object SparkStreaming {
  val conf = new SparkConf().setMaster("local[*]").setAppName("big-data-runner-spark-driver-application")
  val sparkContext = new SparkContext(conf)
  val streamingContext = new StreamingContext(sparkContext, Seconds(360))

}
