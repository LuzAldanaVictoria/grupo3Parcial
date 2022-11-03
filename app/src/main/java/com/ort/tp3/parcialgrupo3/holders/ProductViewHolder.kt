package com.ort.tp3.parcialgrupo3.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ort.tp3.parcialgrupo3.R
import com.ort.tp3.parcialgrupo3.models.Product

class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    private val description: TextView
    private val price: TextView
    private val image: ImageView

    init {
        description = itemView.findViewById(R.id.product_description_text)
        price = itemView.findViewById(R.id.product_price_text)
        image = itemView.findViewById(R.id.product_image)
    }

    fun bind(product: Product) {
        description.text = product.description
        price.text = "$${product.price}"

    }
}