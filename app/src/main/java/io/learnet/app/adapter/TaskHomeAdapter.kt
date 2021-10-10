package io.learnet.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.learnet.app.R
import io.learnet.app.ui.task.TaskPlaceholder
import io.learnet.app.ui.utils.BaseViewHolder

/**
 * @author Bizuwork Melesse
 * created on 9/26/21
 */
class TaskHomeAdapter(private val viewItems: List<*>) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    companion object {
        private const val TYPE_TASK_PLACEHOLDER = 0
    }

    inner class TaskPlaceholderViewHolder(itemView: View) : BaseViewHolder<TaskPlaceholder>(itemView) {
        override fun bind(item: TaskPlaceholder) {
            val eventTitleView = itemView.findViewById<TextView>(R.id.tv_task_placeholder)
            eventTitleView.text = item.value
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
           TYPE_TASK_PLACEHOLDER -> {
                val taskPlaceholderView = inflater.inflate(R.layout.task_placeholder, parent, false)
                TaskPlaceholderViewHolder(taskPlaceholderView)
            } else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is TaskPlaceholderViewHolder -> holder.bind(viewItems[position] as TaskPlaceholder)
        }
    }

    override fun getItemCount(): Int {
        return viewItems.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (viewItems[position]) {
            is TaskPlaceholder -> TYPE_TASK_PLACEHOLDER
            else -> throw IllegalArgumentException("Invalid type of data $position")
        }
    }
}