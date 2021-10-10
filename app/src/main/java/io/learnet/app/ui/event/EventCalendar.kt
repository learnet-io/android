package io.learnet.app.ui.event

data class EventCalendar(
    val month: Short,
    val events: Map<Int, List<EventItem>>
)
