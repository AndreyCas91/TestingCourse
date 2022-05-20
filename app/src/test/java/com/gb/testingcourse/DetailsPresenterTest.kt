package com.gb.testingcourse

import com.gb.testingcourse.presenter.details.DetailsPresenter
import com.gb.testingcourse.presenter.details.PresenterDetailsContract
import com.gb.testingcourse.view.details.ViewDetailsContract
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class DetailsPresenterTest {

    private lateinit var presenter: DetailsPresenter

    @Mock
    private lateinit var viewContract: ViewDetailsContract

    private val count: Int = 0

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)

        presenter = DetailsPresenter(viewContract)
    }

    @Test
    fun getCount_test(){
        presenter.setCounter(count)

        Assert.assertEquals(count, presenter.getCount())
    }

    @Test
    fun onIncrement_test(){
        presenter.setCounter(count)
        presenter.onIncrement()

        Assert.assertEquals(1, presenter.getCount())
    }

    @Test
    fun onDecrement_test(){
        presenter.setCounter(count)
        presenter.onDecrement()

        Assert.assertEquals(-1, presenter.getCount())
    }
}