package tokenizer.states

import tokenizer.Tokenizer
import tokens.TOperation

class SOperation(private val op: Char) : IState {

    override fun handleBraceLeft() {
        Tokenizer.tokens.add(TOperation(op))
        Tokenizer.state = SBraceLeft()
    }

    override fun handleBraceRight() = throw Exception("Illegal symbol ) after $op")

    override fun handleDigit(digit : Char) {
        Tokenizer.tokens.add(TOperation(op))
        Tokenizer.state = SNumber(digit)
    }

    override fun handleOperation(op_ : Char) = throw Exception("Illegal symbol $op_ after $op")

    override fun handleSpace() { }

    override fun handleEOL() = throw Exception("Illegal symbol $op at the end of line")

}