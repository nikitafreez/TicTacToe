package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        but_1.isEnabled = false
        but_2.isEnabled = false
        but_3.isEnabled = false
        but_4.isEnabled = false
        but_5.isEnabled = false
        but_6.isEnabled = false
        but_7.isEnabled = false
        but_8.isEnabled = false
        but_9.isEnabled = false
        but_restart.isEnabled = false
        but_players.isEnabled = false
    }

    fun startClick(view: View){
        but_1.isEnabled = true
        but_2.isEnabled = true
        but_3.isEnabled = true
        but_4.isEnabled = true
        but_5.isEnabled = true
        but_6.isEnabled = true
        but_7.isEnabled = true
        but_8.isEnabled = true
        but_9.isEnabled = true
        but_restart.isEnabled = true
        but_players.isEnabled = true
        but_start.isEnabled = false

    }
    var playerAm = true
    fun playersChange(view: View){
        playerAm = !playerAm
    }
    fun restartClick(view: View){
        winner = 0
        kol_hod = 0
        but_1.isEnabled = true
        but_2.isEnabled = true
        but_3.isEnabled = true
        but_4.isEnabled = true
        but_5.isEnabled = true
        but_6.isEnabled = true
        but_7.isEnabled = true
        but_8.isEnabled = true
        but_9.isEnabled = true
        but_players.isEnabled = true
        activePlayer = 1
        player1.clear()
        player2.clear()
        but_1.text = ""
        but_2.text = ""
        but_3.text = ""
        but_4.text = ""
        but_5.text = ""
        but_6.text = ""
        but_7.text = ""
        but_8.text = ""
        but_9.text = ""
    }
    fun butClick(view: View){
        but_players.isEnabled = false
        val butClicked = view as Button
        var cellID = 0
        when(butClicked.id){
            R.id.but_1 -> cellID = 1
            R.id.but_2 -> cellID = 2
            R.id.but_3 -> cellID = 3
            R.id.but_4 -> cellID = 4
            R.id.but_5 -> cellID = 5
            R.id.but_6 -> cellID = 6
            R.id.but_7 -> cellID = 7
            R.id.but_8 -> cellID = 8
            R.id.but_9 -> cellID = 9
        }

        Gaame(cellID, butClicked)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var kol_hod = 0
    var activePlayer = 1
    var winner =  0

    private fun Gaame(cellID: Int, butClicked: Button) {

        if(activePlayer == 1){
            kol_hod++
            butClicked.text = "X"
            butClicked.setTextColor(Color.parseColor("#FF0023FF"))
            player1.add(cellID)
            activePlayer = 2

            CheckWin()
            if(playerAm == false) {
                if (kol_hod != 9 && winner != 1) {
                    BotGaame()
                } else if (kol_hod == 9 && winner == 0) {
                    //if(kol_hod == 9) {
                    Toast.makeText(this, "DRAW!!!", Toast.LENGTH_LONG).show()
                    but_1.isEnabled = false
                    but_2.isEnabled = false
                    but_3.isEnabled = false
                    but_4.isEnabled = false
                    but_5.isEnabled = false
                    but_6.isEnabled = false
                    but_7.isEnabled = false
                    but_8.isEnabled = false
                    but_9.isEnabled = false
                }
            }
        }else
        {
            kol_hod++
            butClicked.text = "O"
            butClicked.setTextColor(Color.parseColor("#FF0000"))
            player2.add(cellID)
            activePlayer = 1
            CheckWin()
        }
        butClicked.isEnabled = false
    }

    private fun CheckWin() {

        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        }

        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }

        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2
        }

        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }

        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }


        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2
        }


        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2
        }

        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner = 2
        }

        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner = 2
        }

        if(winner != 0) {
            if (winner == 1) {
                Toast.makeText(this, "PLAYER 1 WON!!!", Toast.LENGTH_LONG).show()
            }
            if (winner == 2) {
                Toast.makeText(this, "PLAYER 2 WON!", Toast.LENGTH_LONG).show()
            }
            but_1.isEnabled = false
            but_2.isEnabled = false
            but_3.isEnabled = false
            but_4.isEnabled = false
            but_5.isEnabled = false
            but_6.isEnabled = false
            but_7.isEnabled = false
            but_8.isEnabled = false
            but_9.isEnabled = false
        }

    }


    private fun BotGaame(){

        var emptyCells = ArrayList<Int>()
        for (cellID in 1..9){
            if(!(player1.contains(cellID) || (player2.contains(cellID))))
                emptyCells.add(cellID)
        }

        val r = java.util.Random()
        val randIndex = r.nextInt(emptyCells.size-0)+0
        val cellID = emptyCells[randIndex]

        val butChoose: Button
        when(cellID){
            1 -> butChoose = but_1
            2 -> butChoose = but_2
            3 -> butChoose = but_3
            4 -> butChoose = but_4
            5 -> butChoose = but_5
            6 -> butChoose = but_6
            7 -> butChoose = but_7
            8 -> butChoose = but_8
            9 -> butChoose = but_9
            else -> butChoose = but_1
        }

        Gaame(cellID, butChoose)
    }
}
