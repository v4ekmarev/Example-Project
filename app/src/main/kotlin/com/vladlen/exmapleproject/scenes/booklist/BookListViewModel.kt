package com.vladlen.exmapleproject.scenes.booklist

import com.vladlen.domain.usecases.GetBookListUseCase
import com.vladlen.exmapleproject.scenes.base.BaseViewModel
import javax.inject.Inject

class BookListViewModel @Inject constructor(
    private val getBookListUseCase: GetBookListUseCase
) : BaseViewModel() {

}
