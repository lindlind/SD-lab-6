package tokenizer

import tokenizer.states.*
import tokens.IToken

object Tokenizer {

    var state : IState = SStart()
    var tokens = mutableListOf<IToken>()

    private fun reset() {
        state = SStart()
        tokens = mutableListOf()
    }

    fun tokenize(s: String): List<IToken> {
        reset()

        for (symbol in s) {
            when (symbol) {
                ' ' -> state.handleSpace()
                in '0'..'9' -> state.handleDigit(symbol)
                in listOf('+', '-', '*', '/') -> state.handleOperation(symbol)
                '(' -> state.handleBraceLeft()
                ')' -> state.handleBraceRight()
                else -> Exception("Illegal symbol $symbol")
            }
        }
        state.handleEOL()

        return tokens.toList()
    }

}