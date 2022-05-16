package com.gb.testingcourse.presenter.details

import android.view.View
import com.gb.testingcourse.presenter.PresenterContract

internal interface PresenterDetailsContract<T: View> : PresenterContract<T> {
    fun setCounter(count: Int)
    fun onIncrement()
    fun onDecrement()


}
