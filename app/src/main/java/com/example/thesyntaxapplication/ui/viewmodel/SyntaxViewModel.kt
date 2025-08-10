package com.example.thesyntaxapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thesyntaxapplication.data.DataInitializer
import com.example.thesyntaxapplication.data.model.ProgrammingLanguage
import com.example.thesyntaxapplication.data.model.SyntaxCategory
import com.example.thesyntaxapplication.data.model.SyntaxEntry
import com.example.thesyntaxapplication.data.repository.SyntaxRepository
import com.example.thesyntaxapplication.ui.state.SyntaxUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class SyntaxViewModel @Inject constructor(
    private val repository: SyntaxRepository,
    private val dataInitializer: DataInitializer
) : ViewModel() {

    private val _uiState = MutableStateFlow(SyntaxUiState())
    val uiState: StateFlow<SyntaxUiState> = _uiState.asStateFlow()

    init {
        dataInitializer.initializeData()
        loadInitialData()
    }

    private fun loadInitialData() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            
            try {
                // Load languages
                repository.getAllLanguages().collect { languages ->
                    _uiState.update { it.copy(languages = languages) }
                }
                
                // Load categories
                repository.getAllCategories().collect { categories ->
                    _uiState.update { it.copy(categories = categories) }
                }
                
                // Load favorites
                repository.getFavoriteEntries().collect { favorites ->
                    _uiState.update { it.copy(favorites = favorites) }
                }
                
                _uiState.update { it.copy(isLoading = false) }
            } catch (e: Exception) {
                _uiState.update { 
                    it.copy(
                        isLoading = false,
                        error = e.message ?: "Unknown error occurred"
                    )
                }
            }
        }
    }

    fun selectLanguage(language: ProgrammingLanguage) {
        _uiState.update { it.copy(selectedLanguage = language) }
        loadEntriesForLanguage(language.id)
    }

    fun selectCategory(category: SyntaxCategory) {
        _uiState.update { it.copy(selectedCategory = category) }
        loadEntriesForLanguageAndCategory()
    }

    fun updateSearchQuery(query: String) {
        _uiState.update { it.copy(searchQuery = query) }
        if (query.isNotEmpty()) {
            searchEntries(query)
        } else {
            loadEntriesForLanguageAndCategory()
        }
    }

    fun toggleFavorite(entry: SyntaxEntry) {
        viewModelScope.launch {
            try {
                repository.updateFavoriteStatus(entry.id, !entry.isFavorite)
            } catch (e: Exception) {
                _uiState.update { 
                    it.copy(error = e.message ?: "Failed to update favorite")
                }
            }
        }
    }

    private fun loadEntriesForLanguage(languageId: String) {
        viewModelScope.launch {
            try {
                repository.getEntriesByLanguage(languageId).collect { entries ->
                    _uiState.update { it.copy(entries = entries) }
                }
            } catch (e: Exception) {
                _uiState.update { 
                    it.copy(error = e.message ?: "Failed to load entries")
                }
            }
        }
    }

    private fun loadEntriesForLanguageAndCategory() {
        val currentState = _uiState.value
        val languageId = currentState.selectedLanguage?.id
        val categoryId = currentState.selectedCategory?.id

        if (languageId != null && categoryId != null) {
            viewModelScope.launch {
                try {
                    repository.getEntriesByLanguageAndCategory(languageId, categoryId).collect { entries ->
                        _uiState.update { it.copy(entries = entries) }
                    }
                } catch (e: Exception) {
                    _uiState.update { 
                        it.copy(error = e.message ?: "Failed to load entries")
                    }
                }
            }
        }
    }

    private fun searchEntries(query: String) {
        val currentState = _uiState.value
        val languageId = currentState.selectedLanguage?.id

        viewModelScope.launch {
            try {
                val searchFlow = if (languageId != null) {
                    repository.searchEntriesByLanguage(languageId, query)
                } else {
                    repository.searchEntries(query)
                }
                
                searchFlow.collect { entries ->
                    _uiState.update { it.copy(entries = entries) }
                }
            } catch (e: Exception) {
                _uiState.update { 
                    it.copy(error = e.message ?: "Failed to search entries")
                }
            }
        }
    }

    fun clearError() {
        _uiState.update { it.copy(error = null) }
    }
}
