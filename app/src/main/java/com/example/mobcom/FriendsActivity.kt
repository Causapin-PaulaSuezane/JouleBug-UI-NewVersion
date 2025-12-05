package com.example.mobcom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobcom.databinding.ActivityFriendsBinding
import com.google.android.material.tabs.TabLayoutMediator

class FriendsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFriendsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFriendsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
    }

    private fun setupUI() {
        // Back button
        binding.btnBack.setOnClickListener {
            finish()
        }

        // Add Friend button (placeholder)
        binding.btnAddFriend.setOnClickListener {
            // TODO: Implement add friend functionality
        }

        // Setup ViewPager with adapter
        val adapter = FriendsPagerAdapter(this)
        binding.viewPager.adapter = adapter

        // Connect TabLayout with ViewPager
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "MY FRIENDS"
                1 -> "REQUESTS"
                2 -> "FIND FRIENDS"
                else -> ""
            }
        }.attach()
    }
}