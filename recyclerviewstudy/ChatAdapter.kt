package com.example.recyclerviewstudy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_chat.view.*


class ChatAdapter: RecyclerView.Adapter<ChatAdapter.ItemViewHolder>(){
    private  val chats = ArrayList<Chat>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapter.ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatAdapter.ItemViewHolder, position: Int) {
        holder.bind(chats[position])
    }

    override fun getItemCount(): Int {
        return chats.size
    }

    fun addChat(chat: Chat){
        chats.add(chat)
    }

    fun addChat(chat: ArrayList<Chat>){
        this.chats.addAll(chats)
        notifyDataSetChanged()
    }
    inner class ItemViewHolder(View: View) : RecyclerView.ViewHolder(View){
        fun bind(chat: Chat) {

            itemView.apply {
                item_tv_chat_name.text = chat.name
                item_tv_chat_message.text = chat.message
            }
        }
    }
}