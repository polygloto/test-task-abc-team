package com.mikhailovalx.test_task_abc_team.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mikhailovalx.test_task_abc_team.R
import kotlinx.coroutines.*

class SplashScreenActivity : AppCompatActivity() {

    private val scope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen_layout)

        // display splash screen for 3 seconds
        scope.launch {
            delay(3000)
            startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
            finish()
        }
    }

    override fun onPause() {
        scope.cancel()
        super.onPause()
    }
}