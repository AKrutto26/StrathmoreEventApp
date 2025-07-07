package com.strathmore.eventapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.strathmore.eventapp.R
import com.strathmore.eventapp.viewmodel.EventViewModel

class EventListFragment : Fragment() {

    private lateinit var eventRecyclerView: RecyclerView
    private lateinit var createEventFab: FloatingActionButton
    private lateinit var eventAdapter: EventAdapter

    // Get a reference to the shared EventViewModel
    private val viewModel: EventViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find your views
        eventRecyclerView = view.findViewById(R.id.event_recycler_view)
        createEventFab = view.findViewById(R.id.create_event_fab)

        // Setup the list and the click listeners
        setupRecyclerView()
        setupRoleBasedUi()
        setupClickListeners()

        // Observe the list of events from the ViewModel
        viewModel.events.observe(viewLifecycleOwner, Observer { events ->
            // When the list changes, update the adapter
            eventAdapter.submitList(events)
        })
    }

    private fun setupRecyclerView() {
        // Initialize the adapter and define what happens when an item is clicked
        eventAdapter = EventAdapter { event ->
            // Create a bundle to pass the clicked event's ID
            val bundle = bundleOf("eventId" to event.id)
            // Navigate to the detail screen, passing the bundle
            findNavController().navigate(R.id.action_eventListFragment_to_eventDetailFragment, bundle)
        }

        // Attach the adapter and layout manager to the RecyclerView
        eventRecyclerView.apply {
            adapter = eventAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun setupClickListeners() {
        // Set the click listener for the "+" button to navigate to the create screen
        createEventFab.setOnClickListener {
            findNavController().navigate(R.id.action_eventListFragment_to_createEventFragment)
        }
    }

    private fun setupRoleBasedUi() {
        // This simulates checking the user's role.
        // In the real app, this value will come from a login state.
        val userRole = "ADMIN" // Try changing this to "STUDENT" to test

        if (userRole == "ADMIN") {
            createEventFab.visibility = View.VISIBLE
        } else {
            createEventFab.visibility = View.GONE
        }
    }
}