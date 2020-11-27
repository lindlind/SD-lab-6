package tokenVisitors

import tokens.*
import java.lang.IllegalStateException

class PrinterVisitor : ITokenVisitor {

    private var result = ""

    override fun visit(token: TBraceLeft)  = throw IllegalStateException("No braces to print")
    override fun visit(token: TBraceRight) = throw IllegalStateException("No braces to print")
    override fun visit(token: TNumber)    { result += token.number.toString() + " " }
    override fun visit(token: TOperation) { result += token.op + " " }

    fun getResult() = result

}