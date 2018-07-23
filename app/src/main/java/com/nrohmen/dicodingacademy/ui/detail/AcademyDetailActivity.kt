package com.nrohmen.dicodingacademy.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nrohmen.dicodingacademy.R
import com.nrohmen.dicodingacademy.data.model.Academy
import kotlinx.android.synthetic.main.activity_academy_detail.*

class AcademyDetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_ACADEMY: String = "EXTRA_ACADEMY"
        const val REQUEST_CODE_ACADEMY: Int = 3001
    }
    private lateinit var academy: Academy

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_academy_detail)
        if (intent != null && intent.hasExtra(EXTRA_ACADEMY)) {
            academy = intent.getParcelableExtra(EXTRA_ACADEMY)
        }
        text_view.text = academy.name
    }
}
