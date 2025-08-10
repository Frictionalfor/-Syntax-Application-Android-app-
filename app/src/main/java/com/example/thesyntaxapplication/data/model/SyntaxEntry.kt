package com.example.thesyntaxapplication.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "syntax_entries",
    foreignKeys = [
        ForeignKey(
            entity = ProgrammingLanguage::class,
            parentColumns = ["id"],
            childColumns = ["languageId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = SyntaxCategory::class,
            parentColumns = ["id"],
            childColumns = ["categoryId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class SyntaxEntry(
    @PrimaryKey val id: String,
    val languageId: String,
    val categoryId: String,
    val title: String,
    val description: String,
    val codeSnippet: String,
    val example: String,
    val keywords: String,
    val isFavorite: Boolean = false,
    val order: Int = 0
)
