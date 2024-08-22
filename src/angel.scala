@main def angel(): Unit = {
  println("Programming compiled!")
  val lines0 = List(" ")
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
  getTopBar(longest) + getQuoteBubble(lines) + getBottomBar(longest)
}

def getQuoteBubble(lines: List[String]): String = {
  lines.length match {
    case 0 | 1 => getSingleBubble(lines)
    case _     => getMultiBubble(lines)
  }
}

def getMargin(lineLength: Int, maxLineLength: Int): String = {
  " " * (maxLineLength - lineLength)
}

def getSingleBubble(lines: List[String]): String = {
  val maxLine = getLongestLine(lines)
  lines match {
    case Nil => "< ... >\n"
    case _   => s"< ${lines.head}${getMargin(lines.head.length, maxLine)} >\n"
  }
}

def getMultiBubble(lines: List[String]): String = {
  val maxLine = getLongestLine(lines)
  val top = s"/ ${lines(0)}${getMargin(lines(0).length, maxLine)} \\\n"
  val middle =
    if (lines.length > 2)
      lines
        .slice(1, lines.length - 1)
        .map { line =>
          s"| ${line}${getMargin(line.length, maxLine)} |"
        }
        .mkString("\n") + "\n"
    else ""
  val bottom = s"\\ ${lines.last}${getMargin(lines.last.length, maxLine)} /\n"

  top + middle + bottom
}

def getBottomBar(len: Int): String = {
  " " + ("-" * (len + 2)) + "\n"
}

def getTopBar(len: Int): String = {
  " " + ("-" * (len + 2)) + "\n"
}

def getLongestLine(lines: List[String]): Int = {
  if (lines == Nil) 3
  else {
    val lengths = lines.map(x => x.length)
    def getMax(lengths: List[Int], max: Int): Int = {
      lengths match {
        case Nil => max
        case x :: xs =>
          if (x > max) getMax(xs, x)
          else getMax(xs, max)
      }
    }
    getMax(lengths, 3)
  }
}
