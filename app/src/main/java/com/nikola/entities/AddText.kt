package com.nikola.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Tekst")
data class AddText(
    @PrimaryKey(autoGenerate = false)
    var pkID: Int,
    var text: String
)