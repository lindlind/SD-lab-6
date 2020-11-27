package tokenizer.states

import tokenizer.Tokenizer

class SStart : IState {

    override fun handleBraceLeft() { Tokenizer.state = SBraceLeft() }

    override fun handleBraceRight() = throw Exception("Illegal start symbol )")

    override fun handleDigit(digit : Char) { Tokenizer.state = SNumber(digit) }

    override fun handleOperation(op : Char) = throw Exception("Illegal start symbol $op")

    override fun handleSpace() { }

    override fun handleEOL() = throw Exception("Empty line!")

}