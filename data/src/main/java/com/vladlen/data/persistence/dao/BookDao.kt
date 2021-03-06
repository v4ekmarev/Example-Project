package com.vladlen.data.persistence.dao

import androidx.room.*
import com.vladlen.data.persistence.dao.base.BaseDao
import com.vladlen.data.persistence.entity.BookEntity
import com.vladlen.data.persistence.entity.BookEntity.Companion.BOOK_ID
import com.vladlen.data.persistence.entity.BookEntity.Companion.BOOK_IS_FAVORITE
import com.vladlen.data.persistence.entity.BookEntity.Companion.BOOK_TABLE
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
abstract class BookDao : BaseDao<BookEntity> {

    /**
     * Select a book by the id
     * @param id The book id
     * @return A [BookEntity]
     */
    @Query("SELECT * FROM $BOOK_TABLE WHERE $BOOK_ID = :id")
    abstract fun get(id: Long): Maybe<BookEntity>

    /**
     * Select all books
     * @return A list of [BookEntity] of all the books in the table for user
     */
    @Query("SELECT * FROM $BOOK_TABLE")
    abstract fun getAll(): Single<List<BookEntity>>

    /**
     * Select all isFavoriteBooks
     * @return A list of [BookEntity] of all the books in the table for user
     */
    @Query("SELECT * FROM $BOOK_TABLE WHERE $BOOK_IS_FAVORITE = :isFavorite")
    abstract fun getIsFavoriteBook(isFavorite: Boolean): Flowable<List<BookEntity>>

    /**
     * Update is favorite book by the id
     * @param id The book id
     * @param isFavorite If book is favorite or not
     * @return A number of book updated. This should always be `1`
     */
    @Query("UPDATE $BOOK_TABLE SET $BOOK_IS_FAVORITE = :isFavorite WHERE $BOOK_ID = :id")
    abstract fun updateIsFavorite(id: Long, isFavorite: Boolean): Single<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertFavoriteBook(bookEntity: BookEntity): Completable

    @Transaction
    open fun insertAndDeleteInTransaction(newBook: BookEntity, oldBook: BookEntity) {
        // Anything inside this method runs in a single transaction.
        insert(newBook)
        delete(oldBook)
    }
}
