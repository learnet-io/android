package io.learnet.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import io.learnet.app.R
import io.learnet.app.activity.MainActivity
import io.learnet.app.ui.event.EventCalendar
import io.learnet.app.ui.event.EventDetailFragment
import io.learnet.app.ui.event.EventItem
import io.learnet.app.ui.event.EventPlaceholder
import io.learnet.app.ui.utils.SectionHeader
import io.learnet.app.ui.utils.BaseViewHolder

/**
 * @author Bizuwork Melesse
 * created on 9/26/21
 */
class EventHomeAdapter(private val viewItems: List<*>) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    companion object {
        private const val TYPE_EVENT_CALENDAR = 0
        private const val TYPE_EVENT_DATE = 1
        private const val TYPE_EVENT_ITEM = 2
        private const val TYPE_EVENT_PLACEHOLDER = 3
    }

    inner class EventCalendarViewHolder(itemView: View) : BaseViewHolder<EventCalendar>(itemView) {
        override fun bind(item: EventCalendar) {
            // TODO: populate the calendar here
        }
    }

    inner class EventItemViewHolder(itemView: View) : BaseViewHolder<EventItem>(itemView),
        View.OnClickListener {
        override fun bind(item: EventItem) {
            val eventTitleView = itemView.findViewById<TextView>(R.id.tv_event_title)
            val eventSummaryView = itemView.findViewById<TextView>(R.id.tv_event_summary)
            eventTitleView.text = item.title
            eventSummaryView.text = item.summary

            eventTitleView.setOnClickListener(this)
            eventSummaryView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            loadEventDetails(p0!!.context as MainActivity)
        }

        private fun loadEventDetails(activity: MainActivity) {
            activity.supportFragmentManager!!.beginTransaction()
                .replace(R.id.fragment_container, EventDetailFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    inner class EventPlaceholderViewHolder(itemView: View) : BaseViewHolder<EventPlaceholder>(itemView) {
        override fun bind(item: EventPlaceholder) {
            val eventTitleView = itemView.findViewById<TextView>(R.id.tv_event_placeholder)
            eventTitleView.text = item.value
        }
    }

    inner class EventSectionHeaderViewHolder(itemView: View) : BaseViewHolder<SectionHeader>(itemView) {
        override fun bind(item: SectionHeader) {
            val headerView = itemView.findViewById<TextView>(R.id.tv_event_date)
            headerView.text = item.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_EVENT_CALENDAR -> {
                val eventCalendarView = inflater.inflate(R.layout.event_item_calendar, parent, false)
                EventCalendarViewHolder(eventCalendarView)
            } TYPE_EVENT_PLACEHOLDER -> {
                val eventPlaceholderView = inflater.inflate(R.layout.event_placeholder, parent, false)
                EventPlaceholderViewHolder(eventPlaceholderView)
            } TYPE_EVENT_ITEM -> {
                val eventItemView = inflater.inflate(R.layout.fragment_event_item, parent, false)
                EventItemViewHolder(eventItemView)
            } TYPE_EVENT_DATE -> {
                val eventDateView = inflater.inflate(R.layout.event_section_header, parent, false)
                EventSectionHeaderViewHolder(eventDateView)
            } else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is EventCalendarViewHolder -> holder.bind(viewItems[position] as EventCalendar)
            is EventItemViewHolder -> holder.bind(viewItems[position] as EventItem)
            is EventSectionHeaderViewHolder -> holder.bind(viewItems[position] as SectionHeader)
            is EventPlaceholderViewHolder -> holder.bind(viewItems[position] as EventPlaceholder)
        }
    }

    override fun getItemCount(): Int {
        return viewItems.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (viewItems[position]) {
            is EventCalendar -> TYPE_EVENT_CALENDAR
            is SectionHeader -> TYPE_EVENT_DATE
            is EventItem -> TYPE_EVENT_ITEM
            is EventPlaceholder -> TYPE_EVENT_PLACEHOLDER
            else -> throw IllegalArgumentException("Invalid type of data $position")
        }
    }
}