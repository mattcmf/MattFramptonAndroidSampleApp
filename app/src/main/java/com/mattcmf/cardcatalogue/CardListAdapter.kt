package com.mattcmf.cardcatalogue

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mattcmf.cardcatalogue.data.Card
import com.mattcmf.cardcatalogue.databinding.ItemCardHolderBinding

class CardListAdapter : RecyclerView.Adapter<CardListAdapter.CardHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CardHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_card_holder,
            parent
            , false
        )
    )

    var cards: List<Card> = emptyList()
        set(value) {
            if (field != value) {
                val diffCallback = CardListDiffCallback(field, value)
                val diffResult = DiffUtil.calculateDiff(diffCallback)
                field = value
                diffResult.dispatchUpdatesTo(this)
            }
        }

    override fun getItemCount(): Int = cards.size


    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        holder.itemCardHolderBinding.card = cards[position]
    }

    class CardHolder(
        val itemCardHolderBinding: ItemCardHolderBinding
    ) : RecyclerView.ViewHolder(itemCardHolderBinding.root) {

    }
}