package com.example.randomuserapp.ui.useradapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.randomuserapp.databinding.ResultItemBinding
import com.example.randomuserapp.ui.models.ResultUi

class UserViewHolder (itemBinding: ResultItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

    private var tvFullName = itemBinding.tvShowFullName
    private var userImage = itemBinding.ivUserImage
    private var tvUserEmail = itemBinding.tvEmail
    private var tvUserCell = itemBinding.tvCell
    private var tvUserGender = itemBinding.tvGender
    private var cvUser = itemBinding.cvUser


    fun bind (resultUi: ResultUi, onItemClickListener: (ResultUi) -> Unit) = resultUi.run {

        tvFullName.text = "user: ${name.title} ${name.first} ${name.last}"
        tvUserCell.text = cell
        tvUserGender.text = gender
        tvUserEmail.text = email

        Glide.with(userImage.context).load(resultUi.picture.medium).into(userImage)

        cvUser.setOnClickListener {
            onItemClickListener(resultUi)
        }
    }
}
