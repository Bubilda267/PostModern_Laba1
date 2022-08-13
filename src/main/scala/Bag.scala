package com.tkroman.kpi.y2022.l1

case class Bag[A] private (val map: Map[A, Int]):

  override def toString(): String =
    this.map.toString


object Bag:

  def makeBag[A](xs: A*): Bag[A] =
    val s = Seq(xs*)
    Bag[A](s.groupBy(identity).mapValues(_.size).toMap)


  def add[A](b: Bag[A], a: A*): Bag[A] =
    val s = Seq(a*)
    val temp_list = b.map.toList ++ s.groupBy(identity).mapValues(_.size).toMap
    val temp_map = temp_list.groupBy(_._1).map {
      case (k,v) => k -> v.map(_._2).sum
    }
    Bag[A](temp_map)


  def contains[A](b: Bag[A], a: A): Boolean =
    b.map.contains(a)


  def count[A](b: Bag[A], a: A): Int =
    b.map.get(a) match
      case Some(a) => a
      case None => 0


  def union[A](l: Bag[A], r: Bag[A]): Bag[A] =
    val res = l.map.keySet.union(r.map.keySet).map(k => k -> (if (count(l,k) > count(r,k)) (count(l,k)) else count(r,k))).toMap
    Bag[A](res)


  def intersection[A](l: Bag[A], r: Bag[A]): Bag[A] =
    val res = l.map.keySet.intersect(r.map.keySet).map(k => k -> (if (l.map(k) > r.map(k)) r.map(k) else l.map(k)) ).toMap
    Bag[A](res)


  def map[A,B](b: Bag[A], f: A => B): Bag[B] =
    val res = for((k,v)<-b.map) yield (f(k), v)
    Bag[B](res)


  @main
  def main(): Unit = {

  }