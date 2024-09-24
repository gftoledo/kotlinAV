package com.example.atividadepraticaavaliativa

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.atividadepraticaavaliativa.ui.TelaCadastroProduto
import com.example.atividadepraticaavaliativa.ui.TelaListaProdutos
import com.example.atividadepraticaavaliativa.ui.TelaDetalhesProduto
import com.example.atividadepraticaavaliativa.ui.TelaEstatisticas

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Variáveis de estado para alternar entre as telas
            var isCadastro by remember { mutableStateOf(true) }
            var produtoSelecionado by remember { mutableStateOf<Produto?>(null) }
            var mostrarEstatisticas by remember { mutableStateOf(false) }

            // Navegação entre telas
            when {
                mostrarEstatisticas -> {
                    TelaEstatisticas() // Exibe a tela de estatísticas
                }
                produtoSelecionado != null -> {
                    // Exibe a tela de detalhes do produto selecionado
                    TelaDetalhesProduto(
                        produto = produtoSelecionado!!,
                        onVoltar = { produtoSelecionado = null } // Retorna à lista ao clicar em "Voltar"
                    )
                }
                isCadastro -> {
                    // Exibe a tela de cadastro de produto
                    TelaCadastroProduto { produto ->
                        Estoque.adicionarProduto(produto)
                        Toast.makeText(
                            this,
                            "Produto cadastrado com sucesso! Valor total do estoque: R$ ${Estoque.calcularValorTotalEstoque()}",
                            Toast.LENGTH_LONG
                        ).show()
                        isCadastro = false // Muda para a tela de lista após o cadastro
                    }
                }
                else -> {
                    // Exibe a tela de lista de produtos
                    TelaListaProdutos(
                        onProdutoSelecionado = { produto ->
                            produtoSelecionado = produto // Define o produto selecionado para ver os detalhes
                        },
                        onEstatisticasClicked = {
                            mostrarEstatisticas = true // Muda para exibir a tela de estatísticas
                        }
                    )
                }
            }
        }
    }
}