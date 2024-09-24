package com.example.atividadepraticaavaliativa.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.atividadepraticaavaliativa.Estoque

@Composable
fun TelaEstatisticas() {
    val valorTotal = Estoque.calcularValorTotalEstoque()
    val quantidadeTotal = Estoque.quantidadeTotalProdutos()

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Estatísticas do Estoque", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Valor Total do Estoque: R$ $valorTotal", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Quantidade Total de Produtos: $quantidadeTotal", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { /* Ação de voltar ou fechar a tela */ }) {
            Text("Voltar")
        }
    }
}


