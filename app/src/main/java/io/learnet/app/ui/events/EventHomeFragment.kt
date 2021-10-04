package io.learnet.app.ui.events

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.learnet.app.R
import io.learnet.app.adapter.EventHomeAdapter

class EventHomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_event_home, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val rvEventHome = view?.findViewById(R.id.rv_event_home) as RecyclerView
        val eventHomeItems = ArrayList<Any>()
        eventHomeItems.add(DemoEventCreator.createEventHomeCalendar())
        val adapter = EventHomeAdapter(eventHomeItems)
        rvEventHome.adapter = adapter
        rvEventHome.layoutManager = LinearLayoutManager(activity)
    }
}