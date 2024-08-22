file://<WORKSPACE>/angel.scala
### dotty.tools.dotc.ast.Trees$UnAssignedTypeException: type of Ident(numbers) is not assigned

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
offset: 120
uri: file://<WORKSPACE>/angel.scala
text:
```scala
@main def angel(): Unit = {
    println("Welcome!")
}

def getLongestLine(lines: List[String]): Int = {
    val numbers[@@lines.map(x => x.length)
    def getMax(numbers, max)
}
```



#### Error stacktrace:

```
dotty.tools.dotc.ast.Trees$Tree.tpe(Trees.scala:74)
	dotty.tools.dotc.util.Signatures$.applyCallInfo(Signatures.scala:207)
	dotty.tools.dotc.util.Signatures$.computeSignatureHelp(Signatures.scala:104)
	dotty.tools.dotc.util.Signatures$.signatureHelp(Signatures.scala:88)
	dotty.tools.pc.SignatureHelpProvider$.signatureHelp(SignatureHelpProvider.scala:53)
	dotty.tools.pc.ScalaPresentationCompiler.signatureHelp$$anonfun$1(ScalaPresentationCompiler.scala:391)
```
#### Short summary: 

dotty.tools.dotc.ast.Trees$UnAssignedTypeException: type of Ident(numbers) is not assigned