package com.warmcheese.tictactoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class FinalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        // get ImageView reference
        val ivWinner = findViewById<ImageView>(R.id.ivWinner)

        // get data passed from main activity for player1
        val intent = intent
        val winner:Int = intent.getIntExtra("winner", 0)

        // display winner ImageView
        ivWinner.setImageResource(winner)
    }
}
