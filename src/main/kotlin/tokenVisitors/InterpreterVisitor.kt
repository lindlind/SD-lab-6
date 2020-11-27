package tokenVisitors

import tokens.TBraceLeft
import tokens.TBraceRight
import tokens.TNumber
import tokens.TOperation
import java.lang.IllegalStateException

class InterpreterVisitor : ITokenVisitor {

    private var valueStack = mutableListOf<Long>()

    private fun tokenToFunctionConvertor(token: TOperation) = when (token.op) {
        '+' -> { a: Long, b: Long -> a + b }
        '-' -> { a: Long, b: Long -> a - b }
        '*' -> { a: Long, b: Long -> a * b }
        '/' -> { a: Long, b: Long -> a.div(b) }
        else -> throw IllegalStateException("No other operations")
    }

    override fun visit(token: TBraceLeft) = throw IllegalStateException("No braces to interpret")
    override fun visit(token: TBraceRight) = throw IllegalStateException("No braces to interpret")

    override fun visit(token: TNumber) {
        valueStack.add(token.number)
    }

    override fun visit(token: TOperation) {
        val b = valueStack.removeLast()
        val a = valueStack.removeLast()
        valueStack.add(tokenToFunctionConvertor(token)(a, b))
    }

    fun getResult() =
        if (valueStack.size == 1) valueStack.last()
        else throw IllegalStateException("Something goes wrong, check parser")

}