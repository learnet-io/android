package io.learnet.app.ui.events

import java.time.Month

data class EventCalendar(
    val month: Short,
    val events: Map<Int, List<EventItem>>
)
