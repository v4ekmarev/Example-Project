package com.vladlen.data.persistence.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.vladlen.data.persistence.entity.BookEntity.Companion.BOOK_TABLE

@Entity(tableName = BOOK_TABLE)
class BookEntity(
    @PrimaryKey @ColumnInfo(name = BOOK_ID) val id: String,
    @ColumnInfo(name = BOOK_TITLE) val authorName: String,
    @ColumnInfo(name = BOOK_URL) val link: String,
    @ColumnInfo(name = BOOK_URL_IMG) val imgLink: String,
    @ColumnInfo(name = BOOK_IS_FAVORITE) val isFavorite: Boolean
) {

    companion object {
        // TABLE
        const val BOOK_TABLE = "book_table"

        // COLUMN
        const val BOOK_ID = "id"
        const val BOOK_TITLE = "title"
        const val BOOK_URL = "link"
        const val BOOK_URL_IMG = "img_link"
        const val BOOK_IS_FAVORITE = "is_favorite"
    }
}
