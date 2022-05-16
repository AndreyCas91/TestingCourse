package com.gb.testingcourse.view.search

import com.gb.testingcourse.model.SearchResult
import com.gb.testingcourse.view.ViewContract

internal interface ViewSearchContract : ViewContract {
    fun displaySearchResults(
        searchResults: List<SearchResult>,
        totalCount: Int
    )

    fun displayError()
    fun displayError(error: String)
    fun displayLoading(show: Boolean)
}
