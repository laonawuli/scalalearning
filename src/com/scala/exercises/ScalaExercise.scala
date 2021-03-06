package com.scala.exercises

import scala.collection.mutable.ArrayBuffer

/**
 * Created by Who on 2014/7/5.
 */
abstract class ScalaExercise extends BaseExercise {

  val questionList: ArrayBuffer[Question] = ArrayBuffer[Question]()
  val tryList: ArrayBuffer[Try] = ArrayBuffer[Try]()

  override def getSummary(): String = {
    getName
  }

  override def run(): Unit = {
    runTrys()
    runQuestions()
  }

  def runQuestions(): Unit = {
    for (question <- questionList) {
      super.print(question.name)
      question.answer()
      super.print()
    }
  }

  def runTrys(): Unit = {
    for (t <- tryList) {
      super.print(t.name)
      t.t()
      super.print()
    }
  }

  protected def addQ() {
    questionList += new Question("Question" + Question.getCounter)
  }

  protected def addQ(answer: () => Unit) {
    addQ("Question" + Question.getCounter, answer)
  }

  protected def addQ(name: String, answer: () => Unit) {
    questionList += new Question(name, answer)
  }

  protected def addT(t: () => Unit) {
    addT("Try" + Try.getCounter, t)
  }

  protected def addT(name: String, t: () => Unit) {
    tryList += new Try(name, t)
  }
}

class Question(val name: String, val answer: () => Unit = () => Unit) {

}

object Question {
  var counter = 0

  def getCounter = {
    counter += 1
    counter
  }
}

class Try(val name: String, val t: () => Unit) {

}

object Try {
  var counter = 0

  def getCounter = {
    counter += 1
    counter
  }
}