package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    enum class Turn{
        Nought,
        Cross
    }

    private var firstTurn = Turn.Cross
    private var currentTurn = Turn.Cross

    private var crossesScore = 0
    private var NoughtsScore = 0

    private var boardList = mutableListOf<Button>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initBoard()
    }
    private fun initBoard(){
        boardList.add(binding.a1)
        boardList.add(binding.a2)
        boardList.add(binding.a3)
        boardList.add(binding.b1)
        boardList.add(binding.b2)
        boardList.add(binding.b3)
        boardList.add(binding.c1)
        boardList.add(binding.c2)
        boardList.add(binding.c3)
    }

    fun boardTapped(view:View){
        if(view !is Button)
            return
        addToBoard(view)
        
        if(victory(Nought)){
            NoughtsScore++
            result("Noughts Win!")
        }
        if(victory(Cross)){
            crossesScore++
            result("Cross Win!")
        }

        if(fullBoard()){
            result("Draw")
        }
    }

    private fun victory(s:String): Boolean {
        // horizontal victory
        if (match(binding.a1,s) && match(binding.a2,s) && match(binding.a3,s))
            return true
        if (match(binding.b1,s) && match(binding.b2,s) && match(binding.b3,s))
            return true
        if (match(binding.c1,s) && match(binding.c2,s) && match(binding.c3,s))
            return true

       // vertical victory
        if (match(binding.a1,s) && match(binding.b1,s) && match(binding.c1,s))
            return true
        if (match(binding.a2,s) && match(binding.b2,s) && match(binding.c2,s))
            return true
        if (match(binding.a3,s) && match(binding.b3,s) && match(binding.c3,s))
            return true

        //diag victory
        if (match(binding.a1,s) && match(binding.b2,s) && match(binding.c3,s))
            return true
        if (match(binding.a3,s) && match(binding.b2,s) && match(binding.c1,s))
            return true


        return false
    }
    private fun match(button: Button, symbol:String): Boolean = button.text == symbol

    private fun result(title:String){
        val message = "\nNoughts $NoughtsScore\n\nCrosses $crossesScore"
        AlertDialog.Builder(this)
            .setMessage(message)
            .setTitle(title)
            .setPositiveButton("Reset"){
                _,_ ->
                resetBoard()
            }
            .setCancelable(false)
            .show()
    }

    private fun resetBoard() {
        for (button in boardList){
            button.text = ""
        }
        if(firstTurn == Turn.Nought)
            firstTurn = Turn.Cross
        else if(firstTurn == Turn.Cross)
            firstTurn = Turn.Nought

        currentTurn = firstTurn
        setTurnLabel()
    }

    private fun fullBoard(): Boolean{
        for (button in boardList){
            if(button.text == "")
                return false
        }
        return  true
    }
    private fun addToBoard(button: Button){
        if(button.text != "")
            return
        if(currentTurn == Turn.Nought){
            button.text = Nought
            currentTurn = Turn.Cross
        }else if(currentTurn == Turn.Cross){
            button.text = Cross
            currentTurn = Turn.Nought
        }
        setTurnLabel()
    }
    private fun  setTurnLabel(){
        var turnText = ""
        if(currentTurn == Turn.Cross)
            turnText = "Turn $Cross"
        else if(currentTurn == Turn.Nought)
            turnText = "Turn $Nought"
        binding.turnTV.text = turnText


    }

    companion object{
        const val Nought = "0"
        const val Cross = "X"
    }
}