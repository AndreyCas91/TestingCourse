package com.gb.testingcourse.presenter.details

import android.view.View
import com.gb.testingcourse.view.details.ViewDetailsContract
import java.lang.ref.WeakReference


internal class DetailsPresenter<T: View> internal constructor(
    private val viewContract: ViewDetailsContract,
    private var count: Int = 0
) : PresenterDetailsContract<T> {



    override fun setCounter(count: Int) {
        this.count = count
    }

    override fun onIncrement() {
        count++
        viewContract.setCount(count)
    }

    override fun onDecrement() {
        count--
        viewContract.setCount(count)
    }


}
