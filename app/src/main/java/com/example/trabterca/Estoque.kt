package com.example.atividadepraticaavaliativa

object Estoque {
    private val produtos = mutableListOf<Produto>()

    fun adicionarProduto(produto: Produto) {
        produtos.add(produto)
    }

    fun calcularValorTotalEstoque(): Double {
        return produtos.sumOf { it.preco * it.quantidade }
    }

    fun quantidadeTotalProdutos(): Int {
        return produtos.sumOf { it.quantidade }
    }
}

