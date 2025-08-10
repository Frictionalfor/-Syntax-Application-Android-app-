package com.example.thesyntaxapplication.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.thesyntaxapplication.data.model.SyntaxCategory
import kotlinx.coroutines.flow.Flow

@Dao
interface SyntaxCategoryDao {
    @Query("SELECT * FROM syntax_categories ORDER BY `order`")
    fun getAllCategories(): Flow<List<SyntaxCategory>>
    
    @Query("SELECT * FROM syntax_categories WHERE id = :categoryId")
    suspend fun getCategoryById(categoryId: String): SyntaxCategory?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: SyntaxCategory)
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategories(categories: List<SyntaxCategory>)
}
