package com.simongeorgeasmar.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
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

        //updates the text in the TextView
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()

        //PRACTICE ON YOUR OWN
        //Creates another instance of Dice with 6 sides and rolls it
        val dice2 = Dice(6)
        val dice2Roll = dice2.roll()

        //updates text in textView2
        val resultTextView2: TextView = findViewById(R.id.textView2)
        resultTextView2.text = dice2Roll.toString()


    }
}

class Dice(private val numSides: Int) {
    //Returns a random Int value between 1 and number of sides
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
