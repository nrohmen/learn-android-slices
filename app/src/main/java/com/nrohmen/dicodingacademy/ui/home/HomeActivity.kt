package com.nrohmen.dicodingacademy.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nrohmen.dicodingacademy.R
import com.nrohmen.dicodingacademy.data.model.Academy
import com.nrohmen.dicodingacademy.data.repository.AcademyRepository
import com.nrohmen.dicodingacademy.util.getSortedAcademies
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.ctx

class HomeActivity : AppCompatActivity() {
    private var items: MutableList<Academy> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Dicoding Academy"
        initData()
        list.layoutManager = LinearLayoutManager(ctx)
        list.adapter = RecyclerViewAdapter( this, items){

        }
    }

    private fun initData(){
        val maxAcademy = 3
        val academyRepo = AcademyRepository()
        val academies: List<Academy> = getSortedAcademies(ctx, academyRepo).take(maxAcademy)
        academies.forEach { academy ->
           items.add(academy)
        }
    }
}
