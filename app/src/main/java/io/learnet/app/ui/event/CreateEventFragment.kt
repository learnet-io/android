package io.learnet.app.ui.event

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.learnet.app.R
import io.learnet.app.ui.utils.SoftInputAssist

class CreateEventFragment : Fragment(), View.OnClickListener {

    private lateinit var softAssist: SoftInputAssist

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.create_event, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButtons()
        activity?.let { softAssist = SoftInputAssist(it) }
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

    private fun initButtons() {
        val cancelBtn = view?.findViewById<TextView>(R.id.tv_cancel_btn)
        cancelBtn?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.tv_cancel_btn -> activity?.supportFragmentManager?.popBackStack()
        }
    }
}