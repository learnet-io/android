package io.learnet.app.ui.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import io.learnet.app.R
import io.learnet.app.ui.textinput.RichTextEditor
import jp.wasabeef.richeditor.RichEditor


class CreatePostReplyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.create_post_reply, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        RichTextEditor(view?.findViewById(R.id.editor) as RichEditor, view)
    }
}