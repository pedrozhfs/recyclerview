package com.example.listareciclavel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.listareciclavel.databinding.ActivityMainBinding
import com.example.listareciclavel.model.pais

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val lAdapter = ItemLinhaAdapter()
    var cont = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //var rc = findViewById<RecyclerView>(R.id.lista_reciclavel_rv)
        setupRecyCler()
        binding.addItemBtn.setOnClickListener {
            lAdapter.addLista(pais("Item $cont", "Detalhe do item $cont"))
            cont++
        }
    }

    private fun setupRecyCler() {
        binding.listaReciclavelRv.layoutManager = //LinearLayoutManager(this)
        StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL )
        val l = mutableListOf<pais>()
        l.add(pais("Brasil", "SAM"))
        l.add(pais("India", "Asia"))
        l.add(pais("Japão", "Asia"))
        l.add(pais("Canada", "America do Norte"))
        l.add(pais("Brasil", "SAM"))
        l.add(pais("India", "Asia"))
        l.add(pais("Japão", "Asia"))
        l.add(pais("Canada", "America do Norte"))
         lAdapter.setLista(l)
        binding.listaReciclavelRv.adapter = lAdapter
    }
}