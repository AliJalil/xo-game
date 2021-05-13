package com.example.xo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.xo.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {

    lateinit var replayBtn: Button
    lateinit var resultTxt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val binding = DataBindingUtil.setContentView<ActivityMain2Binding>(
            this,
            R.layout.activity_main2
        )

        replayBtn = binding.replayBtn
        resultTxt = binding.resultTxt

        resultTxt.text = winnerPlayerTxt

        replayBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        var winnerPlayerTxt = ""
    }
}
