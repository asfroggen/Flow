package com.example.flow.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.flow.models.UserEntity

abstract class BaseAdapter (
    private val layoutId : Int
): RecyclerView.Adapter<BaseAdapter.UserViewHolder>(){

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    protected val diffCallback = object : DiffUtil.ItemCallback<UserEntity>(){
        override fun areItemsTheSame(oldCache: UserEntity, newCache: UserEntity): Boolean {
            return oldCache.id == newCache.id
        }

        override fun areContentsTheSame(oldCache: UserEntity, newCache: UserEntity): Boolean {
            return oldCache.hashCode() == newCache.hashCode()
        }
    }

    protected abstract val differ : AsyncListDiffer<UserEntity>

    open var users : List<UserEntity>
        get() = differ.currentList
        set(value) = differ.submitList(value)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(
                layoutId,
                parent,
                false
            )
        )
    }

    protected var onItemClickListener: ((UserEntity) -> Unit)? = null

    fun setItemClickListener(listener: (UserEntity) -> Unit){
        onItemClickListener = listener
    }

    override fun getItemCount(): Int {
        return users.size
    }

}