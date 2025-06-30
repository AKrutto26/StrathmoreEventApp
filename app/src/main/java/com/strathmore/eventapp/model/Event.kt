package com.strathmore.eventapp.model

data class Event(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val date: String = "",
    val location: String = "",
    val imageUrl: String = ""
)