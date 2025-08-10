package com.example.thesyntaxapplication.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.thesyntaxapplication.data.model.SyntaxEntry
import kotlinx.coroutines.flow.Flow

@Dao
interface SyntaxEntryDao {
    @Query("SELECT * FROM syntax_entries WHERE languageId = :languageId ORDER BY `order`")
    fun getEntriesByLanguage(languageId: String): Flow<List<SyntaxEntry>>
    
    @Query("SELECT * FROM syntax_entries WHERE languageId = :languageId AND categoryId = :categoryId ORDER BY `order`")
    fun getEntriesByLanguageAndCategory(languageId: String, categoryId: String): Flow<List<SyntaxEntry>>
    
    @Query("SELECT * FROM syntax_entries WHERE isFavorite = 1 ORDER BY title")
    fun getFavoriteEntries(): Flow<List<SyntaxEntry>>
    
    @Query("SELECT * FROM syntax_entries WHERE title LIKE '%' || :query || '%' OR description LIKE '%' || :query || '%' OR keywords LIKE '%' || :query || '%' ORDER BY title")
    fun searchEntries(query: String): Flow<List<SyntaxEntry>>
    
    @Query("SELECT * FROM syntax_entries WHERE languageId = :languageId AND (title LIKE '%' || :query || '%' OR description LIKE '%' || :query || '%' OR keywords LIKE '%' || :query || '%') ORDER BY title")
    fun searchEntriesByLanguage(languageId: String, query: String): Flow<List<SyntaxEntry>>
    
    @Query("SELECT * FROM syntax_entries WHERE id = :entryId")
    suspend fun getEntryById(entryId: String): SyntaxEntry?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEntry(entry: SyntaxEntry)
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEntries(entries: List<SyntaxEntry>)
    
    @Update
    suspend fun updateEntry(entry: SyntaxEntry)
    
    @Query("UPDATE syntax_entries SET isFavorite = :isFavorite WHERE id = :entryId")
    suspend fun updateFavoriteStatus(entryId: String, isFavorite: Boolean)
}
