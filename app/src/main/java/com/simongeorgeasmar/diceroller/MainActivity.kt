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


        val diceImage: ImageView = findViewById(R.id.imageView)

        /**
         * Creates drawable resource variable and saves the resource ID value in it
         * **/
        val drawableResource = when (diceRoll) {
            //If user rolls a 1, give drawableResource value of dice_1 img resource ID
            1 -> R.drawable.dice_1
            //If user rolls a 2, give drawableResource value of dice_2 img resource ID
            2 -> R.drawable.dice_2
            //If user rolls a 3, give drawableResource value of dice_3 img resource ID
            3 -> R.drawable.dice_3
            //If user rolls a 4, give drawableResource value of dice_4 img resource ID
            4 -> R.drawable.dice_4
            //If user rolls a 5, give drawableResource value of dice_5 img resource ID
            5 -> R.drawable.dice_5
            //else give drawableResource value of dice_6 img resource ID
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        //sets a content desc for ImageView for screen readers
        diceImage.contentDescription = diceRoll.toString()

    }
}

class Dice(private val numSides: Int) {
    //Returns a random Int value between the IntRange of 1 and number of sides
    fun roll(): Int {
        return (1..numSides).random()
    }
}