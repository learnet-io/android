package io.learnet.app.ui.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import io.learnet.app.R
import io.learnet.app.ui.textinput.RichTextEditor
import io.learnet.app.ui.utils.SoftInputAssist
import jp.wasabeef.richeditor.RichEditor


class CreatePostFragment : Fragment(), View.OnClickListener {

    private lateinit var softAssist: SoftInputAssist

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.create_post, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let { softAssist = SoftInputAssist(it) }
        initButtons()
        RichTextEditor(view?.findViewById(R.id.editor) as RichEditor, view)
    }

    private fun initButtons() {
        val cancelBtn = view?.findViewById<TextView>(R.id.tv_cancel_btn)
        cancelBtn?.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        softAssist?.onResume()
    }

    override fun onPause() {
        super.onPause()
        softAssist?.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        softAssist?.onDestroy()

    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.tv_cancel_btn -> activity?.supportFragmentManager?.popBackStack()
        }
    }
}