package com.ort.tp3.parcialgrupo3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.ort.tp3.parcialgrupo3.R

class DetailFragment : Fragment() {
    private lateinit var description: TextView
    private lateinit var price: TextView
    private lateinit var productImage: ImageView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        description = view.findViewById(R.id.product_description)
        price = view.findViewById(R.id.product_price)
        productImage = view.findViewById(R.id.product_image)

        arguments?.let {
            val product = DetailFragmentArgs.fromBundle(it).product

            description.text = product.description
            price.text = "$${product.price}"
            /*  Glide.with(this)
                .load(product.imageLink)
                .into(productImage)*/
        }

    }
}