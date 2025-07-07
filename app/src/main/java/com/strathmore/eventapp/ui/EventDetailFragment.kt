package com.strathmore.eventapp.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.strathmore.eventapp.R
import com.strathmore.eventapp.model.Event
import com.strathmore.eventapp.viewmodel.EventViewModel

class EventDetailFragment : Fragment(R.layout.fragment_event_detail) {

    private val viewModel: EventViewModel by viewModels()
    private var eventId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Get the event ID that was passed during navigation
        eventId = arguments?.getString("eventId")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titleTextView = view.findViewById<TextView>(R.id.detail_title)
        val dateTextView = view.findViewById<TextView>(R.id.detail_date)
        val locationTextView = view.findViewById<TextView>(R.id.detail_location)
        val descriptionTextView = view.findViewById<TextView>(R.id.detail_description)
        val rsvpButton = view.findViewById<Button>(R.id.button_rsvp)

        viewModel.events.observe(viewLifecycleOwner, Observer { events ->
            // Find the specific event by its ID and update the UI
            val currentEvent = events.find { it.id == eventId }
            currentEvent?.let {
                titleTextView.text = it.title
                dateTextView.text = it.date
                locationTextView.text = it.location
                descriptionTextView.text = it.description ?: "No description available."
            }
        })

        rsvpButton.setOnClickListener {
            Toast.makeText(context, "RSVP Confirmed for ${titleTextView.text}!", Toast.LENGTH_LONG).show()
        }
    }
}