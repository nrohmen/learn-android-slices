package com.nrohmen.dicodingacademy.provider

import android.net.Uri

class ContentUris{
    companion object {
        val URI_ACADEMY = Uri.parse(AcademyUriStrings.ACADEMY_LIST)
    }

    class AcademyUriStrings {
        companion object {
            const val ACADEMY_LIST = "content://com.nrohmen.dicodingacademy.provider" + AcademyPaths.ACADEMY
        }
    }

    class AcademyPaths {
        companion object {
            const val ACADEMY = "/academy"
        }
    }
}