package com.example.simpleexampleandroid

open class EventTest<out T>(private val content: T){
    var hasBeeHandled = false
        private set
    fun  getContentIfNotHandled():T?{
        return if( hasBeeHandled){
            null
        } else{
            hasBeeHandled = true
            content
        }
    }
    fun peekContent(): T = content
}