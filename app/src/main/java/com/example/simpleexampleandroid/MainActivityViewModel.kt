package com.example.simpleexampleandroid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.collect
/**
 * A group of *members*.
 *
 * This class has no useful logic; it's just a documentation example.
 *
 * @param T the type of a member in this group.
 * @property name the name of this group.
 * @constructor Creates an empty group.
 * @see "https://kotlinlang.org/docs/reference/kotlin-doc.html"
 */


class MainActivityViewModel: ViewModel() {
//    private val _testLiveData = MutableLiveData<EventTest<String>>()
//    val testLiveData : LiveData<EventTest<String>>
//        get() = _testLiveData
//
//    private val _testEvent = MutableLiveData<Event<Nothing>>()
//    val testEvent : LiveData<Event<Nothing>>
//        get() = _testEvent

    private var _testButton = MutableLiveData<ButtonUiModel>().apply {
        postValue(
            ButtonUiModel(
                name = "kiet",
                onClick = {
                    this.postValue(
                        ButtonUiModel(
                        name = "Kha", onClick = {}
                    ))
                }
            )
        )
    }
    val testButton : LiveData<ButtonUiModel>
        get() = _testButton

    fun setValue(){
        _testButton.value = ButtonUiModel("", onClick = {})
    }

    fun setValueX(buttonUiModel: ButtonUiModel){
        _testButton.value = buttonUiModel
    }
}