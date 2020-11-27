package tokenizer.states

import tokenizer.Tokenizer
import tokens.TBraceRight

class SBraceRight : IState {

    override fun handleBraceLeft() = throw Exception("Illegal symbol ( after )")

    override fun handleBraceRight() {
        Tokenizer.tokens.add(TBraceRight())
    }

    override fun handleDigit(digit: Char) = throw Exception("Illegal symbol $digit after )")

    override fun handleOperation(op: Char) {
        Tokenizer.tokens.add(TBraceRight())
        Tokenizer.state = SOperation(op)
    }

    override fun handleSpace() { }

    override fun handleEOL() {
        Tokenizer.tokens.add(TBraceRight())
        Tokenizer.state = SFinish()
    }

}