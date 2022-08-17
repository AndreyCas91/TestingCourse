package com.gb.testingcourse.presenter.search

import android.view.View
import com.gb.testingcourse.model.SearchResponse
import com.gb.testingcourse.repository.GitHubRepository
import com.gb.testingcourse.repository.GitHubRepository.GitHubRepositoryCallback
import com.gb.testingcourse.view.search.ViewSearchContract
import retrofit2.Response
import java.lang.ref.WeakReference

/**
 * В архитектуре MVP все запросы на получение данных адресуются в Репозиторий.
 * Запросы могут проходить через Interactor или UseCase, использовать источники
 * данных (DataSource), но суть от этого не меняется.
 * Непосредственно Презентер отвечает за управление потоками запросов и ответов,
 * выступая в роли регулировщика движения на перекрестке.
 */

internal class SearchPresenter internal constructor(
    private val viewContract: ViewSearchContract,
    private val repository: GitHubRepository
) : PresenterSearchContract, GitHubRepositoryCallback {

    private var viewRef: WeakReference<View>? = null

    override fun searchGitHub(searchQuery: String) {
        viewContract.displayLoading(true)
        repository.searchGithub(searchQuery, this)
    }

    override fun handleGitHubResponse(response: Response<SearchResponse?>?) {
        viewContract.displayLoading(false)
        if (response != null && response.isSuccessful) {
            val searchResponse = response.body()
            val searchResults = searchResponse?.searchResults
            val totalCount = searchResponse?.totalCount
            if (searchResults != null && totalCount != null) {
                viewContract.displaySearchResults(
                    searchResults,
                    totalCount
                )
            } else {
                viewContract.displayError("Search results or total count are null")
            }
        } else {
            viewContract.displayError("Response is null or unsuccessful")
        }
    }

    override fun handleGitHubError() {
        viewContract.displayLoading(false)
        viewContract.displayError()
    }

    override fun getView() = viewRef?.get()


    override fun onAttach(v: View) {
        this.viewRef = WeakReference(v)
    }

    override fun onDetach() {
        viewRef?.clear()
        viewRef = null
    }
}
