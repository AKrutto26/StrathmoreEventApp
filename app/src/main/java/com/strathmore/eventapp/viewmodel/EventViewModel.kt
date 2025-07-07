package com.strathmore.eventapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.strathmore.eventapp.model.Event
import com.strathmore.eventapp.repository.EventRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.UUID

class EventViewModel : ViewModel() {
    // This assumes Member 1 has created the EventRepository.
    // If not, this ViewModel will still work with a local list.
    private val repository = EventRepository()

    private val _events = MutableStateFlow<List<Event>>(emptyList())
    val events: StateFlow<List<Event>> = _events

    init {
        loadEvents()
    }

    private fun loadEvents() {
        // This will fetch events from the repository once connected.
        // For now, it might return an empty list, which is fine.
        viewModelScope.launch {
            _events.value = repository.getEvents()
        }
    }

    /**
     * This is the new function you need.
     * It creates a new event and adds it to the current list.
     */
    fun addEvent(title: String, description: String) {
        viewModelScope.launch {
            val newEvent = Event(
                id = UUID.randomUUID().toString(), // Generate a random ID
                title = title,
                date = "July 7, 2025", // Using today's date as a placeholder
                location = "Main Campus", // Placeholder location
                description = description
            )

            // For now, we will add the new event to our local list.
            // Later, this will be replaced by a call to repository.addEvent(newEvent)
            val updatedList = _events.value + newEvent
            _events.value = updatedList
        }
    }
}