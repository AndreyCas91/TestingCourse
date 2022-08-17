package com.gb.testingcourse.presenter.search

import android.view.View
import com.gb.testingcourse.presenter.PresenterContract

internal interface PresenterSearchContract : PresenterContract {
    fun searchGitHub(searchQuery: String)

    fun test(): String{
        val x = "aawdaf"
        return x
    }
}
