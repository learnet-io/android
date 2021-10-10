package io.learnet.app.ui.task


/**
 * @author Bizuwork Melesse
 * created on 9/26/21
 */
class DemoTaskCreator {
    companion object {
        fun createEmptyTask(): TaskPlaceholder {
            val value = "Sorry, there are no tasks for today."
            return TaskPlaceholder(value)
        }
    }
}