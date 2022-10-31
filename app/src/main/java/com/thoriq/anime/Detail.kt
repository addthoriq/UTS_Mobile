package com.thoriq.anime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class Detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val terimaGbr: ImageView = findViewById(R.id.iv_image_anime)
        val terimaJudul: TextView = findViewById(R.id.tv_judul_detail)
        val terimaDesc: TextView = findViewById(R.id.tv_desc_detail)

        Glide.with(this)
            .load(intent.getIntExtra("poto", 0))
            .into(terimaGbr)

        terimaJudul.text = intent.getStringExtra("judul")
        terimaDesc.text = intent.getStringExtra("desc")

    }
}