package tokenizer.states

interface IState {

    fun handleBraceLeft()
    fun handleBraceRight()
    fun handleDigit(digit : Char)
    fun handleOperation(op : Char)
    fun handleSpace()
    fun handleEOL()

}