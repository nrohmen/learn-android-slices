package com.nrohmen.dicodingacademy.data.repository

import androidx.annotation.StringDef
import com.nrohmen.dicodingacademy.R
import com.nrohmen.dicodingacademy.data.model.Academy

class AcademyRepository{
    companion object SortBy {
        const val NONE = "NONE"
        const val PRICE = "PRICE"
    }

    @Retention(AnnotationRetention.SOURCE)
    @StringDef(
            NONE,
            PRICE
    )
    annotation class SortingOptions

    var academies: List<Academy> = emptyList()

    init {
        val academy1 = Academy(
                "Menjadi Android Developer Expert",
                "",
                "",
                R.drawable.made,
                "",
                2200


        )
        val academy2 = Academy(
                "Kotlin Android Developer Expert",
                "",
                "",
                R.drawable.kotlin,
                "",
                1100


        )
        val academy3= Academy(
                "Menjadi Game Developer Expert",
                "",
                "",
                R.drawable.mgde,
                "",
                1650


        )

        academies = listOf(academy1, academy2, academy3)
    }
}