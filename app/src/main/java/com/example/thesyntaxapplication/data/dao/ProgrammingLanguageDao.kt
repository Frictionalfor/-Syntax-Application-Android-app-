package com.example.thesyntaxapplication.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.thesyntaxapplication.data.model.ProgrammingLanguage
import kotlinx.coroutines.flow.Flow

@Dao
interface ProgrammingLanguageDao {
    @Query("SELECT * FROM programming_languages ORDER BY name")
    fun getAllLanguages(): Flow<List<ProgrammingLanguage>>
    
    @Query("SELECT * FROM programming_languages WHERE id = :languageId")
    suspend fun getLanguageById(languageId: String): ProgrammingLanguage?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLanguage(language: ProgrammingLanguage)
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLanguages(languages: List<ProgrammingLanguage>)
}
