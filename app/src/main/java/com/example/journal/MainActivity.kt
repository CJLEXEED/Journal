package com.example.journal

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Edge-to-edge UI insets setup
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val journalDescription = findViewById<TextView>(R.id.journal_description)
        val expandButton = findViewById<ImageView>(R.id.expand_button)
        val collapseButton = findViewById<ImageView>(R.id.collapse_button)

        // Initial state
        journalDescription.visibility = View.GONE  // Collapsed initially
        expandButton.visibility = View.VISIBLE
        collapseButton.visibility = View.GONE

        // Expand button click listener
        expandButton.setOnClickListener {
            journalDescription.visibility = View.VISIBLE
            expandButton.visibility = View.GONE
            collapseButton.visibility = View.VISIBLE
        }

        // Collapse button click listener
        collapseButton.setOnClickListener {
            journalDescription.visibility = View.GONE
            collapseButton.visibility = View.GONE
            expandButton.visibility = View.VISIBLE
        }
    }
}
