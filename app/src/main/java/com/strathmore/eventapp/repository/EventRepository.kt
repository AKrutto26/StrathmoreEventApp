package com.strathmore.eventapp.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.strathmore.eventapp.model.Event
import kotlinx.coroutines.tasks.await

class EventRepository {
    private val db = FirebaseFirestore.getInstance()

    suspend fun getEvents(): List<Event> {
        return try {
            val snapshot = db.collection("events").get().await()
            snapshot.toObjects(Event::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }
}

