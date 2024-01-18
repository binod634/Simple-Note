package com.example.simplenote.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NoteData::class], version = 1)
abstract class DatabaseEntity : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao
}