package tokens

import tokenVisitors.ITokenVisitor

class TOperation(val op: Char) : IToken {

    override fun acceptVisitor(visitor: ITokenVisitor) = visitor.visit(this)

}