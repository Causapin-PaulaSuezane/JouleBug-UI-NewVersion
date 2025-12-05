package com.example.mobcom

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobcom.databinding.ActivityWelcomeBinding
import com.google.firebase.auth.FirebaseAuth

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Check if user is already logged in
        if (auth.currentUser != null) {
            navigateToHome()
            return
        }

        animateLogo()
        setupClickListeners()
    }

    private fun animateLogo() {
        // Animate the logo with bounce
        val logoAnimation = android.view.animation.AnimationUtils.loadAnimation(
            this,
            R.anim.bounce_animation
        )
        binding.ivLogo.startAnimation(logoAnimation)

    }

    private fun setupClickListeners() {
        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.btnSignUp.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        // Social login buttons (to be implemented)
        binding.btnGoogle.setOnClickListener {
            showToast("Google Sign-In coming soon!")
        }

        binding.btnFacebook.setOnClickListener {
            showToast("Facebook Login coming soon!")
        }

        binding.btnDiscord.setOnClickListener {
            showToast("Discord Login coming soon!")
        }
    }

    private fun navigateToHome() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    private fun showToast(message: String) {
        android.widget.Toast.makeText(this, message, android.widget.Toast.LENGTH_SHORT).show()
    }
}