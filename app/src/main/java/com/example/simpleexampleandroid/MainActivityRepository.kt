package com.example.simpleexampleandroid

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow



class MainActivityRepository {
    private val text : Flow<EventTest<String>>
        get() = flow{
            emit(EventTest("kiet"))
        }


    fun getRepository() = text
}