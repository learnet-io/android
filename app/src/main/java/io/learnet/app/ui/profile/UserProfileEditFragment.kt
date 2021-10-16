package io.learnet.app.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.learnet.app.R
import io.learnet.app.ui.utils.SoftInputAssist


class UserProfileEditFragment : Fragment(), View.OnClickListener {

    private lateinit var softAssist: SoftInputAssist

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_profile_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let { softAssist = SoftInputAssist(it) }
        initButtons()
    }

    private fun initButtons() {
        val cancelBtn = view?.findViewById<TextView>(R.id.tv_cancel_profile_save)
        cancelBtn?.setOnClickListener(this)
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

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.tv_cancel_profile_save -> activity?.supportFragmentManager?.popBackStack()
        }
    }
}