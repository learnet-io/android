package io.learnet.app.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.learnet.app.R
import io.learnet.app.ui.event.CreateEventFragment


class UserProfileFragment : Fragment(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButtons()
    }

    private fun initButtons() {
        val editBtn = view?.findViewById<TextView>(R.id.tv_edit_profile_pencil)
        editBtn?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.tv_edit_profile_pencil -> launchProfileEditFragment()
        }
    }

    private fun launchProfileEditFragment() {
        activity?.supportFragmentManager!!.beginTransaction()
            .replace(R.id.fragment_container, UserProfileEditFragment())
            .addToBackStack(null)
            .commit()
    }
}