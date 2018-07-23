package com.nrohmen.dicodingacademy.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.nrohmen.dicodingacademy.SlicesApplication
import com.nrohmen.dicodingacademy.data.repository.AcademyRepository
import com.nrohmen.dicodingacademy.provider.ContentUris

class AcademiesBroadcastReceiver : BroadcastReceiver() {

    companion object {
        const val REQUEST_CODE_SORT_BY_PRICE = 2001
        const val EXTRA_REQUEST_CODE = "EXTRA_REQUEST_CODE"
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent != null && intent.hasExtra(EXTRA_REQUEST_CODE)) {
            val requestCode = intent.getIntExtra(EXTRA_REQUEST_CODE, REQUEST_CODE_SORT_BY_PRICE)
            when (requestCode) {
                REQUEST_CODE_SORT_BY_PRICE -> {
                    setSortingType(context, AcademyRepository.PRICE)
                    refreshAcademyList(context)
                }
            }
        }
    }

    private fun refreshAcademyList(context: Context?) {
        context?.contentResolver?.notifyChange(ContentUris.URI_ACADEMY, null)
    }


    private fun setSortingType(context: Context?, @AcademyRepository.SortingOptions sortingOption: String) {
        val application = getApplication(context)
        if (application != null) {
            application.appState.sortingType = sortingOption
        }
    }

    private fun getApplication(context: Context?): SlicesApplication? {
        return if (context != null)
            context.applicationContext as SlicesApplication
        else null
    }
}