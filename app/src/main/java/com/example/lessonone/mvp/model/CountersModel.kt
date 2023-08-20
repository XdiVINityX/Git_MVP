package com.example.lessonone.mvp.model

class CountersModel {
    private val counters: MutableList<Int> = mutableListOf(0, 0, 0)


    fun getCountersOne() : Int {
        return counters[0]
    }

    fun getCountersTho() : Int {
        return counters[1]
    }

    fun getCountersThree(): Int {
        return counters[2]
    }

    fun setCountersByIndex(index: Int, value : Int){
         counters[index] =  value
    }

    fun next(index: Int): Int {
        return counters[index]++
    }
}