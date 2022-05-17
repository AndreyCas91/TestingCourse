package com.gb.testingcourse

import android.content.Context
import android.os.Build
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.gb.testingcourse.view.search.MainActivity
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runner.manipulation.Ordering
import org.robolectric.annotation.Config


@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class AttachDetachSearchPresenterTest {

    private lateinit var scenario: ActivityScenario<MainActivity>
    private lateinit var context: Context

    @Before
    fun setup(){
        scenario = ActivityScenario.launch(MainActivity::class.java)
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun onAttach_test(){
        scenario.onActivity {
            Assert.assertNotNull(it.getViewRef())
        }
    }

    @Test
    fun onDetach_test(){
        scenario.onActivity {
            it.onDetachInActivity()
            Assert.assertNull(it.getViewRef())
        }
    }

    @After
    fun close(){
        scenario.close()
    }
}