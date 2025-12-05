package com.example.mobcom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobcom.databinding.ActivityBadgesBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class BadgesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBadgesBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBadgesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase
        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()

        // Back button
        binding.btnBack.setOnClickListener {
            finish()
        }

        // Show coming soon message
        binding.tvEmptyState.visibility = android.view.View.VISIBLE
        binding.tvEmptyState.text = "COMING SOON! 🚧\n\nBadges feature is under construction."

        // Load actual badge count from Firestore
        loadBadgeCount()
    }

    private fun loadBadgeCount() {
        val currentUserId = auth.currentUser?.uid ?: return

        firestore.collection("users")
            .document(currentUserId)
            .get()
            .addOnSuccessListener { document ->
                val badgesEarned = document.getLong("badgesEarned")?.toInt() ?: 0
                binding.tvBadgeCount.text = "$badgesEarned Badges Earned"
            }
            .addOnFailureListener {
                binding.tvBadgeCount.text = "0 Badges Earned"
            }
    }
}