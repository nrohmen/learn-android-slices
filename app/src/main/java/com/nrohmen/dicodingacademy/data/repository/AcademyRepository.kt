package com.nrohmen.dicodingacademy.data.repository

import androidx.annotation.StringDef
import com.nrohmen.dicodingacademy.R
import com.nrohmen.dicodingacademy.data.model.Academy

class AcademyRepository {
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
                "Dicoding Indonesia",
                "Peserta akan belajar membangun aplikasi Android dengan materi Testing, Debugging, Application, Application UX, Fundamental Application Components, Persistent Data Storage, dan Enhanced System Integration",
                R.drawable.made,
                "",
                2200


        )
        val academy2 = Academy(
                "Kotlin Android Developer Expert",
                "Dicoding Indonesia",
                "Pada Google I/O 2017, Kotlin diumumkan sebagai bahasa pemrograman yang termasuk dalam bahasa kelas satu (First class) yang didukung untuk pembuatan aplikasi Android, selain Java dan C++. Kotlin adalah bahasa pemrograman yang dibuat dan didukung oleh JetBrains. Google juga akan memastikan bahwa semua fitur baru di Android, framework, IDE dan keseluruhan library, akan dapat bekerja dan terintegrasi baik dengan bahasa pemrograman Kotlin serta interopable dengan fungsi-fungsi Java yang telah ada sehingga memungkinkan para engineer melakukan perubahan bagian tertentu aplikasi dari Java ke Kotlin dan sebaliknya dengan sangat mudah.",
                R.drawable.kotlin,
                "",
                1100


        )
        val academy3 = Academy(
                "Menjadi Game Developer Expert",
                "Asosiasi Game Indonesia",
                "Semua modul dalam kelas ini telah diverifikasi langsung oleh Asosiasi Game Indonesia (AGI) untuk memastikan materi yang diajarkan relevan dan sesuai dengan kebutuhan industri game saat ini. Peserta akan belajar best practice membuat game seperti script, sprite, UI, gameplay, Input Method, Porting ke Android / iOS, Modul Services (Collaboration, Ads, dan Analytics - Update Maret 2018), Porting ke VR - cardboard dan GearVR (New Mei 2018) dengan Unity 3D. Peserta juga akan belajar langsung membuat 5 game yaitu casual, arcade (Update Maret 2018), platformer, FPS, multiplayer (Update Maret 2018), serta Game Interaktif dengan VR (New Mei 2018)",
                R.drawable.mgde,
                "",
                1650


        )

        academies = listOf(academy1, academy2, academy3)
    }
}