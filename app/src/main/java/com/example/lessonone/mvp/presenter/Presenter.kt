package com.example.lessonone.mvp.presenter

import com.example.lessonone.mvp.model.CountersModel
import com.example.lessonone.mvp.view.MainView


const val COUNTER_ONE_INDEX = 0
const val COUNTER_TWO_INDEX = 1
const val COUNTER_THREE_INDEX = 2

class Presenter(private val mainView: MainView) {

    private val model = CountersModel()

    fun counterClickOne() {
        val value = model.getCountersOne()
        mainView.setButtonTextOne(value.toString())
        model.next(COUNTER_ONE_INDEX)

    }

    fun counterClickTwo() {
        val value = model.getCountersTho()
        mainView.setButtonTextTwo(value.toString())
        model.next(COUNTER_TWO_INDEX)
    }

    fun counterClickThree() {
        val value = model.getCountersThree()
        mainView.setButtonTextThree(value.toString())
        model.next(COUNTER_THREE_INDEX)
    }


}
