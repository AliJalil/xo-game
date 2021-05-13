package com.example.xo


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import java.util.*
import kotlin.collections.ArrayList
//import com.example.xo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    lateinit var but1: Button
//    lateinit var but2: Button
//    lateinit var but3: Button
//    lateinit var but4: Button
//    lateinit var but5: Button
//    lateinit var but6: Button
//    lateinit var but7: Button
//    lateinit var but8: Button
//    lateinit var but9: Button

    private var player1 = ArrayList<Int>()
    private var player2 = ArrayList<Int>()
    var activePlayer = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )
//
//        but1 = binding.button1
//        but2 = binding.button2
//        but3 = binding.button3
//        but4 = binding.button4
//        but5 = binding.button5
//        but6 = binding.button6
//        but7 = binding.button7
//        but8 = binding.button8
//        but9 = binding.button9


    }


    fun butClicked(view: View) {
        val butSelected = view as Button
        var cellId = 0
        when (butSelected.id) {
            R.id.button1 -> cellId = 1
            R.id.button2 -> cellId = 2
            R.id.button3 -> cellId = 3
            R.id.button4 -> cellId = 4
            R.id.button5 -> cellId = 5
            R.id.button6 -> cellId = 6
            R.id.button7 -> cellId = 7
            R.id.button8 -> cellId = 8
            R.id.button9 -> cellId = 9
        }
        playGame(cellId, butSelected)
        Toast.makeText(baseContext, "cellId $cellId", Toast.LENGTH_SHORT).show()

    }


    private fun playGame(cellId: Int, butSelected: Button) {

        if (activePlayer == 1) {
            butSelected.setBackgroundColor(Color.parseColor("#009193"))
            butSelected.background = ContextCompat.getDrawable(this, R.drawable.ic_x);
            player1.add(cellId)
            activePlayer = 2

            AutoPlay()
        } else {
            butSelected.background = ContextCompat.getDrawable(this, R.drawable.ic_o);
            player2.add(cellId)
            activePlayer = 1
        }
        butSelected.isEnabled = false
        checkWinner()
    }


    private fun checkWinner() {
        var winner = -1

        //Rows
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) winner = 1
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) winner = 2

        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) winner = 1
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) winner = 2

        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) winner = 1
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) winner = 2


        //Columns
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) winner = 1
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) winner = 2


        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) winner = 1
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) winner = 2

        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) winner = 1
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) winner = 2


        //Diagonals
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) winner = 1
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) winner = 2

        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) winner = 1
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) winner = 2


        if (winner == 1) {
            val intent = Intent(this, MainActivity2::class.java)
            MainActivity2.winnerPlayerTxt = "Player1 Win"
            startActivity(intent)
        }
        if (winner == 2) {
            val intent = Intent(this, MainActivity2::class.java)
            MainActivity2.winnerPlayerTxt = "Player2 Win"
            startActivity(intent)
        }
    }


//    private fun AutoPlay() {
//        val emptyCells=ArrayList<Int>()
//        for (cellID in 1..9){
//            if(!(player1.contains(cellID) || player2.contains(cellID))){
//                emptyCells.add(cellID)
//            }
//        }
//
//        val r = Random()
//        val randIndex = r.nextInt(emptyCells.size-0)+0
//        val cellID = emptyCells[randIndex]
//
//        var buSelected:Button
//        when(cellID){
//            1->buSelected = but1
//            2-> buSelected= but2
//            3-> buSelected= but3
//            4-> buSelected= but4
//            5-> buSelected= but5
//            6-> buSelected= but6
//            7-> buSelected= but7
//            8-> buSelected= but8
//            9-> buSelected= but9
//            else -> buSelected = but1
//
//        }
//        playGame(cellID,buSelected)
//    }
}