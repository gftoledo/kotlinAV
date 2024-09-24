package com.example.atividadepraticaavaliativa

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TelaDetalhesProduto(produto: Produto, onVoltar: () -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Nome: ${produto.nome}", style = MaterialTheme.typography.titleMedium)
        Text(text = "Categoria: ${produto.categoria}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Preço: R$ ${produto.preco}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Quantidade em Estoque: ${produto.quantidade}", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { onVoltar() }, // Chama a função onVoltar quando o botão é clicado
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Voltar")
        }
    }
}