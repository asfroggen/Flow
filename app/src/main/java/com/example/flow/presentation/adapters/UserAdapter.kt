package com.example.flow.presentation.adapters

import android.content.Context
import androidx.recyclerview.widget.AsyncListDiffer
import com.example.flow.R
import com.example.flow.models.UserEntity
import com.example.flow.utils.load
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.android.synthetic.main.item_user.view.*
import javax.inject.Inject

class UserAdapter  @Inject constructor(
    @ApplicationContext context: Context
) : BaseAdapter(R.layout.item_user) {

    override val differ = AsyncListDiffer(this, diffCallback)

    fun submitList(list : List<UserEntity>) = differ.submitList(list)

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]

        holder.itemView.apply {
            setOnClickListener {
                onItemClickListener?.let { click ->
                    click(user)
                }
            }

            tvName.text = user.name
            tvEmail.text = user.email
            ivAvatar.load(user.avatar)

        }
    }
}