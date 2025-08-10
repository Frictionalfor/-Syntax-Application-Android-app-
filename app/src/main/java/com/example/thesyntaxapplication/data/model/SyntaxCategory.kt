package com.example.thesyntaxapplication.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "syntax_categories")
data class SyntaxCategory(
    @PrimaryKey val id: String,
    val name: String,
    val displayName: String,
    val description: String,
    val icon: String,
    val order: Int
)
