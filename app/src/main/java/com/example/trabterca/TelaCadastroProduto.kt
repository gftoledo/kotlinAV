package com.example.atividadepraticaavaliativa.ui

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.atividadepraticaavaliativa.Produto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaCadastroProduto(onProdutoCadastrado: (Produto) -> Unit) {
    var nome by remember { mutableStateOf("") }
    var categoria by remember { mutableStateOf("") }
    var preco by remember { mutableStateOf("") }
    var quantidade by remember { mutableStateOf("") }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome do Produto") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = categoria,
            onValueChange = { categoria = it },
            label = { Text("Categoria") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = preco,
            onValueChange = { preco = it },
            label = { Text("Preço") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = quantidade,
            onValueChange = { quantidade = it },
            label = { Text("Quantidade em Estoque") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                if (nome.isNotEmpty() && categoria.isNotEmpty() && preco.isNotEmpty() && quantidade.isNotEmpty()) {
                    val precoDouble = preco.toDoubleOrNull()
                    val quantidadeInt = quantidade.toIntOrNull()

                    if (precoDouble != null && precoDouble >= 0 && quantidadeInt != null && quantidadeInt > 0) {
                        val produto = Produto(nome, categoria, precoDouble, quantidadeInt)
                        onProdutoCadastrado(produto)
                        // Limpa os campos após cadastro
                        nome = ""
                        categoria = ""
                        preco = ""
                        quantidade = ""
                    } else {
                        // Validação para preço e quantidade
                        Toast.makeText(context, "Preço deve ser maior que 0 e Quantidade maior que 1", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    // Mensagem de erro para campos vazios
                    Toast.makeText(context, "Todos os campos são obrigatórios", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cadastrar")
        }
    }
}