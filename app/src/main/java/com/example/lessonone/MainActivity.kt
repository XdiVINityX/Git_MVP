package com.example.lessonone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.lessonone.databinding.ActivityMainBinding
import com.example.lessonone.mvp.presenter.Presenter
import com.example.lessonone.mvp.view.MainView


class MainActivity : AppCompatActivity(), MainView {

    private val presenter = Presenter(this)


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnCounter1.setOnClickListener {
            presenter.counterClickOne()
        }
        binding.btnCounter2.setOnClickListener {
            presenter.counterClickTwo()
        }
        binding.btnCounter3.setOnClickListener {
            presenter.counterClickThree()
        }


    }

    override fun setButtonTextOne(text: String) {
        Log.d("myTag","setButtonTextOne: $text")
        binding.btnCounter1.text = text
    }
    override fun setButtonTextTwo(text: String) {
        binding.btnCounter2.text = text
    }
    override fun setButtonTextThree(text: String) {
        binding.btnCounter3.text = text
    }


}