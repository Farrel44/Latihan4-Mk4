package com.example.a14_25_latihan4_recyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MyData (
    var name:String,
    var description: String,
    var photo: String,
) : Parcelable
