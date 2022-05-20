package com.gb.testingcourse.presenter

import android.view.View

internal interface PresenterContract<in T: View> {

    fun onAttach(v: View)

    fun onDetach()

    fun getView(): View?
}
