package com.gb.testingcourse

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.longClick
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.gb.testingcourse.view.search.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setup(){
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun editTextIsDisplayed(){
        onView(withId(R.id.searchEditText)).check(matches(isDisplayed()))
    }

    @Test
    fun editTextIsWorking(){
        onView(withId(R.id.searchEditText)).check(matches(withHint("Enter keyword e.g. android")))
    }

    @Test
    fun buttonIsWorking(){
        onView(withId(R.id.toDetailsActivityButton)).check((matches(withText("to details"))))
    }

    @After
    fun close(){
        scenario.close()
    }
}