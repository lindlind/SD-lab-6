package tokenizer.states

import java.lang.IllegalStateException

class SFinish : IState {

    override fun handleBraceLeft() = throw IllegalStateException("No characters after EOL")
    override fun handleBraceRight() = throw IllegalStateException("No characters after EOL")
    override fun handleDigit(digit : Char) = throw IllegalStateException("No characters after EOL")
    override fun handleOperation(op : Char) = throw IllegalStateException("No characters after EOL")
    override fun handleSpace() = throw IllegalStateException("No characters after EOL")
    override fun handleEOL() = throw IllegalStateException("No characters after EOL")

}