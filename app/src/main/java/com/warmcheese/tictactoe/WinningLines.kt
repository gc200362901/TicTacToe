package com.warmcheese.tictactoe

class WinningLines {

    private val winningLines:Array<WinningLine>

    constructor() {
        val wl1 = WinningLine(0,1,2)
        val wl2 = WinningLine(3,4,5)
        val wl3 = WinningLine(6,7,8)
        val wl4 = WinningLine(0,3,6)
        val wl5 = WinningLine(1,4,7)
        val wl6 = WinningLine(2,5,8)
        val wl7 = WinningLine(0,4,8)
        val wl8 = WinningLine(2,4,6)

        winningLines = arrayOf<WinningLine>(wl1,wl2,wl3,wl4,wl5,wl6,wl7,wl8)
    }

    fun getWinningLines() : Array<WinningLine> {
        return winningLines
    }

}