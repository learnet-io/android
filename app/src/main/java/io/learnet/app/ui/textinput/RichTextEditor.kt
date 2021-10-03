package io.learnet.app.ui.textinput

import android.graphics.Color
import android.view.View
import android.widget.ImageButton
import io.learnet.app.R
import jp.wasabeef.richeditor.RichEditor

/**
 * @author Bizuwork Melesse
 * created on 10/3/21
 *
 * Initialize rich text editor with default behavior
 */
class RichTextEditor(private val mEditor: RichEditor, private val view: View) {

    init {
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
        view.findViewById<ImageButton>(R.id.action_indent).setOnClickListener({ mEditor!!.setIndent() })
        view.findViewById<ImageButton>(R.id.action_outdent).setOnClickListener({ mEditor!!.setOutdent() })
        view.findViewById<ImageButton>(R.id.action_insert_link).setOnClickListener {
            mEditor!!.insertLink(
                "https://learnet.io",
                "LearNet"
            )
        }
    }
}