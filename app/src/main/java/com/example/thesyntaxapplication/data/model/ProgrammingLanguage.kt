package com.example.thesyntaxapplication.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "programming_languages")
data class ProgrammingLanguage(
    @PrimaryKey val id: String,
    val name: String,
    val displayName: String,
    val color: String,
    val icon: String
)
