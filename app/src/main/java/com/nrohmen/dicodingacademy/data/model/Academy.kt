package com.nrohmen.dicodingacademy.data.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Academy(val name: String?, val author: String?, val desc: String?, @DrawableRes val image: Int?, val platform: String?, val price: Int?):Parcelable