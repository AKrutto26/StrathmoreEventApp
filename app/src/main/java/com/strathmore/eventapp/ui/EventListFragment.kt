package com.strathmore.eventapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.strathmore.eventapp.R

class EventListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // This line connects the Kotlin file to your XML layout
        return inflater.inflate(R.layout.fragment_event_list, container, false)
    }
}