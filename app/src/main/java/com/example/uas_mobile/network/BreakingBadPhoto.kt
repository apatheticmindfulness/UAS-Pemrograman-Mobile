package com.example.uas_mobile.network

data class BreakingBadPhoto (
    val char_id: Int,
    val name: String,
    val birthday: String,
    val occupation: Array<String>,
    val img: String,
    val status: String,
    val nickname: String,
    val appearance: Array<Int>,
    val portrayed: String,
    val category: String,
    val better_call_saul_appearance: Array<Int>
)