package tokenizer.states

import tokenizer.Tokenizer
import tokens.TNumber

class SNumber(digit: Char) : IState {

    private var n = Character.getNumericValue(digit).toLong()

    override fun handleBraceLeft() = throw Exception("Illegal symbol ( after digit")

    override fun handleBraceRight() {
        Tokenizer.tokens.add(TNumber(n))
        Tokenizer.state = SBraceRight()
    }

    override fun handleDigit(digit : Char) {
        if (n > 1e8) {
            throw ArithmeticException("Too large number $n...")
        }
        n = 10 * n + Character.getNumericValue(digit)
    }

    override fun handleOperation(op : Char) {
        Tokenizer.tokens.add(TNumber(n))
        Tokenizer.state = SOperation(op)
    }

    override fun handleSpace() {
        Tokenizer.tokens.add(TNumber(n))
        Tokenizer.state = SSpaceAfterNumber()
    }

    override fun handleEOL() {
        Tokenizer.tokens.add(TNumber(n))
        Tokenizer.state = SFinish()
    }

}
