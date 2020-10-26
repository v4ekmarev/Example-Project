package com.vladlen.exmapleproject.scenes.booklist

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.vladlen.domain.model.Book
import com.vladlen.domain.usecases.GetBookListUseCase
import com.vladlen.domain.usecases.SaveFavoriteBookUseCase
import com.vladlen.exmapleproject.scenes.base.BaseViewModel
import com.vladlen.exmapleproject.scenes.view.ResultState
import javax.inject.Inject

class BookListViewModel @Inject constructor(
    private val getBookListUseCase: GetBookListUseCase,
    private val saveFavoriteBookUseCase: SaveFavoriteBookUseCase,
) : BaseViewModel() {

    private var bookListLiveData = MutableLiveData<ResultState<Collection<Book>>>()
    private var updateFavoriteBookLiveData = MutableLiveData<ResultState<Book>>()

    fun getBookListLiveData(): MutableLiveData<ResultState<Collection<Book>>> = bookListLiveData

    fun getUpdateStateFavoriteBookLiveData(): MutableLiveData<ResultState<Book>> = updateFavoriteBookLiveData

    fun fetchBookList(query: String = "Book") {
        getBookListUseCase.execute(query)
            .doOnSubscribe {
                bookListLiveData.value = ResultState.Loading
                compositeDisposable.add(it)
            }
            .subscribe({
                bookListLiveData.value = ResultState.Success(it)
            }, {
                bookListLiveData.value = ResultState.Error(it)
            })
    }

    fun updateFavoriteBook(book: Book) {
        saveFavoriteBookUseCase.execute(book)
            .doOnSubscribe {
                bookListLiveData.value = ResultState.Loading
                compositeDisposable.add(it)
            }
            .subscribe({
                updateFavoriteBookLiveData.value = ResultState.Success(book)
            }, {
                updateFavoriteBookLiveData.value = ResultState.Error(it)
            })
    }
}
