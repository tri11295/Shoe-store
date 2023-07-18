package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    val id: Int, var name: String, var size: Double,
    var company: String, var description: String,
    val images: List<String> = mutableListOf()
) : Parcelable {
    fun nameDisplay() = "Name : $name"
    fun sizeDisplay() = "Size : $size"
    fun sizeString() = size.toString()
    fun companyDisplay() = "Company : $company"
    fun descriptionDisplay() = "Description : $description"
}