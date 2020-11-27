import tokenVisitors.InterpreterVisitor
import tokenVisitors.ParserVisitor
import tokenVisitors.PrinterVisitor
import tokenizer.Tokenizer

fun main(args: Array<String>) {
    val stringToCalculate = readLine()!!

    try {
        val infixTokens = Tokenizer.tokenize(stringToCalculate)

        val postfixTokens = run {
            val parser = ParserVisitor()
            infixTokens.forEach { it.acceptVisitor(parser) }
            parser.getResult()
        }

        val postfixTokensAsString = run {
            val printer = PrinterVisitor()
            postfixTokens.forEach { it.acceptVisitor(printer) }
            printer.getResult()
        }
        println(postfixTokensAsString)

        val calculatedResult = run {
            val interpreter = InterpreterVisitor()
            postfixTokens.forEach { it.acceptVisitor(interpreter) }
            interpreter.getResult()
        }

        println(calculatedResult)

    } catch (e: Exception) {
        println(e.message)
    }

}