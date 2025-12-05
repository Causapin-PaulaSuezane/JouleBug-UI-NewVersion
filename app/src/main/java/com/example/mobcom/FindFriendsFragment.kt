package com.example.mobcom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FindFriendsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val textView = TextView(context)
        textView.text = "Find Friends\n\n(Coming Soon! 🔍)"
        textView.textAlignment = View.TEXT_ALIGNMENT_CENTER
        textView.setPadding(32, 32, 32, 32)
        return textView
    }
}