package com.strathmore.eventapp.ui.navigation

object NavRoutes {
    const val Login = "login"
    const val EventList = "event_list"
    const val EventDetail = "event_detail"
}

fun eventDetailRoute(
    title: String,
    description: String,
    date: String,
    location: String,
    imageUrl: String,
    formLink: String
): String {
    return "${NavRoutes.EventDetail}/$title/$description/$date/$location/$imageUrl/$formLink"
}
