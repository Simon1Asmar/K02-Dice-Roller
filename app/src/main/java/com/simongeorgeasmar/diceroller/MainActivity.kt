package com.simongeorgeasmar.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/** This Activity allows the user to toll a dice and view the result on the screen **/
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * rolls dice and updates text in textView with the result
     * **/
    private fun rollDice() {
        //Creates Dice object with numSides = 6 and rolls it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Changes the imageView passing it the ID of dice_2 image
        val diceImage: ImageView = findViewById(R.id.imageView)
        diceImage.setImageResource(R.drawable.dice_2)

    }
}

class Dice(private val numSides: Int) {
    //Returns a random Int value between the IntRange of 1 and number of sides
    fun roll(): Int {
        return (1..numSides).random()
    }
}

//REMOVED LINES I'M KEEPING TO REMEMBER

//HOT TO MAKE A TOAST
//val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
//toast.show()
//OR
//val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
