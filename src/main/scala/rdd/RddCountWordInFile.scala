package rdd

import core.SimpleJob
import org.apache.spark.rdd.RDD

object RddCountWordInFile extends SimpleJob {
  def run(): Unit = {

    val sc = spark.sparkContext

    val fichierContent: RDD[String] = sc.textFile("data/mon-fichier")

    val countWordInFile: RDD[(String, Int)] = fichierContent
      .flatMap(x => x.split(" "))
      .map(w => (w, 1))
      .reduceByKey(_ + _)

    // Affichage du nombre de mot
    countWordInFile.foreach(println)
  }

  override def jobName: String = "CountWordApp"
}
