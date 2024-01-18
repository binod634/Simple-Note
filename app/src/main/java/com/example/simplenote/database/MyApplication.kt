package com.example.simplenote.database

import android.app.Application
import androidx.room.Room

class MyApplication: Application() {
    val db = Room.databaseBuilder(applicationContext, klass = DatabaseEntity::class.java, name = "noteDatabase").build()
}