package io.learnet.app.ui.events

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.learnet.app.R
import io.learnet.app.adapter.EventAdapter
import io.learnet.app.ui.utils.SectionHeader

class EventListFragment : Fragment() {
    val events = DemoEventCreator.createEventList(20)
//    val events = DemoEventCreator.createEmptyEvent();

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_event_item_list, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvEvents = view?.findViewById(R.id.rv_event_list) as RecyclerView
        val eventItems = ArrayList<Any>()
        if (events.events.size > 0) {
            eventItems.add(SectionHeader(events.date))
            eventItems.addAll(events.events)
        } else {
            eventItems.add(EventPlaceholder("${getString(R.string.event_placeholder)} ${events.date}"))
        }
        val adapter = EventAdapter(eventItems)
        rvEvents.adapter = adapter
        rvEvents.layoutManager = LinearLayoutManager(activity)
    }
}