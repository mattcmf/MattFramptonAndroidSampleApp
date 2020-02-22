package com.matcmf.mattframpton_sampleapp

import androidx.recyclerview.widget.DiffUtil
import com.matcmf.mattframpton_sampleapp.data.Card

class CardListDiffCallback(private val oldList: List<Card>, private val newList: List<Card>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return oldList[oldPosition] == newList[newPosition]
    }
}