package bigdata.engines.spark

import org.apache.spark.sql.SparkSession


/**
  * Handles configuration, context and so
  *
  * @author Alexandre Masselot.
  */
object SparkCommons {
  // Create a SparkSession. No need to create SparkContext
  // You automatically get it as part of the SparkSession
  val warehouseLocation = "file:${system:user.dir}/spark-warehouse"
  val sc = SparkSession
    .builder()
    .appName("SparkSessionZipsExample")
    .master("local")
    .config("spark.some.config.option", "config-value")
    .config("spark.debug.maxToStringFields", 1000)
    .getOrCreate()
}
