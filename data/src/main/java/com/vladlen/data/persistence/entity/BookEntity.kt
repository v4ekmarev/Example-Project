package com.vladlen.data.persistence.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.vladlen.data.persistence.entity.BookEntity.Companion.BOOK_TABLE

@Entity(tableName = BOOK_TABLE)
class BookEntity(
    @PrimaryKey @ColumnInfo(name = BOOK_ID) val id: Long,
    @ColumnInfo(name = BOOK_NAME) val authorName: String,
    @ColumnInfo(name = BOOK_DESCRIPTION) val description: String,
    @ColumnInfo(name = BOOK_URL) val link: String,
    @ColumnInfo(name = BOOK_IS_FAVORITE) val isFavorite: Boolean
) {

    companion object {
        // TABLE
        const val BOOK_TABLE = "book_table"

        // COLUMN
        const val BOOK_ID = "id"
        const val BOOK_NAME = "name"
        const val BOOK_DESCRIPTION = "description"
        const val BOOK_URL = "url"
        const val BOOK_IS_FAVORITE = "is_favorite"
    }
}
