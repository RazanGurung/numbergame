package com.rajan.thirdassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {
    var clickCount=0
    var correct=0
    var incorrect=0
    private lateinit var btnFirst : Button
    private lateinit var btnSecond : Button
    private lateinit var btnReset : Button
    private lateinit var tvscore : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         btnFirst  = findViewById(R.id.btnFirst)
         btnSecond  = findViewById(R.id.btnSecond)
         btnReset  = findViewById(R.id.btnReset)
        
            btnFirst.setOnClickListener{
                clickCount++
                btnFirst.text=randomNumber().toString()
                btnSecond.text = randomNumber().toString()
                if (btnFirst == btnSecond){
                    btnFirst.text=randomNumber().toString()
                    btnSecond.text=randomNumber().toString()
                }
                val firstnum = btnFirst.text.toString().toInt()
                val secondnum = btnSecond.text.toString().toInt()
                greaterCheck(a=firstnum,b=secondnum)
                score()
            }

            btnSecond.setOnClickListener{
                clickCount++
                btnFirst.text = randomNumber().toString()
                btnSecond.text=randomNumber().toString()
                if (btnFirst == btnSecond){
                    btnFirst.text=randomNumber().toString()
                    btnSecond.text=randomNumber().toString()
                }
                val firstnum = btnFirst.text.toString().toInt()
                val secondnum = btnSecond.text.toString().toInt()
                greaterCheck(a=secondnum,b=firstnum)
                score()
            }
        btnReset.setOnClickListener {
            val intent = intent
            finish()
            startActivity(intent)
        }

    }
    private fun randomNumber():Int{
        val random = Random.nextInt(1..99)
        return random
    }
    private fun greaterCheck(a:Int,b:Int){
        if(a>b){
            correct++
        }
        else{
            incorrect++
        }
    }
    private fun score(){
        tvscore = findViewById(R.id.tvscore)
        if(clickCount == 10){
            val result = correct-incorrect
            tvscore.text=result.toString()
            btnFirst.isEnabled=false
            btnSecond.isEnabled=false
            btnFirst.text = "Game"
            btnSecond.text = "Over"
        }
    }
}