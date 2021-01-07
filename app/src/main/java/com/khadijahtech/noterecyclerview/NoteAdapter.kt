package com.khadijahtech.noterecyclerview

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class NoteAdapter(private val notesList: List<Note>): RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class  NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val imageView: ImageView = itemView.findViewById(R.id.image_view)
        val text1: TextView = itemView.findViewById(R.id.note1_text_view)
        val text2: TextView = itemView.findViewById(R.id.note2_text_view)
        val priorityText: TextView = itemView.findViewById(R.id.priority_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.note_list_item,
        parent, false)
        return NoteViewHolder(itemView)
    }

    override fun getItemCount()=  notesList.size


    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = notesList[position]
        if(currentNote.notePriority > 5)
        {
            holder.priorityText.setTextColor(Color.RED)
            holder.imageView.setImageResource(R.drawable.ic_priorety)
        }else
        { //reset
            holder.priorityText.setTextColor(Color.BLACK)
        }
        holder.priorityText.setText(currentNote.notePriority.toString())
       // holder.imageView.setImageResource(currentNote.imageResource)
        holder.text1.setText(currentNote.note1Text)
        holder.text2.setText(currentNote.note2Text)
    }
}