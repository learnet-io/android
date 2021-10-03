package io.learnet.app.ui.textinput

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import io.learnet.app.R
import jp.wasabeef.richeditor.RichEditor


class RichTextFragment : Fragment() {

    private lateinit var mEditor: RichEditor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.rich_text_input, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        mEditor = view?.findViewById(R.id.editor) as RichEditor
        mEditor!!.setEditorHeight(200)
        mEditor!!.setEditorFontSize(18)
        mEditor!!.setEditorFontColor(Color.BLACK)
        mEditor!!.setPadding(16, 10, 16, 10)
        mEditor!!.setPlaceholder("What's on your mind?")
        view.findViewById<ImageButton>(R.id.action_bold).setOnClickListener({ mEditor!!.setBold() })
        view.findViewById<ImageButton>(R.id.action_italic).setOnClickListener({ mEditor!!.setItalic() })
        view.findViewById<ImageButton>(R.id.action_strikethrough).setOnClickListener({ mEditor!!.setStrikeThrough() })
        view.findViewById<ImageButton>(R.id.action_insert_bullets).setOnClickListener({ mEditor!!.setBullets() })
        view.findViewById<ImageButton>(R.id.action_insert_numbers).setOnClickListener({ mEditor!!.setNumbers() })
        view.findViewById<ImageButton>(R.id.action_insert_link).setOnClickListener {
            mEditor!!.insertLink(
                "https://learnet.io",
                "LearNet"
            )
        }
    }
}