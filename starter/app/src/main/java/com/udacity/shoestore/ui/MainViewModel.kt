package com.udacity.shoestore.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.SingleLiveEvent
import com.udacity.shoestore.models.Shoe

class MainViewModel : ViewModel() {

    var isFinishedOnBoarding = false

    var listShoe = mutableListOf(
        Shoe(1, "Nike 1", 18.0, "Nike", "des1", mutableListOf("https://images.unsplash.com/photo-1542291026-7eec264c27ff?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8c2hvZXN8ZW58MHx8MHx8fDA%3D&w=1000&q=80", "")),
        Shoe(2, "Nike 2", 20.0, "Nike", "des1", mutableListOf("https://images.unsplash.com/photo-1542291026-7eec264c27ff?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8c2hvZXN8ZW58MHx8MHx8fDA%3D&w=1000&q=80", "")),
        Shoe(3, "Nike 3", 16.0, "Nike", "des1", mutableListOf("https://images.unsplash.com/photo-1542291026-7eec264c27ff?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8c2hvZXN8ZW58MHx8MHx8fDA%3D&w=1000&q=80", "")),
        Shoe(4, "Nike 4", 16.0, "Nike", "des1", mutableListOf("https://images.unsplash.com/photo-1542291026-7eec264c27ff?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8c2hvZXN8ZW58MHx8MHx8fDA%3D&w=1000&q=80", "")),
        Shoe(5, "Nike 5", 19.0, "Nike", "des1", mutableListOf("https://images.unsplash.com/photo-1542291026-7eec264c27ff?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8c2hvZXN8ZW58MHx8MHx8fDA%3D&w=1000&q=80", "")),
        Shoe(6, "Nike 6", 17.0, "Nike", "des1", mutableListOf("https://images.unsplash.com/photo-1542291026-7eec264c27ff?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8c2hvZXN8ZW58MHx8MHx8fDA%3D&w=1000&q=80", ""))
    )

    val getListShoeLiveData = SingleLiveEvent<List<Shoe>>()


    fun getListShoe() {
        getListShoeLiveData.postValue(listShoe)
    }

    fun updateShoeInfo(shoe: Shoe) {
        val index = listShoe.indexOfFirst {
            it.id == shoe.id
        }
        listShoe[index] = shoe
    }

}