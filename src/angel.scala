@main def angel(): Unit = {
    println("Welcome!")
    val lines = List("Hallo!", "Ik hou van pindakaas!", "doei..")
    println(getLongestLine(lines))
}

def buildSpeechBubble(): String = {
    val bubble = " "

}

def getBar(len: Int, bottom: Bool): String = {
    if (bottom) "-" * len
    else "_" * len
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