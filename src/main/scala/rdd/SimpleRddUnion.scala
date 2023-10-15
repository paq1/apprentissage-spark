package rdd

import core.SimpleJob
import org.apache.spark.rdd.RDD

object SimpleRddUnion extends SimpleJob {
  override def run: Unit = {
    val sc = spark.sparkContext

    val rddNumbreOnToTen: RDD[Int] = sc.parallelize(0 to 10, 1)

    val rddPair: RDD[Int] = rddNumbreOnToTen
      .filter(number => number % 2 == 0)

    val rddImpair: RDD[Int] = rddNumbreOnToTen
      .filter(number => number % 2 == 1)

    val rddUnion = rddPair.union(rddImpair)
      .repartition(1) // on remet 1 partition pour pouvoir "sort" correctement 😋
      .sortBy(x => x)

    println(" ---------------------------------------------- rdd pair")
    rddPair.foreach(println)
    println(" ---------------------------------------------- rdd impair")
    rddImpair.foreach(println)
    println(" ---------------------------------------------- rdd union")
    rddUnion.foreach(println)
  }

  override def jobName: String = "SimpleRddUnionJob"
}
