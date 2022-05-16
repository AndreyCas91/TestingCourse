package com.gb.testingcourse.presenter.search

import android.view.View
import com.gb.testingcourse.presenter.PresenterContract

internal interface PresenterSearchContract<T: View> : PresenterContract<T> {
    fun searchGitHub(searchQuery: String)
}
