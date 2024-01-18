package com.example.simplenote.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DatabaseDao {
    @Insert
    suspend fun addNote(noteData: NoteData)

    @Delete
    suspend fun deleteNote(noteData: NoteData)

    @Query("Select * from $TableName")
    fun getAllNote(): Flow<List<NoteData>>
}