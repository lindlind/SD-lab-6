package tokenizer.states

import tokenizer.Tokenizer

class SSpaceAfterNumber : IState {

    override fun handleBraceLeft() = throw Exception("Illegal symbol ( after number")

    override fun handleBraceRight() { Tokenizer.state = SBraceRight() }

    override fun handleDigit(digit : Char) = throw Exception("Illegal symbol $digit after number")

    override fun handleOperation(op : Char) { Tokenizer.state = SOperation(op) }

    override fun handleSpace() { }

    override fun handleEOL() { Tokenizer.state = SFinish() }

}