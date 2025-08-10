package com.example.thesyntaxapplication.data.repository

import com.example.thesyntaxapplication.data.dao.ProgrammingLanguageDao
import com.example.thesyntaxapplication.data.dao.SyntaxCategoryDao
import com.example.thesyntaxapplication.data.dao.SyntaxEntryDao
import com.example.thesyntaxapplication.data.model.ProgrammingLanguage
import com.example.thesyntaxapplication.data.model.SyntaxCategory
import com.example.thesyntaxapplication.data.model.SyntaxEntry
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SyntaxRepository @Inject constructor(
    private val programmingLanguageDao: ProgrammingLanguageDao,
    private val syntaxCategoryDao: SyntaxCategoryDao,
    private val syntaxEntryDao: SyntaxEntryDao
) {
    // Programming Languages
    fun getAllLanguages(): Flow<List<ProgrammingLanguage>> =
        programmingLanguageDao.getAllLanguages()
    
    suspend fun getLanguageById(languageId: String): ProgrammingLanguage? =
        programmingLanguageDao.getLanguageById(languageId)
    
    suspend fun insertLanguages(languages: List<ProgrammingLanguage>) =
        programmingLanguageDao.insertLanguages(languages)
    
    // Syntax Categories
    fun getAllCategories(): Flow<List<SyntaxCategory>> =
        syntaxCategoryDao.getAllCategories()
    
    suspend fun getCategoryById(categoryId: String): SyntaxCategory? =
        syntaxCategoryDao.getCategoryById(categoryId)
    
    suspend fun insertCategories(categories: List<SyntaxCategory>) =
        syntaxCategoryDao.insertCategories(categories)
    
    // Syntax Entries
    fun getEntriesByLanguage(languageId: String): Flow<List<SyntaxEntry>> =
        syntaxEntryDao.getEntriesByLanguage(languageId)
    
    fun getEntriesByLanguageAndCategory(languageId: String, categoryId: String): Flow<List<SyntaxEntry>> =
        syntaxEntryDao.getEntriesByLanguageAndCategory(languageId, categoryId)
    
    fun getFavoriteEntries(): Flow<List<SyntaxEntry>> =
        syntaxEntryDao.getFavoriteEntries()
    
    fun searchEntries(query: String): Flow<List<SyntaxEntry>> =
        syntaxEntryDao.searchEntries(query)
    
    fun searchEntriesByLanguage(languageId: String, query: String): Flow<List<SyntaxEntry>> =
        syntaxEntryDao.searchEntriesByLanguage(languageId, query)
    
    suspend fun getEntryById(entryId: String): SyntaxEntry? =
        syntaxEntryDao.getEntryById(entryId)
    
    suspend fun insertEntries(entries: List<SyntaxEntry>) =
        syntaxEntryDao.insertEntries(entries)
    
    suspend fun updateEntry(entry: SyntaxEntry) =
        syntaxEntryDao.updateEntry(entry)
    
    suspend fun updateFavoriteStatus(entryId: String, isFavorite: Boolean) =
        syntaxEntryDao.updateFavoriteStatus(entryId, isFavorite)
}
