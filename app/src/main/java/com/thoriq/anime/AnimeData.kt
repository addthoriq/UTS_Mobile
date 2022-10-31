package com.thoriq.anime

object AnimeData {
    private val namaAnime = arrayOf(
        "Death Note",
        "Demon Slayer",
        "Detecttive Conan",
        "Fate Stand Night",
        "Love Live! Superstar!!",
        "Naruto",
        "One Piece",
        "Tokyo Revengers"
    )
    private val descAnime = arrayOf(
        "Buku Kematian",
        "Iblis Nezuko",
        "Bocah kematian",
        "Ga tau ini anime apa",
        "WAIFUKU ADA DISINI CUYY",
        "Anime jaman bocil",
        "Bajak Laut",
        "Preman Pasar"
    )

    private val imgAnime = intArrayOf(
        R.drawable.deathnote,
        R.drawable.demonslayer,
        R.drawable.detectiveconan,
        R.drawable.fate,
        R.drawable.liella,
        R.drawable.naruto,
        R.drawable.onepiece,
        R.drawable.tokyorevengers
    )

    val listData: ArrayList<ValAnime>
    get(){
        val list = arrayListOf<ValAnime>()
        for (position in namaAnime.indices){
            val anim = ValAnime()
            anim.judul = namaAnime[position]
            anim.desc = descAnime[position]
            anim.photo = imgAnime[position]
            list.add(anim)
        }
        return list
    }
}
