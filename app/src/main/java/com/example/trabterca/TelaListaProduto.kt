package com.example.atividadepraticaavaliativa.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.atividadepraticaavaliativa.Produto
import com.example.atividadepraticaavaliativa.ProdutoRepository

@Composable
fun TelaListaProdutos(onProdutoSelecionado: (Produto) -> Unit, onEstatisticasClicked: () -> Unit) {
    val produtos = ProdutoRepository.listaDeProdutos

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(produtos) { produto ->
            ProdutoItem(produto) {
                onProdutoSelecionado(produto)
            }
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = onEstatisticasClicked,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Estatísticas")
            }
        }
    }
}

@Composable
fun ProdutoItem(produto: Produto, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "${produto.nome} (${produto.quantidade} unidades)", style = MaterialTheme.typography.titleMedium)
            Button(
                onClick = onClick, // Utilize o mesmo onClick para o botão "Detalhes"
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("Detalhes")
            }
        }
    }
}