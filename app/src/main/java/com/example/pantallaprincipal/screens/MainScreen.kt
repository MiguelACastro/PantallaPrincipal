package com.example.pantallaprincipal.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pantallaprincipal.components.Contact

@Composable
fun MainScreen() {
    val contactList = remember { mutableStateListOf<Pair<String, String>>() }
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    val isNameValid by remember {
        derivedStateOf { name.isNotBlank() && name.all { it.isLetter() || it.isWhitespace() } }
    }
    val isPhoneValid by remember {
        derivedStateOf { phone.length == 10 && phone.all { it.isDigit() } }
    }

    val isFormValid by remember {
        derivedStateOf { isNameValid && isPhoneValid }
    }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nombre") },
            isError = name.isNotEmpty() && !isNameValid,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Teléfono") },
            isError = phone.isNotEmpty() && !isPhoneValid,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if (isFormValid) {
                    contactList.add(Pair(name, phone))
                    name = ""
                    phone = ""
                }
            },
            enabled = isFormValid,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Agregar Contacto")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { contactList.clear() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Limpiar Todo")
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(contactList) { contact ->
                Contact(name = contact.first, phone = contact.second)
                Spacer(modifier = Modifier.height(8.dp).
                                            fillMaxWidth())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}
