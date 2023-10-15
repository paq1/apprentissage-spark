package rdd

import core.SimpleJob
import org.apache.spark.rdd.RDD

object ExempleRddGroupBy extends SimpleJob {
  def run(): Unit = {

    val sc = spark.sparkContext
    val fichierContent: RDD[String] = sc.textFile("data/mon-fichier")
    val rddGroupBy: RDD[(Char, Iterable[String])] = fichierContent
      .groupBy(x => x.charAt(0))
    rddGroupBy.foreach(println)
  }

  override def jobName: String = "ExempleGroupeByApp"
}
