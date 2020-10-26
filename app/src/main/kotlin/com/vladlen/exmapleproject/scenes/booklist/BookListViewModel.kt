package com.vladlen.exmapleproject.scenes.booklist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vladlen.domain.model.Book
import com.vladlen.domain.usecases.GetBookListUseCase
import com.vladlen.exmapleproject.scenes.base.BaseViewModel
import com.vladlen.exmapleproject.scenes.view.ResultState
import javax.inject.Inject

class BookListViewModel @Inject constructor(
    private val getBookListUseCase: GetBookListUseCase
) : BaseViewModel() {

    private var bookListLiveData = MutableLiveData<ResultState<Collection<Book>>>()

    fun getBookListLiveData(): MutableLiveData<ResultState<Collection<Book>>> = bookListLiveData

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

}
