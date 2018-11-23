package com.warmcheese.tictactoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_game.*
import java.util.Random

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        // get references to ImageViews
        val imageViewYou = findViewById<ImageView>(R.id.imageViewYou)
        val imageViewOpponent = findViewById<ImageView>(R.id.imageViewOpponent)
        val ivPlayerMove = findViewById<ImageView>(R.id.ivPlayerMove)
        val ivComputerMove = findViewById<ImageView>(R.id.ivComputerMove)
        val ivGrid1 = findViewById<ImageView>(R.id.ivGrid1)
        val ivGrid2 = findViewById<ImageView>(R.id.ivGrid2)
        val ivGrid3 = findViewById<ImageView>(R.id.ivGrid3)
        val ivGrid4 = findViewById<ImageView>(R.id.ivGrid4)
        val ivGrid5 = findViewById<ImageView>(R.id.ivGrid5)
        val ivGrid6 = findViewById<ImageView>(R.id.ivGrid6)
        val ivGrid7 = findViewById<ImageView>(R.id.ivGrid7)
        val ivGrid8 = findViewById<ImageView>(R.id.ivGrid8)
        val ivGrid9 = findViewById<ImageView>(R.id.ivGrid9)

        // store gameboard references in array
        var ivGameBoardReferences = arrayOf<ImageView>(ivGrid1, ivGrid2, ivGrid3, ivGrid4, ivGrid5, ivGrid6,
            ivGrid7, ivGrid8, ivGrid9)

        // get data passed from main activity for player1
        val intent = intent
        val selectedCharacter:String = intent.getStringExtra("character")

        // display player ImageView
        val player:Int = resources.getIdentifier("@drawable/$selectedCharacter", null, this.packageName)
        imageViewYou.setImageResource(player)

        //display computer ImageView
        val randomCharacter:String = getOpponent(selectedCharacter)
        val computer:Int = resources.getIdentifier("@drawable/$randomCharacter", null, this.packageName)
        imageViewOpponent.setImageResource(computer)

        playGame(ivGameBoardReferences, player, computer)

    }

    // get a random opponent using random number generator
    private fun getOpponent(selectedCharacter:String): String {
        var randomNumber = Random().nextInt((6 - 1) + 1)

        while(selectedCharacter == "c$randomNumber") {
            randomNumber = Random().nextInt((6 - 1) + 1)
        }
        return "c$randomNumber"
    }

    private fun playGame(ivGameBoardReferences:Array<ImageView>, player:Int, computer:Int) {
        var playerMove:Boolean = true
        var gameBoard = Array<Int>(9, {0})
        val playerChoice = 1
        val computerChoice = 2

        for(i in ivGameBoardReferences.indices) {
            ivGameBoardReferences[i].setOnClickListener {
                if(playerMove) {
                    ivPlayerMove.visibility = View.INVISIBLE
                    ivComputerMove.visibility = View.VISIBLE
                    ivGameBoardReferences[i].setImageResource(player)
                    gameBoard[i] = playerChoice

                    var winner = calculateWinner(gameBoard)
                    if(winner == 1) {
                        val intent = Intent(applicationContext, FinalActivity::class.java)
                        intent.putExtra("winner", player)
                        startActivity(intent)
                    }

                    playerMove = false
                }
                else {
                    ivPlayerMove.visibility = View.VISIBLE
                    ivComputerMove.visibility = View.INVISIBLE
                    ivGameBoardReferences[i].setImageResource(computer)
                    gameBoard[i] = computerChoice

                    var winner = calculateWinner(gameBoard)
                    if(winner == 2) {
                        val intent = Intent(applicationContext, FinalActivity::class.java)
                        intent.putExtra("winner", computer)
                        startActivity(intent)
                    }

                    playerMove = true
                }
            }
        }
    }

    private fun calculateWinner(gameBoard:Array<Int>) : Int {

        val wl1 = WinningLine(0,1,2)
        val wl2 = WinningLine(3,4,5)
        val wl3 = WinningLine(6,7,8)
        val wl4 = WinningLine(0,3,6)
        val wl5 = WinningLine(1,4,7)
        val wl6 = WinningLine(2,5,8)
        val wl7 = WinningLine(0,4,8)
        val wl8 = WinningLine(2,4,6)

        val winningLines = arrayOf<WinningLine>(wl1,wl2,wl3,wl4,wl5,wl6,wl7,wl8)

        for(wl in winningLines) {
            var a = wl.indexOne
            var b = wl.indexTwo
            var c = wl.indexThree


            if(gameBoard[a] == gameBoard[b] && gameBoard[a] == gameBoard[c]) {
                return gameBoard[a]
            }
        }
        return 0
    }

}
