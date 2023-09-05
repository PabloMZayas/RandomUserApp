package com.example.randomuserapp.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.randomuserapp.databinding.ActivityShowAllInformationUserBinding
import com.example.randomuserapp.ui.models.ResultUi

class ShowAllUserInformationActivity: AppCompatActivity() {

    private lateinit var binding: ActivityShowAllInformationUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowAllInformationUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val resultUi = intent.getParcelableExtra<ResultUi>("myUser")

        if (resultUi != null) setDataInScreen(resultUi)
        else Toast.makeText(this, "is NULL", Toast.LENGTH_SHORT).show()
    }

    private fun setDataInScreen(resultUi: ResultUi) = resultUi.run {
        with(binding) {
            tvShowFullName.text = "user: ${name.title} ${name.first} ${name.last}"
            tvCell.text = cell
            tvGender.text = gender
            tvEmail.text = email
            tvCity.text = location.city
            tvState.text = location.state
            tvPostcode.text = location.postcode

            Glide.with(binding.tvCell.context).load(resultUi.picture.medium).into(ivUserImage)
        }
    }
}
