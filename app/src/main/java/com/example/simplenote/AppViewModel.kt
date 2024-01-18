package com.example.simplenote

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplenote.database.DatabaseDao
import com.example.simplenote.database.NoteData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AppViewModel(private val databaseDao: DatabaseDao) : ViewModel() {
    val noteData = databaseDao.getAllNote()
    fun deleteNote(noteData: NoteData) {
        viewModelScope.launch {
            databaseDao.deleteNote(noteData)
        }
    }
    fun addNote(noteData: NoteData) {
        viewModelScope.launch {
            databaseDao.addNote(noteData)
        }
    }

}