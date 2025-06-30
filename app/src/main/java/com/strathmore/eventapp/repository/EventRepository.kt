package com.strathmore.eventapp.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.strathmore.eventapp.model.Event
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.catch

class EventRepository {

    private val firestore = FirebaseFirestore.getInstance()
    private val eventsCollection = firestore.collection("events")

    fun getEvents(): Flow<List<Event>> = flow {
        val snapshot = eventsCollection.get().await()
        val events = snapshot.documents.mapNotNull { it.toObject(Event::class.java)?.copy(id = it.id) }
        emit(events)
    }.catch { e ->
        emit(emptyList()) // fallback in case of error
        e.printStackTrace()
    }
}
