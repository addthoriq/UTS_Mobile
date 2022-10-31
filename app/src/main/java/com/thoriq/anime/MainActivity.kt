package com.thoriq.anime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvAnime: RecyclerView
    private val listAnim: ArrayList<ValAnime> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvAnime = findViewById(R.id.rv_anime)
        rvAnime.setHasFixedSize(true)

        listAnim.addAll(AnimeData.listData)
        showRecylerList()
    }

    private fun showRecylerList() {
        rvAnime.layoutManager = LinearLayoutManager(this)
        val listAnimeAdapter = ListAnimeAdapter(listAnim)
        rvAnime.adapter = listAnimeAdapter

        listAnimeAdapter.setOnItemClickCallback(object: ListAnimeAdapter.OnItemClickCallback {
            override fun onItemClicked(data: ValAnime) {
                showSelectedAnime(data)
            }
        })
    }

    fun showSelectedAnime(d: ValAnime) {
        Toast.makeText(this, "Kamu memilih" + d.judul, Toast.LENGTH_SHORT).show()
        val pindah = Intent(this, Detail::class.java)
        pindah.putExtra("poto", d.photo)
        pindah.putExtra("judul", d.judul)
        pindah.putExtra("desc", d.desc)

        startActivity(pindah)
    }
}