package com.example.uas_mobile.network

data class DisneyPhoto(
    val films: Array<String>,
    val shortFilms: Array<String>, val tvShows: Array<String>,
    val videoGames: Array<String>, val parkAttractions: Array<String>,
    val allies: Array<String>, val enemies: Array<String>,
    val _id: Int, val name: String, val imageUrl: String,
    val url: String,

    )