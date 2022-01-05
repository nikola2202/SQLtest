package com.nikola

import androidx.room.*
import com.nikola.entities.AddText


@Dao
interface TextDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertText(someText: AddText)

    @Query("SELECT * FROM Tekst")
    fun getAllText(): AddText

    @Update
    fun updateText(someText: AddText)

    @Delete
    fun deleteText(someText: AddText)

}