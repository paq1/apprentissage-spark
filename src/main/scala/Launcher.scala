import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

object Launcher extends App {

  val spark = SparkSession.builder
    .master("local[*]")
    .appName("MonAppSpark")
    .getOrCreate()

  val test: RDD[(String, Int)] = spark.sparkContext.textFile("data/mon-fichier")
    .flatMap(x => x.split(" "))
    .map(w => (w, 1))
    .reduceByKey((a, b) => a + b)


  val rddGroupBy: RDD[(Char, Iterable[(String, Int)])] = test
    .groupBy(x => x._1.charAt(0))

  rddGroupBy.foreach(println)
}
