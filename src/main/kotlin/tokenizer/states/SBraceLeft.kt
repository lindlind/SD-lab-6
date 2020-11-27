package tokenizer.states

import tokenizer.Tokenizer
import tokens.TBraceLeft

class SBraceLeft : IState {

    override fun handleBraceLeft() {
        Tokenizer.tokens.add(TBraceLeft())
    }

    override fun handleBraceRight() = throw Exception("Illegal symbol ) after (")

    override fun handleDigit(digit: Char) {
        Tokenizer.tokens.add(TBraceLeft())
        Tokenizer.state = SNumber(digit)
    }

    override fun handleOperation(op: Char) = throw Exception("Illegal symbol $op after (")

    override fun handleSpace() { }

    override fun handleEOL() = throw Exception("Illegal symbol ( at the end of line")

}