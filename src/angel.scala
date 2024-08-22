@main def angel(): Unit = {
  println("Programming compiled!")
  val lines0 = List("")
  val lines1 = List("Hallo!")
  val lines2 = List("Hallo!", "Ik hou van pindakaas!")
  val lines3 = List("Hallo!", "Ik hou van pindakaas!", "doei..")
  // println(buildSpeechBubble(lines))
  println(getSpeechBubble(lines0))
  println(getSpeechBubble(lines1))
  println(getSpeechBubble(lines2))
  println(getSpeechBubble(lines3))
}

def getSpeechBubble(lines: List[String]): String = {
  val longest = getLongestLine(lines)
  val x = getBar(longest, false) + getQuote(lines) + getBar(longest, true)
  x
}

def getQuote(lines: List[String]): String = {
  lines.length match {
    case 1 => s"< ${lines(0)} >\n"
    case _ => advancedBubble(lines)
  }
}

def getMargin(line: Int, maxLine: Int): String = {
  val diff = (maxLine - line)
  " " * diff
}

def advancedBubble(lines: List[String]): String = {
  val maxLine = getLongestLine(lines)
  def middleBubble(lines: List[String]): String = {
    lines match {
      case Nil => ""
      case x :: Nil =>
        s"\\ ${x}${getMargin(x.length, maxLine)} /\n" + middleBubble(Nil)
      case x :: xs =>
        s"| ${x}${getMargin(x.length, maxLine)} |\n" + middleBubble(xs)
    }
  }
  s"/ ${lines(0)}${getMargin(lines(0).length, maxLine)} \\\n" + middleBubble(
    lines.tail
  )
}

def getBar(len: Int, bottom: Boolean): String = {
  val lineChar = if (bottom) '-' else '_'
  " " + (lineChar.toString * (len + 2)) + "\n"
}

def getLongestLine(lines: List[String]): Int = {
  val lengths = lines.map(x => x.length)
  def getMax(lengths: List[Int], max: Int): Int = {
    lengths match {
      case Nil => max
      case x :: xs =>
        if (x > max) getMax(xs, x)
        else getMax(xs, max)
    }
  }
  getMax(lengths, 0)
}
