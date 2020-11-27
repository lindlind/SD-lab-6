package tokens

import tokenVisitors.ITokenVisitor

class TBraceRight : IToken {

    override fun acceptVisitor(visitor: ITokenVisitor) = visitor.visit(this)

}