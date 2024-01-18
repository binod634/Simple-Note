package com.example.simplenote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplenote.database.DatabaseDao
import com.example.simplenote.database.NoteData
import kotlinx.coroutines.launch

class AppViewModel(private val databaseDao: DatabaseDao) : ViewModel() {
    val noteData = databaseDao.getAllNote()
    var noteView:NoteData? = null
        private set
    fun deleteCurrentNote() {
        viewModelScope.launch {
            databaseDao.deleteNote(noteView!!)
        }
    }
    fun addNote(noteData: NoteData) {
        viewModelScope.launch {
            databaseDao.addNote(noteData)
        }
    }

    fun noteToView(noteData: NoteData) {
        noteView = noteData
    }

}