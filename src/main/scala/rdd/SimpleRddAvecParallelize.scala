package rdd

import core.SimpleJob
import org.apache.spark.rdd.RDD

object SimpleRddAvecParallelize extends SimpleJob {

  def run(): Unit = {
    val sc = spark.sparkContext

    val numbersWithNoSpecificPartition: RDD[Int] = sc.parallelize(0 to 1000) // pas dans l'ordre
    val numbersWithOnePartition: RDD[Int] = sc.parallelize(0 to 1000, 1) // dans l'ordre

    println(s" nombre de partition pas specifié ================================ ${numbersWithNoSpecificPartition.getNumPartitions}") // 12 (sur ma tour)
    println(s" nombre de partition pour 1 ====================================== ${numbersWithOnePartition.getNumPartitions}") // 1 😊
  }

  override def jobName: String = "SimpleRddAvecParallelize"
}
