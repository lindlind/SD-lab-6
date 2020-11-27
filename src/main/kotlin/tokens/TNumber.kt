package tokens

import tokenVisitors.ITokenVisitor

class TNumber(val number : Long) : IToken {

    override fun acceptVisitor(visitor: ITokenVisitor) = visitor.visit(this)

}