package tokenVisitors

import tokens.*

interface ITokenVisitor {

    fun visit(token: TBraceLeft)
    fun visit(token: TBraceRight)
    fun visit(token: TNumber)
    fun visit(token: TOperation)

}