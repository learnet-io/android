package io.learnet.app.ui.richtext

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import io.learnet.app.R
import jp.wasabeef.richeditor.RichEditor


class RichTextFragment : Fragment() {

    private lateinit var mEditor: RichEditor
    private lateinit var mPreview: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.rich_text_input, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            mEditor = view?.findViewById(R.id.editor) as RichEditor
            mEditor!!.setEditorHeight(200)
            mEditor!!.setEditorFontSize(22)
            mEditor!!.setEditorFontColor(Color.RED)
            //mEditor.setEditorBackgroundColor(Color.BLUE);
            //mEditor.setBackgroundColor(Color.BLUE);
            //mEditor.setBackgroundResource(R.drawable.bg);
            mEditor!!.setPadding(10, 10, 10, 10)
            //mEditor.setBackground("https://raw.githubusercontent.com/wasabeef/art/master/chip.jpg");
            mEditor!!.setPlaceholder("Insert text here...")
            //mEditor.setInputEnabled(false);
            mPreview = view.findViewById(R.id.preview) as TextView
            mEditor!!.setOnTextChangeListener { text -> mPreview!!.text = text }
            view.findViewById<ImageButton>(R.id.action_undo).setOnClickListener(View.OnClickListener { mEditor!!.undo() })
            view.findViewById<ImageButton>(R.id.action_redo).setOnClickListener(View.OnClickListener { mEditor!!.redo() })
            view.findViewById<ImageButton>(R.id.action_bold).setOnClickListener(View.OnClickListener { mEditor!!.setBold() })
            view.findViewById<ImageButton>(R.id.action_italic).setOnClickListener(View.OnClickListener { mEditor!!.setItalic() })
            view.findViewById<ImageButton>(R.id.action_subscript).setOnClickListener(View.OnClickListener { mEditor!!.setSubscript() })
            view.findViewById<ImageButton>(R.id.action_superscript).setOnClickListener(View.OnClickListener { mEditor!!.setSuperscript() })
            view.findViewById<ImageButton>(R.id.action_strikethrough).setOnClickListener(View.OnClickListener { mEditor!!.setStrikeThrough() })
            view.findViewById<ImageButton>(R.id.action_underline).setOnClickListener(View.OnClickListener { mEditor!!.setUnderline() })
            view.findViewById<ImageButton>(R.id.action_heading1).setOnClickListener(View.OnClickListener {
                mEditor!!.setHeading(
                    1
                )
            })
            view.findViewById<ImageButton>(R.id.action_heading2).setOnClickListener(View.OnClickListener {
                mEditor!!.setHeading(
                    2
                )
            })
            view.findViewById<ImageButton>(R.id.action_heading3).setOnClickListener(View.OnClickListener {
                mEditor!!.setHeading(
                    3
                )
            })
            view.findViewById<ImageButton>(R.id.action_heading4).setOnClickListener(View.OnClickListener {
                mEditor!!.setHeading(
                    4
                )
            })
            view.findViewById<ImageButton>(R.id.action_heading5).setOnClickListener(View.OnClickListener {
                mEditor!!.setHeading(
                    5
                )
            })
            view.findViewById<ImageButton>(R.id.action_heading6).setOnClickListener(View.OnClickListener {
                mEditor!!.setHeading(
                    6
                )
            })
            view.findViewById<ImageButton>(R.id.action_txt_color).setOnClickListener(object : View.OnClickListener {
                private var isChanged = false
                override fun onClick(v: View) {
                    mEditor.setTextColor(if (isChanged) Color.BLACK else Color.RED)
                    isChanged = !isChanged
                }
            })
            view.findViewById<ImageButton>(R.id.action_bg_color).setOnClickListener(object : View.OnClickListener {
                private var isChanged = false
                override fun onClick(v: View) {
                    mEditor.setTextBackgroundColor(if (isChanged) Color.TRANSPARENT else Color.YELLOW)
                    isChanged = !isChanged
                }
            })
            view.findViewById<ImageButton>(R.id.action_indent).setOnClickListener(View.OnClickListener { mEditor!!.setIndent() })
            view.findViewById<ImageButton>(R.id.action_outdent).setOnClickListener(View.OnClickListener { mEditor!!.setOutdent() })
            view.findViewById<ImageButton>(R.id.action_align_left).setOnClickListener(View.OnClickListener { mEditor!!.setAlignLeft() })
            view.findViewById<ImageButton>(R.id.action_align_center).setOnClickListener(View.OnClickListener { mEditor!!.setAlignCenter() })
            view.findViewById<ImageButton>(R.id.action_align_right).setOnClickListener(View.OnClickListener { mEditor!!.setAlignRight() })
            view.findViewById<ImageButton>(R.id.action_blockquote).setOnClickListener(View.OnClickListener { mEditor!!.setBlockquote() })
            view.findViewById<ImageButton>(R.id.action_insert_bullets).setOnClickListener(View.OnClickListener { mEditor!!.setBullets() })
            view.findViewById<ImageButton>(R.id.action_insert_numbers).setOnClickListener(View.OnClickListener { mEditor!!.setNumbers() })
            view.findViewById<ImageButton>(R.id.action_insert_image).setOnClickListener(View.OnClickListener {
                mEditor!!.insertImage(
                    "https://raw.githubusercontent.com/wasabeef/art/master/chip.jpg",
                    "dachshund", 320
                )
            })
            view.findViewById<ImageButton>(R.id.action_insert_youtube).setOnClickListener(View.OnClickListener {
                mEditor!!.insertYoutubeVideo(
                    "https://www.youtube.com/embed/pS5peqApgUA"
                )
            })
            view.findViewById<ImageButton>(R.id.action_insert_audio).setOnClickListener(View.OnClickListener {
                mEditor!!.insertAudio(
                    "https://file-examples-com.github.io/uploads/2017/11/file_example_MP3_5MG.mp3"
                )
            })
            view.findViewById<ImageButton>(R.id.action_insert_video).setOnClickListener(View.OnClickListener {
                mEditor!!.insertVideo(
                    "https://test-videos.co.uk/vids/bigbuckbunny/mp4/h264/1080/Big_Buck_Bunny_1080_10s_10MB.mp4",
                    360
                )
            })
            view.findViewById<ImageButton>(R.id.action_insert_link).setOnClickListener(View.OnClickListener {
                mEditor!!.insertLink(
                    "https://github.com/wasabeef",
                    "wasabeef"
                )
            })
            view.findViewById<ImageButton>(R.id.action_insert_checkbox).setOnClickListener(View.OnClickListener { mEditor!!.insertTodo() })

        }
}