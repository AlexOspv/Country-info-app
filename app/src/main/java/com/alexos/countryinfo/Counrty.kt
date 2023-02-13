package com.alexos.countryinfo

data class Counrty (

    val name: String,
    val capital: String,
    val population: Long,
    val area: Long,
    val languages: List<Language>,
    val flag: String

        )

data class Language(

    val name: String

)