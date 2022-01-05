package com.nikola

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nikola.entities.AddText

@Database(
    entities = [AddText::class],
    version = 1
)

abstract class TextDatabase: RoomDatabase() {

    abstract fun textDAO(): TextDAO

    companion object {
        @Volatile
        private var INSTANCE: TextDatabase? = null

        fun getInstance(context: Context): TextDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    TextDatabase::class.java,
                    "text_db1").allowMainThreadQueries()
                    .build().also { INSTANCE = it }
            }
        }

    }
}