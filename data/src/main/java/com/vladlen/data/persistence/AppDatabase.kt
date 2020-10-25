package com.vladlen.data.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vladlen.data.persistence.dao.BookDao
import com.vladlen.data.persistence.entity.BookEntity

@Database(entities = [(BookEntity::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun bookDao(): BookDao

}
