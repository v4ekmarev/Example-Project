package com.vladlen.exmapleproject.scenes.bookfavoritlist

import androidx.lifecycle.MutableLiveData
import com.vladlen.domain.model.Book
import com.vladlen.domain.usecases.GetFavoriteBookUseCase
import com.vladlen.domain.usecases.SaveFavoriteBookUseCase
import com.vladlen.exmapleproject.scenes.base.BaseViewModel
import com.vladlen.exmapleproject.scenes.view.ResultState
import javax.inject.Inject

class BookFavoriteListViewModel @Inject constructor(
    private val getFavoriteBookUseCase: GetFavoriteBookUseCase,
    private val saveFavoriteBookUseCase: SaveFavoriteBookUseCase,
    ) : BaseViewModel() {

    private var favoriteBookListLiveData = MutableLiveData<ResultState<Collection<Book>>>()

    fun getFavoriteBookListLiveData(): MutableLiveData<ResultState<Collection<Book>>> =
        favoriteBookListLiveData

    fun fetchFavoriteBookList() {
        compositeDisposable.add(getFavoriteBookUseCase.execute(true)
            .doOnSubscribe {
                favoriteBookListLiveData.value = ResultState.Loading
            }
            .subscribe({
                favoriteBookListLiveData.value = ResultState.Success(it)
            }, {
                favoriteBookListLiveData.value = ResultState.Error(it)
            })
        )
    }

    fun updateFavoriteBook(book: Book) {
        saveFavoriteBookUseCase.execute(book)
            .doOnSubscribe {
                compositeDisposable.add(it)
            }
            .subscribe({

            }, {

            })
    }
}
