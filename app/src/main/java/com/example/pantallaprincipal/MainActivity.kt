package com.example.pantallaprincipal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pantallaprincipal.ui.theme.PantallaPrincipalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PantallaPrincipalTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Login(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Login(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(R.drawable.login_image),
            contentDescription = "Persona al lado de un telefono",
            modifier = Modifier.padding(vertical = 32.dp)
        )

        Text(
            text = "Hola!",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Bienvenido a la aplicación!",
            fontSize = 24.sp,
            color = Color.Gray,
        )

        Spacer(modifier = Modifier.height(32.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth(0.75f)
                .clip(RoundedCornerShape(50))
                .background(Color.Blue)
                .padding(vertical = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Iniciar sesión",
                fontSize = 24.sp,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth(0.75f)
                .border(
                    width = 2.dp,
                    color = Color.Blue,
                    shape = RoundedCornerShape(50)
                )
                .clip(RoundedCornerShape(50))
                .padding(vertical = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Registrarse",
                fontSize = 24.sp,
                color = Color.Blue
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    PantallaPrincipalTheme {
        Login()
    }
}