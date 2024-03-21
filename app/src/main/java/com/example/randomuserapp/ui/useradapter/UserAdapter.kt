package com.example.randomuserapp.ui.useradapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.randomuserapp.databinding.ResultItemBinding
import com.example.randomuserapp.ui.models.ResultUi
import com.example.randomuserapp.ui.models.UserModelUi
import com.example.randomuserapp.ui.models.UserRoomUiModel

class UserAdapter (
        private var items: MutableList<UserRoomUiModel>,
        private var onUserClickListener: (UserRoomUiModel) -> Unit,
) : RecyclerView.Adapter<UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
                ResultItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val itemWord = items[position]
        holder.bind(itemWord, onUserClickListener)
    }

    override fun getItemCount(): Int = items.size
}