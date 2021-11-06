package com.example.psix.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.isEmpty
import androidx.recyclerview.widget.RecyclerView
import com.example.psix.R
import com.example.psix.databinding.ItemContactBinding
import com.example.psix.models.Contact

class ContactAdapter(var list: List<Contact>, var onItemClickListener: OnItemClickListener) :RecyclerView.Adapter<ContactAdapter.Vh>() {

    inner class Vh(var itemContactBinding: ItemContactBinding) : RecyclerView.ViewHolder(itemContactBinding.root) {

        fun onBind(contact: Contact) {
            itemContactBinding.name.text = contact.name
            itemContactBinding.phone.text = contact.phoneNumber
            
            itemContactBinding.date.text = contact.sana

            itemContactBinding.root.setOnClickListener {
                onItemClickListener.onItemContactClick(contact)
            }
            itemContactBinding.editt.setOnClickListener {
                onItemClickListener.onItemClick(contact, position, itemContactBinding.editt)
            }
            itemContactBinding.delete.setOnClickListener {
                onItemClickListener.onItemDelete(contact, position, itemContactBinding.delete)
            }

            if (itemContactBinding.name.text.isEmpty()){
                itemContactBinding.root.visibility = View.GONE
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh (ItemContactBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    interface OnItemClickListener{
        fun onItemContactClick(contact: Contact)
        fun onItemClick(contact: Contact, position: Int, button: Button)
        fun onItemDelete(contact: Contact, position: Int, button: Button)
    }
}