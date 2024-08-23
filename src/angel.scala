@main def angel(): Unit = {
  println("Compilation succesful yippee")
  val lines0 = List()
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
  val topBar = getTopBar(longest)
  val quoteBubble = getQuoteBubble(lines, longest)
  val bottomBar = getBottomBar(longest)

  topBar + quoteBubble + bottomBar
}

def getQuoteBubble(lines: List[String], longest: Int): String = {
  lines.length match {
    case 0 | 1 => getSingleBubble(lines, longest)
    case _     => getMultiBubble(lines, longest)
  }
}

def getMargin(lineLength: Int, maxLineLength: Int): String = {
  " " * (maxLineLength - lineLength)
}

def getSingleBubble(lines: List[String], longest: Int): String = {
  lines match {
    case Nil => "| ... |\n"
    case _   => s"| ${lines.head}${getMargin(lines.head.length, longest)} |\n"
  }
}

def getMultiBubble(lines: List[String], longest: Int): String = {
  val top = s"/ ${lines(0)}${getMargin(lines(0).length, longest)} \\\n"
  val middle =
    if (lines.length > 2)
      lines
        .slice(1, lines.length - 1)
        .map { line =>
          s"| ${line}${getMargin(line.length, longest)} |"
        }
        .mkString("\n") + "\n"
    else ""
  val bottom = s"\\ ${lines.last}${getMargin(lines.last.length, longest)} /\n"

  top + middle + bottom
}

def getBottomBar(len: Int): String = {
  " " + ("-" * (len + 2)) + "\n"
}

def getTopBar(longestLineLength: Int): String = {
  val center = (longestLineLength - 3) / 2
  val angelTop = (" " * (center + 1)) + "  _\n"
  val angelMiddle = (" " * (center + 1)) + "(\\o/)\n"
  val angleBottom = " " + ("_" * center) + "_/_\\_" + ("_" * center)
  val suffix =
    if (longestLineLength % 2 == 0) "_\n"
    else "\n"
  angelTop + angelMiddle + angleBottom + suffix
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
