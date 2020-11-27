package tokens

import tokenVisitors.ITokenVisitor

interface IToken {

    fun acceptVisitor(visitor: ITokenVisitor)

}