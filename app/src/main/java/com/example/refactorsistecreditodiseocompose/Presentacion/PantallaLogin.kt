package com.example.refactorsistecreditodiseocompose.Presentacion

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun PantallaLogin(
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 180.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Sistecrédito",
            style = androidx.compose.ui.text.TextStyle(color = Color.White, fontSize = 42.sp, fontWeight = FontWeight.Black)
        )
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    )
    {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.60f)
                .padding(10.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {



                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextField(
                        value = "textValue",
                        onValueChange = { it },
                        label = { Text("Introducir Texto") }
                    )

                }

                //BOTON LOGIN
                Spacer(
                    modifier = Modifier
                        .padding(20.dp)
                )
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .clip(CircleShape)
                        .fillMaxWidth(0.8f)
                        .height(50.dp)
                ) {
                    Text(
                        text = "Crear una cuenta",
                        fontSize = 20.sp,
                        color = Color.White
                    )
                }
                //BOTON GOOGLE
                Spacer(
                    modifier = Modifier
                        .padding(10.dp)
                )

                Text(
                    text = "Already have a account?",
                    fontSize = 15.sp,
                    color = Color.Gray,
                    )

            }

        }
    }
    }

@Preview
@Composable
fun pre() {
    PantallaLogin()
}