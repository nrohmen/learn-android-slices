package com.nrohmen.dicodingacademy.state

import com.nrohmen.dicodingacademy.data.repository.AcademyRepository


class AppState {
    @AcademyRepository.SortingOptions
    var sortingType = AcademyRepository.NONE
}
