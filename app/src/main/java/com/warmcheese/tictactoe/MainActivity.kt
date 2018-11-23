package com.warmcheese.tictactoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get reference to ImageViews
        val ivCharacter1 = findViewById<ImageView>(R.id.ivCharacter1)
        val ivCharacter2 = findViewById<ImageView>(R.id.ivCharacter2)
        val ivCharacter3 = findViewById<ImageView>(R.id.ivCharacter3)
        val ivCharacter4 = findViewById<ImageView>(R.id.ivCharacter4)
        val ivCharacter5 = findViewById<ImageView>(R.id.ivCharacter5)
        val ivCharacter6 = findViewById<ImageView>(R.id.ivCharacter6)

        ivCharacter1.setOnClickListener {
            val intent = Intent(applicationContext, GameActivity::class.java)
            intent.putExtra("character", "c1")
            startActivity(intent)
        }

        ivCharacter2.setOnClickListener {
            val intent = Intent(applicationContext, GameActivity::class.java)
            intent.putExtra("character", "c2")
            startActivity(intent)
        }

        ivCharacter3.setOnClickListener {
            val intent = Intent(applicationContext, GameActivity::class.java)
            intent.putExtra("character", "c3")
            startActivity(intent)
        }

        ivCharacter4.setOnClickListener {
            val intent = Intent(applicationContext, GameActivity::class.java)
            intent.putExtra("character", "c4")
            startActivity(intent)
        }

        ivCharacter5.setOnClickListener {
            val intent = Intent(applicationContext, GameActivity::class.java)
            intent.putExtra("character", "c5")
            startActivity(intent)
        }

        ivCharacter6.setOnClickListener {
            val intent = Intent(applicationContext, GameActivity::class.java)
            intent.putExtra("character", "c6")
            startActivity(intent)
        }
    }
}
