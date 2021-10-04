package io.learnet.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.learnet.app.R
import io.learnet.app.ui.events.EventCalendar
import io.learnet.app.ui.events.EventItem
import io.learnet.app.ui.events.EventPlaceholder
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
    }

    inner class EventCalendarViewHolder(itemView: View) : BaseViewHolder<EventCalendar>(itemView) {
        override fun bind(item: EventCalendar) {
//            val eventTitleView = itemView.findViewById<TextView>(R.id.tv_event_title)
//            val eventSummaryView = itemView.findViewById<TextView>(R.id.tv_event_summary)
//            eventTitleView.text = item.title
//            eventSummaryView.text = item.summary
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_EVENT_CALENDAR -> {
                val eventCalendarView = inflater.inflate(R.layout.event_item_calendar, parent, false)
                EventCalendarViewHolder(eventCalendarView)
            } else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is EventCalendarViewHolder -> holder.bind(viewItems[position] as EventCalendar)
        }
    }

    override fun getItemCount(): Int {
        return viewItems.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (viewItems[position]) {
            is EventCalendar -> TYPE_EVENT_CALENDAR
            else -> throw IllegalArgumentException("Invalid type of data $position")
        }
    }
}