package com.example.refactorsistecreditodiseocompose.Presentacion

import GoogleButton
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.refactorsistecreditodiseocompose.R


@Composable
fun PantallaLogin(
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 140.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Sistecrédito",
            style = TextStyle(color = Color.White, fontSize = 42.sp, fontWeight = FontWeight.Black)
        )
        Text(
            modifier = Modifier
                .padding(start = 60.dp),
            text = "lo hacemos posible",
            style = TextStyle(
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Black
            )
        )
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            modifier = Modifier
                .align(alignment = Alignment.Center)
                .padding(top = 250.dp),
        ) {
            Button(
                onClick = {},
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "Ingresa ahora",
                    modifier = Modifier.padding(
                        vertical = 15.dp,
                        horizontal = 110.dp
                    )
                )
            }
            Spacer(modifier = Modifier.padding(bottom = 25.dp))

            Row() {
                Button(
                    onClick = { },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = Color.White
                    )
                ) {
                    Text(
                        text = "Crear una cuenta",
                        modifier = Modifier
                            .padding(
                                vertical = 15.dp,
                                horizontal = 99.dp
                            ),
                        color = MaterialTheme.colors.background,
                    )


                }


            }
            Spacer(modifier = Modifier.height(10.dp))


        }

        GoogleButton(
            modifier = Modifier.fillMaxWidth()
                .offset(y= (-70).dp)
                .padding(50.dp)
        ) {

        }

    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        IconButton(
            onClick = { },
            modifier = Modifier.align(Alignment.BottomStart)
        ) {
            Icon(Icons.Outlined.KeyboardArrowLeft, null)

        }
        TextButton(
            onClick = { },
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Text("Skip", color = MaterialTheme.colors.onBackground)
        }
    }
}

@Preview
@Composable
fun pre() {
    PantallaLogin()
}