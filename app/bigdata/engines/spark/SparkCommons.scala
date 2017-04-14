package bigdata.engines.spark

import org.apache.spark.sql.SparkSession

object SparkCommons {
  val sparkSession = SparkSession
    .builder()
    .appName("SparkSessionZipsExample")
    .master("local[*]")
    .config("spark.some.config.option", "config-value")
    .config("spark.debug.maxToStreingFields", 1000)
}
