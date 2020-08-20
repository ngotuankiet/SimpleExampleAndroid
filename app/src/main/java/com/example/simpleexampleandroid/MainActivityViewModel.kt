package com.example.simpleexampleandroid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.collect

class MainActivityViewModel: ViewModel() {
    private val _testLiveData = MutableLiveData<EventTest<String>>()
    val testLiveData : LiveData<EventTest<String>>
        get() = _testLiveData

    private val _testEvent = MutableLiveData<Event<Nothing>>()
    val testEvent : LiveData<Event<Nothing>>
        get() = _testEvent

    private val _testButton = MutableLiveData<ButtonUiModel>()
    val testButton : LiveData<ButtonUiModel>
        get() = _testButton

    suspend fun setValue(){
        MainActivityRepository().getRepository().collect { value ->
            _testLiveData.value = value
        }
    }
}