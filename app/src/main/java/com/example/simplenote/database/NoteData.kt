package com.example.simplenote.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TableName)
data class NoteData(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    @ColumnInfo(name = "title")
    val title:String,
    @ColumnInfo(name = "description")
    val description:String
)

const val TableName = "noteData"