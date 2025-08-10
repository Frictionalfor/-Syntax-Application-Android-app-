package com.example.thesyntaxapplication.di

import android.content.Context
import com.example.thesyntaxapplication.data.dao.ProgrammingLanguageDao
import com.example.thesyntaxapplication.data.dao.SyntaxCategoryDao
import com.example.thesyntaxapplication.data.dao.SyntaxEntryDao
import com.example.thesyntaxapplication.data.database.SyntaxDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): SyntaxDatabase {
        return SyntaxDatabase.getDatabase(context)
    }
    
    @Provides
    fun provideProgrammingLanguageDao(database: SyntaxDatabase): ProgrammingLanguageDao {
        return database.programmingLanguageDao()
    }
    
    @Provides
    fun provideSyntaxCategoryDao(database: SyntaxDatabase): SyntaxCategoryDao {
        return database.syntaxCategoryDao()
    }
    
    @Provides
    fun provideSyntaxEntryDao(database: SyntaxDatabase): SyntaxEntryDao {
        return database.syntaxEntryDao()
    }
}
