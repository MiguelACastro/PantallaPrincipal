package com.example.pantallaprincipal.components

import com.example.pantallaprincipal.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Contact(name: String, phone: String) {
    Row() {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Foto del contacto",
            modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.size(12.dp))
        Column() {
            Text(
                text = name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = phone,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ContactPreview() {
    Contact("Juan", "123456789")
}
