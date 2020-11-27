package tokenVisitors

import tokens.IToken
import tokens.*

class ParserVisitor : ITokenVisitor {

    private var result = mutableListOf<IToken>()
    private var operationsStack = mutableListOf<IToken>()

    override fun visit(token: TBraceLeft) {
        operationsStack.add(token)
    }

    override fun visit(token: TBraceRight) {
        while (operationsStack.isNotEmpty()) {
            val opToken = operationsStack.removeLast()
            if (opToken is TBraceLeft) {
                return
            }
            result.add(opToken)
        }
        throw Exception("Incorrect bracket sequence")
    }

    override fun visit(token: TNumber) {
        result.add(token)
    }

    override fun visit(token: TOperation) {
        val opsToRemove = when (token.op) {
            in listOf('*', '/') -> listOf('*', '/')
            else -> listOf('+', '-', '*', '/')
        }
        while (operationsStack.isNotEmpty()) {
            val opToken = operationsStack.last()
            if (opToken is TOperation && opToken.op in opsToRemove) {
                result.add(operationsStack.removeLast())
            } else {
                break
            }
        }
        operationsStack.add(token)
    }

    fun getResult(): List<IToken> {
        while (operationsStack.isNotEmpty()) {
            val opToken = operationsStack.removeLast()
            if (opToken is TBraceLeft) {
                throw Exception("Incorrect bracket sequence")
            }
            result.add(opToken)
        }
        return result.toList()
    }

}