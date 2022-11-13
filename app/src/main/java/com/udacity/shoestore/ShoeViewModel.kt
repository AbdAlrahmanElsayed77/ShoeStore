package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe


class ShoeViewModel : ViewModel() {

    var shoe: Shoe = Shoe("", 0.0, "", "", 0)

    private val _shoeIndex = MutableLiveData<Int>()
    val shoeIndex:LiveData<Int>
        get() = _shoeIndex

    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    init {
        _shoeIndex.value = 0
    }
    fun addShoe() {
        shoe.index = getImage()
        val newShoe = shoe.copy()
        _shoeList.value = _shoeList.value?.plus(newShoe) ?: listOf(newShoe)
        clear()
    }
    fun clear() {
        shoe.name = ""
        shoe.size = 0.0
        shoe.company = ""
        shoe.description = ""
        shoe.index = 0
    }
    fun changePicture() {
        if (shoeIndex.value!! < shoe.images.size-1) {
            _shoeIndex.value = _shoeIndex.value?.plus(1)
        } else {
            _shoeIndex.value = 0
        }
    }
    fun getImage():Int {
        return when (shoe.images[shoeIndex.value!!]) {
            "shoe1" -> (R.drawable.shoe1)
            "shoe2" -> (R.drawable.shoe2)
            "shoe3" -> (R.drawable.shoe3)
            "shoe4" -> (R.drawable.shoe4)
            "shoe5" -> (R.drawable.shoe5)
            "shoe6" -> (R.drawable.shoe6)
            "shoe7" -> (R.drawable.shoe7)
            "shoe8" -> (R.drawable.shoe8)
            else -> (R.drawable.shoe1)
        }
    }
}
