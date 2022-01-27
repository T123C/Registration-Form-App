package com.tc.registrationformapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.tc.registrationformapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    //using ViewBinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSpinner()
        setupButton()
    }

    private fun setupSpinner() {
        val titles = arrayOf("Ms", "Mr", "Dr", "Prof")
        val titleAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, titles)
        binding.spinnerTitle.adapter = titleAdapter
    }

    //button to take the user to the Summary Activity
    private fun setupButton() {
        binding.buttonRegister.setOnClickListener {
            createAccount()
        }
    }

    //adding data entered to User object and passing it to Summary Activity
    private fun createAccount() {
        val user = User(
            binding.spinnerTitle.selectedItem as String,
            binding.editTextFirstName.text.toString(),
            binding.editTextLastName.text.toString(),
            binding.editTextEmail.text.toString(),
            binding.editTextPhone.text.toString(),
            binding.editTextCountry.text.toString(),
            binding.editTextPassword.text.toString(),
        )

        val intent = Intent(this, SummaryActivity::class.java)
        intent.putExtra("User", user)
        startActivity(intent)
    }
}