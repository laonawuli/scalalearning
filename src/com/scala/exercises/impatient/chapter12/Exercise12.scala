package com.scala.exercises.impatient.chapter12

import com.scala.exercises.ScalaExercise
import com.scala.interfaces.Exercise

/**
 * Created by Who on 14-7-13.
 */
class Exercise12 extends ScalaExercise with Exercise {
  override def getName: String = "Exercise12"

  addT(
    () => {
      import scala.math._
      val num = 3.14
      val fun = ceil _
    }
  )

  addT(
    () => {
      val fun: Double => Double = 3 * _

      print
      (1 to 9).map("*" * _).foreach(print _)
    }
  )

  addT(
    () => {
      print
      (1 to 9).map("*" * _).foreach(print _)
      print((1 to 9).map(_.toString))
    }
  )

  addT(
    () => {
      print((1 to 9).reduceLeft(_ * _))
    }
  )

  addT(
    () => {
      print("Mary has a little lamb".split(" ").sortWith(_.length < _.length))
    }
  )

  addT(
    () => {
      def mul(x: Int, y: Int) = {
        x * y
      }

      def mulOneAtATime(x: Int) = {
        (y: Int) => x * y
      }

      print(mul(2, 3))

      print(mulOneAtATime(2)(3))
    }
  )

  addT(
    () => {
      def mulOneAtATime(x: Int)(y: Int) = {
        x * y
      }
    }
  )

  addT(
    () => {
      val a = Array("1", "2")
      val b = Array("hello", "world")
      val c = Array(1, "2", true)
      val d = Array(1, 2)
      var result = a.corresponds(b)(_.equalsIgnoreCase(_))
      print(result)
      result = a.corresponds(d)(_ == _)
      print(result)
    }
  )

  addT(
    () => {
      def runInThread(block: () => Unit) {
        new Thread {
          override def run() {
            block()
          }
        }.start()
      }

      runInThread {
        () => print("Hi"); Thread.sleep(1000); print("Bye")
      }
    }
  )

  addT(
    () => {
      def runInThread(block: => Unit) {
        new Thread {
          override def run() {
            block
          }
        }.start()
      }

      runInThread({
        print("Hi");
        Thread.sleep(1000);
        print("Bye")
      }
      )
    }
  )

  addT(
    () => {
      def until(condition: => Boolean)(block: => Unit) {
        if (!condition) {
          block
          until(condition)(block)
        }
      }

      var x = 10
      until(x == 0) {
        x -= 1
        print(x)
      }
    }
  )

  addQ(
    () => {
      def values(fun: Int => Int, low: Int, high: Int) = {
        for (i <- low to high) yield (i, fun(i))
      }

      print(values(x => x * x, -5, 5))
    }
  )

  addQ(
    () => {
      val array = Array[Int](1, 2, 3, 4, 5)
      var max = array.reduceLeft(_.max(_))
      max = array.reduceLeft(_ max _)
      print(max)
    }
  )

  addQ(
    () => {
      val array = Array[Int](1, 2, 3, 4, 5)
      print(array.reduceLeft(_ * _))
    }
  )

  addQ(
    () => {

    }
  )
}