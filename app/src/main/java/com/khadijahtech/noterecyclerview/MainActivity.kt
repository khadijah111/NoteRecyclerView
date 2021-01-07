package com.khadijahtech.noterecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val notesList = ArrayList<Note>()
    private val adapter = NoteAdapter(notesList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val insertBtn : Button = findViewById(R.id.insert_btn)
        val removeBtn : Button = findViewById(R.id.remove_btn)

        val insertText : EditText = findViewById(R.id.insert_edit_text)
        val removeText : EditText = findViewById(R.id.remove_edit_text)

        insertBtn.setOnClickListener {
            //insert
            val newItem = Note(R.drawable.ic_time,"new item",
                "details", Random.nextInt(10))
            notesList.add(newItem)
            adapter.notifyItemInserted(insertText.text.toString().toInt())
        }

        removeBtn.setOnClickListener {
            //remove
            val index = removeText.text.toString().toInt()
            notesList.removeAt(index)
            adapter.notifyItemRemoved(index)
        }

        buildArrayList()
        buildRecyclerView()
    }

    private fun buildArrayList ()
    {
        notesList.add(Note(R.drawable.ic_time, "note 1", "note 1 details",3))
        notesList.add(Note(R.drawable.ic_time, "note 1", "note 1 details",5))
        notesList.add(Note(R.drawable.ic_time, "note 1", "note 1 details",10))
        notesList.add(Note(R.drawable.ic_time, "note 1", "note 1 details",5))
        notesList.add(Note(R.drawable.ic_time, "note 1", "note 1 details",6))
        notesList.add(Note(R.drawable.ic_time, "note 1", "note 1 details",4))
    }

    private fun buildRecyclerView ()
    {
        notes_recycler_view.adapter = adapter
        notes_recycler_view.layoutManager = LinearLayoutManager(this)
        notes_recycler_view.setHasFixedSize(true)
    }
}