package tokens

import tokenVisitors.ITokenVisitor

class TBraceLeft : IToken {

    override fun acceptVisitor(visitor: ITokenVisitor) = visitor.visit(this)

}