package rdd

import core.SimpleJob
import org.apache.spark.rdd.RDD

object SimpleLectureFichierText extends SimpleJob {

  def run(): Unit = {

    val sc = spark.sparkContext

    val fichierContent: RDD[String] = sc.textFile("data/mon-fichier")

    val content: List[String] = fichierContent.collect().toList

    content.foreach(println)
  }

  override def jobName: String = "SimpleLectureFichier"
}
