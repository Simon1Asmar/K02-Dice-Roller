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

        //does a dice roll on create so that it looks better for the user and easier for them to understand
        rollDice()
    }

    /**
     * roll dice and update the ImageView based on the result
     * **/
    private fun rollDice() {
        //Creates Dice object with numSides = 6 and rolls it
        val dice = Dice(6)
        val diceRoll = dice.roll()


        val diceImage: ImageView = findViewById(R.id.imageView)

        /**
         * Create drawable resource variable and saves the resource ID value in it
         * **/
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //Update ImageView with correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        //Update the content desc for ImageView for screen readers
        diceImage.contentDescription = diceRoll.toString()

    }
}

class Dice(private val numSides: Int) {
    //Return a random Int value between the IntRange of 1 and number of sides
    fun roll(): Int {
        return (1..numSides).random()
    }
}