package com.example.guessinggame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.guessinggame.databinding.ActivityMainBinding
import kotlinx.parcelize.Parcelize
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
         var  btnLeft = findViewById<Button>(R.id.btnLeft)
          var btnRight = findViewById<Button>(R.id.btnRight)
          var backgroundView = findViewById<ConstraintLayout>(R.id.backgroundView)
        assignNumbersToButtons()
            btnLeft.setOnClickListener{
                checkAnswer(true)
                assignNumbersToButtons()
        }
        btnRight.setOnClickListener{
            checkAnswer(false)
            assignNumbersToButtons()
        }

    }
   private  fun checkAnswer(isLeftButtonSelected : Boolean){
        var  btnLeft = findViewById<Button>(R.id.btnLeft)
         var btnRight = findViewById<Button>(R.id.btnRight)
         var backgroundView = findViewById<ConstraintLayout>(R.id.backgroundView)
        val leftNum: Int =  btnLeft.text.toString().toInt()
        val rightNum  = btnRight.text.toString().toInt()
       val isAnswerCorrect = if(isLeftButtonSelected)leftNum > rightNum else rightNum > leftNum
        if(isAnswerCorrect){
            // Correct answer
            // change background colour and show Toast
            backgroundView.setBackgroundColor(Color.CYAN)
            Toast.makeText(this , "Correct!" , Toast.LENGTH_SHORT).show()
        }else{
            // Incorrect answer
            backgroundView.setBackgroundColor(Color.RED)
            Toast.makeText(this , "Incorrect!" , Toast.LENGTH_SHORT).show()
        }

    }

  private  fun assignNumbersToButtons(){
      val r = Random()
     val leftNum =  r.nextInt(10)
      var rightNum = r.nextInt(10)
      while(rightNum == leftNum){
          rightNum = r.nextInt(10)
      }
       var  btnLeft = findViewById<Button>(R.id.btnLeft)
        var btnRight = findViewById<Button>(R.id.btnRight)
      btnLeft.text = leftNum.toString()
      btnRight.text = rightNum.toString()

    }
}