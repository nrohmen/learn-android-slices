package com.nrohmen.dicodingacademy.util

import android.content.Context
import com.nrohmen.dicodingacademy.SlicesApplication
import com.nrohmen.dicodingacademy.data.model.Academy
import com.nrohmen.dicodingacademy.data.repository.AcademyRepository

fun getSortedAcademies(context: Context, academyRepo: AcademyRepository): List<Academy> {
    @AcademyRepository.SortingOptions val sortBy = (context.applicationContext as SlicesApplication).appState.sortingType
    return when {
        AcademyRepository.PRICE.equals(sortBy, true) ->
            academyRepo.academies.sortedWith(compareBy { it.price })
        else ->
            academyRepo.academies
    }
}
