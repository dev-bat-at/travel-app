package com.github.kr328.clash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    companion object {
        private const val SPLASH_DELAY_MS = 2000L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            if (!isFinishing) {
                startActivity(Intent(this, MainActivity::class.java).apply {
                    if (intent?.extras != null) {
                        putExtras(intent.extras!!)
                    }
                })
                finish()
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            }
        }, SPLASH_DELAY_MS)
    }

    @Suppress("OVERRIDE_DEPRECATION")
    override fun onBackPressed() {
        // Prevent back press dismissing splash screen
    }
}
