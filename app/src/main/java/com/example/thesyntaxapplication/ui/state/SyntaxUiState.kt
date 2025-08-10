package com.example.thesyntaxapplication.ui.state

import com.example.thesyntaxapplication.data.model.ProgrammingLanguage
import com.example.thesyntaxapplication.data.model.SyntaxCategory
import com.example.thesyntaxapplication.data.model.SyntaxEntry

data class SyntaxUiState(
    val languages: List<ProgrammingLanguage> = emptyList(),
    val categories: List<SyntaxCategory> = emptyList(),
    val entries: List<SyntaxEntry> = emptyList(),
    val favorites: List<SyntaxEntry> = emptyList(),
    val selectedLanguage: ProgrammingLanguage? = null,
    val selectedCategory: SyntaxCategory? = null,
    val searchQuery: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
)

sealed class SyntaxScreen {
    object Languages : SyntaxScreen()
    object Categories : SyntaxScreen()
    object Entries : SyntaxScreen()
    object Favorites : SyntaxScreen()
    object Search : SyntaxScreen()
    data class EntryDetail(val entryId: String) : SyntaxScreen()
}
