package com.sampson.kotlinintegrationtests

import android.app.Application
import android.os.Build
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@Config(
    manifest=Config.NONE,
    sdk = [Build.VERSION_CODES.P],
    application = Application::class,
    assetDir = "/assetDir/")

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    private val context = getApplicationContext<Application>()

    @Test
    fun `show factorial result in text view`() {
        val scenario = launch<MainActivity>(MainActivity::class.java)
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onActivity { activity ->
            var edtNumber = activity.findViewById<EditText>(R.id.edtInsertNumber)
            var btnAction = activity.findViewById<Button>(R.id.btnAction)
            edtNumber.setText(5.toString())
            btnAction.performClick()
            assertEquals(context.getString(R.string.result, "120"), edtNumber.text)
        }
    }
}
