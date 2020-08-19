package com.example.simpleexampleandroid

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CircleViewModel: ViewModel() {
    private var listTheme = MutableLiveData<ArrayList<Int>>()

    init {
        listTheme.value = fakeData()
    }

    fun getData() : ArrayList<Int>? {
        return listTheme.value
    }

    private fun fakeData(): ArrayList<Int>{
        val arrayList = ArrayList<Int>()
        for (i in 0..20){
            val colorId = 3030 + i
            arrayList.add(colorId)
        }
        return arrayList
    }


}