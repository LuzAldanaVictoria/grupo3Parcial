package com.ort.tp3.parcialgrupo3.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ort.tp3.parcialgrupo3.R
import com.ort.tp3.parcialgrupo3.utils.UserSession
import com.ort.tp3.parcialgrupo3.adapters.ProductAdapter
import com.ort.tp3.parcialgrupo3.listeners.OnProductClickedListener
import com.ort.tp3.parcialgrupo3.models.Product
import com.ort.tp3.parcialgrupo3.utils.Images


class HomeFragment : Fragment() , OnProductClickedListener {
    private lateinit var productsRecyclerView: RecyclerView
    private lateinit var productList: List<Product>
    private lateinit var title: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productsRecyclerView = view.findViewById(R.id.productRecyclerView)
        title = view.findViewById(R.id.title)
        arguments?.getString("username")?.let { UserSession.userName = it }
        title.text = "Hola, ${UserSession.userName}"
        fillProductList()
    }

    private fun fillProductList() {
        val product1 = Product("Google Pixel 5", Images.pixel, 70000.0)
        val product2 = Product("Remera estampada", Images.remera, 1500.0)
        val product3 = Product("Zapatillas nike", Images.zapatillas, 25000.0)
        val product4 = Product("Heladera no frost", Images.heladera, 80000.0)
        val product5 = Product("PC Gamer", Images.pcGamer, 150000.0)
        val product6 = Product("Campera invierno", Images.camperaInvierno, 30000.0)
        val product7 = Product("Campera verano", Images.camperaInvierno, 20000.0)
        val product8 = Product("Smart TV 4K", Images.pcGamer, 100000.0)
        val product9 = Product("Notebook", Images.pcGamer, 120000.0)
        val product10 = Product("Smartphone", Images.pixel, 50000.0)


        productList = listOf(product1, product2, product3, product4, product5, product6, product7, product8, product9, product10)

        val layoutManager = LinearLayoutManager(context)
        productsRecyclerView.layoutManager = layoutManager
        productsRecyclerView.adapter = ProductAdapter(productList, this)
    }

    override fun onProductSelected(product: Product) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(product))
    }

}