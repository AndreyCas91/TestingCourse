package com.gb.testingcourse.presenter.search

import android.view.View
import com.gb.testingcourse.presenter.PresenterContract

internal interface PresenterSearchContract : PresenterContract {
    fun searchGitHub(searchQuery: String)

}
