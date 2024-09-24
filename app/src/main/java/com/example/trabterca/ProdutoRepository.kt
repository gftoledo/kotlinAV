package com.example.atividadepraticaavaliativa

object ProdutoRepository {
    val listaDeProdutos = mutableListOf<Produto>()

    fun addProduto(produto: Produto) {
        listaDeProdutos.add(produto)
    }
}