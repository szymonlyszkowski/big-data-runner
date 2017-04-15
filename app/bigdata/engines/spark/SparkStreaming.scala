package bigdata.engines.spark

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Created by szymonidas on 3/18/17.
  */
object SparkStreaming {
  val conf = new SparkConf().setMaster("local[*]").setAppName("dummy config")
  val ssc = new StreamingContext(conf, Seconds(360))
}
