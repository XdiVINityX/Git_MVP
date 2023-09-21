package com.example.gitlistmvp.mvp.presentation.imageLoader

interface IImageLoader<T> {
    fun loadInto(url : String,container:T)
}