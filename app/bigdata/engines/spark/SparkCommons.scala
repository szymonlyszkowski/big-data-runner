package bigdata.engines.spark

import org.apache.spark.sql.SparkSession


object SparkCommons {
  val warehouseLocation = "file:${system:user.dir}/spark-warehouse"
  val sc = SparkSession
    .builder()
    .appName("SparkSessionZipsExample")
    .master("local")
    .config("spark.some.config.option", "config-value")
    .config("spark.debug.maxToStringFields", 1000)
    .getOrCreate()
}
