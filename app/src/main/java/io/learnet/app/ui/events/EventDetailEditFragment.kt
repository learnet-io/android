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
import io.learnet.app.ui.utils.SoftInputAssist

class EventDetailEditFragment : Fragment() {

    private lateinit var softAssist: SoftInputAssist

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.event_detail_edit, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let { softAssist = SoftInputAssist(it, R.dimen.bottom_margin) }
    }

    override fun onResume() {
        softAssist?.onResume()
        super.onResume()
    }

    override fun onPause() {
        softAssist?.onPause()
        super.onPause()
    }

    override fun onDestroy() {
        softAssist?.onDestroy()
        super.onDestroy()
    }
}