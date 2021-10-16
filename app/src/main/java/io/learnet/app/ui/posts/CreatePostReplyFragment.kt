package io.learnet.app.ui.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import io.learnet.app.R
import io.learnet.app.ui.textinput.RichTextEditor
import jp.wasabeef.richeditor.RichEditor


class CreatePostReplyFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.create_post_reply, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButtons()
        RichTextEditor(view?.findViewById(R.id.editor) as RichEditor, view)
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