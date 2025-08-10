package com.example.thesyntaxapplication.data.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import com.example.thesyntaxapplication.data.dao.ProgrammingLanguageDao
import com.example.thesyntaxapplication.data.dao.SyntaxCategoryDao
import com.example.thesyntaxapplication.data.dao.SyntaxEntryDao
import com.example.thesyntaxapplication.data.model.ProgrammingLanguage
import com.example.thesyntaxapplication.data.model.SyntaxCategory
import com.example.thesyntaxapplication.data.model.SyntaxEntry

@Database(
    entities = [
        ProgrammingLanguage::class,
        SyntaxCategory::class,
        SyntaxEntry::class
    ],
    version = 1,
    exportSchema = false
)
abstract class SyntaxDatabase : RoomDatabase() {
    abstract fun programmingLanguageDao(): ProgrammingLanguageDao
    abstract fun syntaxCategoryDao(): SyntaxCategoryDao
    abstract fun syntaxEntryDao(): SyntaxEntryDao

    companion object {
        @Volatile
        private var INSTANCE: SyntaxDatabase? = null

        fun getDatabase(context: Context): SyntaxDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SyntaxDatabase::class.java,
                    "syntax_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
