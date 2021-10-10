package io.learnet.app.ui.event


/**
 * @author Bizuwork Melesse
 * created on 9/26/21
 */
class DemoEventCreator {
    companion object {
        fun createEmptyEvent(): EventItemListDto {
            val date = "June 5, 2021"
            return EventItemListDto(date, ArrayList())
        }

        fun createEventList(numEvents: Int): EventItemListDto {
            val date = "June 5, 2021"
            val events = ArrayList<EventItem>()
            for (i in 1..numEvents) {
                events.add(
                    EventItem(
                        "The Birth of a New City Wherein",
                        "",
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt...",
                    ""))
            }
            return EventItemListDto(date, events)
        }

        fun createEventHomeCalendar(): EventCalendar {
            val eventList = createEventList(5)
            val calendarItem = mutableMapOf<Int, List<EventItem>>()
            calendarItem[15] = createEventList(5).events
            return EventCalendar(1, calendarItem)
        }
    }
}