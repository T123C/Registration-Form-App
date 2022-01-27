package com.tc.registrationformapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tc.registrationformapp.databinding.ActivitySummaryBinding


class SummaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySummaryBinding
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrieveUser()
        displayUser()
        setupClickListeners()
    }

    //retrieving data from Main Activity User object
    private fun retrieveUser() {
        user = intent.getSerializableExtra("User") as User
    }

    //function to display the retrieved data
    private fun displayUser() {

        binding.textViewFullName.text = user.getFullName()
        binding.textViewCountry.text = user.country
        binding.textViewEmail.text = user.email
        binding.textViewPhone.text = user.phone

    }

    //function to include email and phone on click listeners
    private fun setupClickListeners() {

        binding.textViewEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:${user.email}")
            startActivity(intent)
        }

        binding.textViewPhone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${user.phone}")
            startActivity(intent)
        }
    }
}