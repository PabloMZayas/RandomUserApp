package com.example.randomuserapp.ui.useradapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.randomuserapp.databinding.ResultItemBinding
import com.example.randomuserapp.ui.models.ResultUi
import com.example.randomuserapp.ui.models.UserRoomUiModel

class UserViewHolder (itemBinding: ResultItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

    private var tvFullName = itemBinding.tvShowFullName
    private var userImage = itemBinding.ivUserImage
    private var tvUserEmail = itemBinding.tvEmail
    private var tvUserCell = itemBinding.tvCell
    private var tvUserGender = itemBinding.tvGender
    private var cvUser = itemBinding.cvUser


    fun bind (userRoomUiModel: UserRoomUiModel, onItemClickListener: (UserRoomUiModel) -> Unit) = userRoomUiModel.run {

        tvFullName.text = "user: ${nameUi.title} ${nameUi.first} ${nameUi.last}"
        //tvUserCell.text = cell
        //tvUserGender.text = gender
        tvUserEmail.text = email

        Glide.with(userImage.context).load(userRoomUiModel.pictureUi).into(userImage)

        cvUser.setOnClickListener {
            onItemClickListener(userRoomUiModel)
        }
    }
}
