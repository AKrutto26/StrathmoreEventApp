package com.strathmore.eventapp.ui.navigation

object NavRoutes {
    const val Welcome = "welcome"
    const val EventList = "event_list"
    const val EventDetail = "event_detail"
}

fun eventDetailRoute(
    title: String,
    description: String,
    date: String,
    location: String,
    imageUrl: String
): String {
    return "event_detail/$title/$description/$date/$location/$imageUrl"
}


