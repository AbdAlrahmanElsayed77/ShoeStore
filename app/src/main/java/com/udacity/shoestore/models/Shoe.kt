package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Shoe(
    var name: String, var size: Double, var company: String, var description: String,
    var index: Int, val images: List<String> = mutableListOf(
        "shoe1", "shoe2", "shoe3", "shoe4",
        "shoe5", "shoe6", "shoe7", "shoe8")
) : Parcelable