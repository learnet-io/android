package io.learnet.app.ui.utils

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Bizuwork Melesse
 * created on 9/28/21
 */
abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T)
}