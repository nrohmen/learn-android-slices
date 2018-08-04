package com.nrohmen.dicodingacademy.provider

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.graphics.drawable.IconCompat
import androidx.slice.Slice
import androidx.slice.SliceProvider
import androidx.slice.builders.GridRowBuilder
import androidx.slice.builders.ListBuilder
import androidx.slice.builders.SliceAction
import com.nrohmen.dicodingacademy.R
import com.nrohmen.dicodingacademy.data.model.Academy
import com.nrohmen.dicodingacademy.data.repository.AcademyRepository
import com.nrohmen.dicodingacademy.receiver.AcademiesBroadcastReceiver
import com.nrohmen.dicodingacademy.ui.detail.AcademyDetailActivity
import com.nrohmen.dicodingacademy.ui.home.HomeActivity
import com.nrohmen.dicodingacademy.util.getSortedAcademies

class AcademySliceProvider : SliceProvider() {
    override fun onCreateSliceProvider(): Boolean {
        return true
    }

    override fun onBindSlice(sliceUri: Uri): Slice? {
        val context = context ?: return null
        return when {
            sliceUri.path.equals(ContentUris.AcademyPaths.ACADEMY, true) ->
                createSliceAcademy(context, sliceUri)
            else -> null
        }
    }

    private fun createSliceAcademy(context: Context, sliceUri: Uri): Slice? {
        val maxAcademy = 3
        val academyRepo = AcademyRepository()
        val academies: List<Academy> = getSortedAcademies(context, academyRepo).take(maxAcademy)
        val seeMoreAction = SliceAction.create(createSeeMoreIntent(),
                IconCompat.createWithResource(context, R.drawable.ic_more),
                ListBuilder.ICON_IMAGE, "Sort by Price")
        val sortByPriceAction = SliceAction.create(createSortByPriceIntent(),
                IconCompat.createWithResource(context, R.drawable.ic_sort_price),
                ListBuilder.ICON_IMAGE, "Sort by Price")

        val listBuilder = ListBuilder(context, sliceUri, ListBuilder.INFINITY)
                .setHeader {
                    it.apply {
                        title = "Dicoding Academy"
                        primaryAction = seeMoreAction
                    }
                }
                .addAction(seeMoreAction)
        val gridRowBuilder = GridRowBuilder(listBuilder)
        academies.forEach { academy ->
            gridRowBuilder.addCell {
                it.apply {
                    academy.image?.let { it1 -> IconCompat.createWithResource(context, it1) }?.let { it2 -> addImage(it2, ListBuilder.LARGE_IMAGE) }
                    academy.name?.let { it1 -> addTitleText(it1) }
                    addText(getPrice(academy))
                    contentIntent = createViewIntent(academy)
                }
            }
        }
        listBuilder.addGridRow(gridRowBuilder)
        listBuilder.addRow {
            it.apply {
                title = "Sort Academies"
                subtitle = ""
                addEndItem(sortByPriceAction)
            }
        }

        return listBuilder.build()
    }

    private fun createSeeMoreIntent(): PendingIntent {
        val intent = Intent(context, HomeActivity::class.java)
        intent.action = System.currentTimeMillis().toString()
        return PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
    }

    private fun createViewIntent(academy: Academy): PendingIntent {
        val intent = Intent(context, AcademyDetailActivity::class.java)
        val requestCode = AcademyDetailActivity.REQUEST_CODE_ACADEMY
        intent.putExtra(AcademyDetailActivity.EXTRA_ACADEMY, academy)
        intent.action = System.currentTimeMillis().toString()
        return PendingIntent.getActivity(context, requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT)
    }

    private fun createSortByPriceIntent(): PendingIntent {
        val intent = Intent(context, AcademiesBroadcastReceiver::class.java)
        val requestCode = AcademiesBroadcastReceiver.REQUEST_CODE_SORT_BY_PRICE
        intent.putExtra(AcademiesBroadcastReceiver.EXTRA_REQUEST_CODE, requestCode)
        return PendingIntent.getBroadcast(context, requestCode, intent, 0)
    }

    private fun getPrice(academy: Academy): String {
        return "${academy.price } pts"
    }
}