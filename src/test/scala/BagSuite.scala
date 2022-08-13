package com.tkroman.kpi.y2022.l1

import munit.FunSuite
import Bag.*

class BagSuite extends FunSuite {
  test("Make bag(Int) function") {
    val expected = Map(1 -> 2, 2 -> 1, 3 -> 4)
    val actual = makeBag(1, 1, 2, 3, 3, 3, 3).map
    assertEquals(expected, actual)
  }

  test("Make bag(String) function") {
    val expected = Map("abc" -> 1, "dqtqwe" -> 3, "zxc" -> 2)
    val actual = makeBag("abc", "dqtqwe", "dqtqwe", "zxc", "dqtqwe", "zxc").map
    assertEquals(expected, actual)
  }

  test("Make bag(bool) function") {
    val expected = Map(true -> 3, false -> 2)
    val actual = makeBag(true, false, true, false, true).map
    assertEquals(expected, actual)
  }

  test("Add(Int) function") {
    val map_ = makeBag(1, 1, 4)
    val expected = Map(1 -> 4, 4 -> 1, 5 -> 2, 6 -> 1)
    val actual = add(map_, 1, 1, 5, 5, 6).map
    assertEquals(expected, actual)
  }

  test("Add(String) function") {
    val map_ = makeBag("ab", "cd", "cd", "ab", "qwe")
    val expected = Map("ab" -> 3, "cd" -> 2, "qwe" -> 2, "erq" -> 1)
    val actual = add(map_, "ab", "qwe", "erq").map
    assertEquals(expected, actual)
  }

  test("Add(Bool) function") {
    val map_ = makeBag(true, false)
    val expected = Map(true -> 4, false -> 2)
    val actual = add(map_, true, false, true, true).map
    assertEquals(expected, actual)
  }

  test("Contains(true) function") {
    val map_ = makeBag(1, 2, 3, 4, 1, 1, 2, 4)
    val expected = true
    val actual = contains(map_, 3)
    assertEquals(expected, actual)
  }

  test("Contains(false) function") {
    val map_ = makeBag(1, 2, 3, 4, 1, 1, 2, 4)
    val expected = false
    val actual = contains(map_, 6)
    assertEquals(expected, actual)
  }

  test("Count function") {
    val map_ = makeBag("ab", "ab", "ab", "cd")
    val expected = 3
    val actual = count(map_, "ab")
    assertEquals(expected, actual)
  }

  test("Count function") {
    val map_ = makeBag("ab", "ab", "ab", "cd")
    val expected = 0
    val actual = count(map_, "123")
    assertEquals(expected, actual)
  }

  test("Union(Int) function") {
    val map1 = makeBag(1, 2, 3, 2, 1, 3, 2, 3, 5)
    val map2 = makeBag(1, 1, 1, 2, 4, 4)
    val expected = Map(1 -> 3, 2 -> 3, 3 -> 3, 4 -> 2, 5 -> 1)
    val actual = union(map1, map2).map
    assertEquals(expected, actual)
  }

  test("Union(String) function") {
    val map1 = makeBag("ab", "123", "cd", "123")
    val map2 = makeBag("ab", "cd", "cd", "asfasfa")
    val expected = Map("ab" -> 1, "123" -> 2, "cd" -> 2, "asfasfa" -> 1)
    val actual = union(map1, map2).map
    assertEquals(expected, actual)
  }

  test("Union(Bool) function") {
    val map1 = makeBag(true, false)
    val map2 = makeBag(true, true)
    val expected = Map(true -> 2, false -> 1)
    val actual = union(map1, map2).map
    assertEquals(expected, actual)
  }

  test("Intersection(Int) function") {
    val map1 = makeBag(1, 2, 3, 4, 1, 1, 2, 4)
    val map2 = makeBag(1, 2, 3, 2, 1, 3, 2, 3, 5)
    val expected = Map(1 -> 2, 2 -> 2, 3 -> 1)
    val actual = intersection(map1, map2).map
    assertEquals(expected, actual)
  }

  test("Intersection(String) function") {
    val map1 = makeBag("ab", "123", "cd", "123")
    val map2 = makeBag("ab", "cd", "cd", "asfasfa")
    val expected = Map("ab" -> 1, "cd" -> 1)
    val actual = intersection(map1, map2).map
    assertEquals(expected, actual)
  }

  test("Intersection(Bool) function") {
    val map1 = makeBag(true, false)
    val map2 = makeBag(true, true)
    val expected = Map(true -> 1)
    val actual = intersection(map1, map2).map
    assertEquals(expected, actual)
  }

  test("Map(+,Int) function"){
    val expected = makeBag(10, 9, 4, 15, 6)
    val actual = map(makeBag(7, 1, 6, 12, 3), (a => a + 3))
    assertEquals(expected, actual)
  }

  test( "Map(*,Int) function"){
    val expected = makeBag(10, 6, 4, 16, 6)
    val actual = map(makeBag(5, 3, 2, 8, 3), (a => a * 2))
    assertEquals(expected, actual)
  }

  test("Map(+,String) function"){
    val expected = makeBag("asd00", "ggs00", "12300")
    val actual = map(makeBag("asd", "ggs", "123"), (a => a + "00"))
    assertEquals(expected, actual)
  }

  test("Map(*,String) function") {
    val expected = makeBag("asdasdasd", "ggsggsggs", "123123123")
    val actual = map(makeBag("asd", "ggs", "123"), (a => a * 3))
    assertEquals(expected, actual)
  }
}
