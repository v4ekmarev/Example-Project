package com.vladlen.data.persistence.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.vladlen.data.persistence.dao.base.BaseDao
import com.vladlen.data.persistence.entity.BookEntity
import com.vladlen.data.persistence.entity.BookEntity.Companion.BOOK_ID
import com.vladlen.data.persistence.entity.BookEntity.Companion.BOOK_IS_FAVORITE
import com.vladlen.data.persistence.entity.BookEntity.Companion.BOOK_TABLE
import com.vladlen.data.persistence.entity.BookEntity.Companion.BOOK_USER_NAME

@Dao
abstract class BookDao : BaseDao<BookEntity> {

    /**
     * Select a book by the id
     * @param id The book id
     * @return A [BookEntity]
     */
    @Query("SELECT * FROM $BOOK_TABLE WHERE $BOOK_ID = :id")
    abstract fun get(id: Long): BookEntity?

    /**
     * Select all books by the userName
     * @return A list of [BookEntity] of all the books in the table for user
     */
    @Query("SELECT * FROM $BOOK_TABLE WHERE $BOOK_USER_NAME = :userName")
    abstract fun getAll(userName: String): List<BookEntity>

    /**
     * Update is favorite book by the id
     * @param id The book id
     * @param isFavorite If book is favorite or not
     * @return A number of book updated. This should always be `1`
     */
    @Query("UPDATE $BOOK_TABLE SET $BOOK_IS_FAVORITE = :isFavorite WHERE $BOOK_ID = :id")
    abstract fun updateIsFavorite(id: Long, isFavorite: Boolean): Int

    @Transaction
    open fun insertAndDeleteInTransaction(newBook: BookEntity, oldBook: BookEntity) {
        // Anything inside this method runs in a single transaction.
        insert(newBook)
        delete(oldBook)
    }

}
