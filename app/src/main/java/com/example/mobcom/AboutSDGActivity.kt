package com.example.mobcom

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobcom.databinding.ActivityAboutSdgBinding

class AboutSDGActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutSdgBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutSdgBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
    }

    private fun setupUI() {
        // Back button
        binding.btnBack.setOnClickListener {
            finish()
        }

        // Learn More SDG 11
        binding.btnLearnMoreSDG11.setOnClickListener {
            openUrl("https://sdgs.un.org/goals/goal11")
        }

        // Learn More SDG 13
        binding.btnLearnMoreSDG13.setOnClickListener {
            openUrl("https://sdgs.un.org/goals/goal13")
        }

        // View All SDGs
        binding.btnAllSDGs.setOnClickListener {
            openUrl("https://sdgs.un.org/goals")
        }
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}