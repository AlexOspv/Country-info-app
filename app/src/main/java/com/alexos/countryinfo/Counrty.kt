package com.alexos.countryinfo

data class Counrty (

    val name: String,
    val Capital: String,
    val population: Long,
    val area: Long,
    val languages: List<Language>

        )

data class Language(

    val name: String

)