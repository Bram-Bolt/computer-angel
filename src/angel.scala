@main def angel(): Unit = {
    println("Welcome!")
    val lines = List("Hallo!", "Ik hou van pindakaas!", "doei..")
    println(buildSpeechBubble(lines))
}

def buildSpeechBubble(lines: List[String]): String = {
    val bubble = " "
    val longest = getLongestLine(lines)
    val x = bubble + getBar(longest, false) + getBar(longest, true)
    x
}

def quote(lines: List[String]): String = {
    lines.length match = {
        case 0 => "< ... >"
        case 1 => s"<${lines(0)}>"
        case 2 => advancedBubble(lines)
    }
}

def getMargin(line: Int, maxLine: Int): String {
    val diff = maxLine - line
    " " * diff
}

def advancedBubble(lines:List[String], maxLine: Int): String {
    def middleBubble(lines:List[String]): String{
        case Nil => ""
        case x => s"\\ ${lines.last}${getMargin(lines.last.length, maxLine)} /" + middleBubble(Nil)
        case x::xs => s"| ${lines.last}${getMargin(lines.last.length, maxLine)} |" + middleBubble(xs)
    }
    s"/ ${lines(0)}${getMargin(lines(0).length,linemaxLine)} \\" + middleBubble(lines.tail)
}



def getBar(len: Int, bottom: Boolean): String = {
    if (bottom) "-" * (len + 2) + "\n"
    else "_" * (len + 2)  + "\n"
}

def getLongestLine(lines: List[String]): Int = {
    val lengths = lines.map(x => x.length)
    def getMax(lengths: List[Int], max: Int): Int = {
    lengths match {
        case Nil => max
        case x::xs => if (x > max) getMax(xs, x)
                      else getMax(xs, max)    
    }
    }
    getMax(lengths, 0)
}