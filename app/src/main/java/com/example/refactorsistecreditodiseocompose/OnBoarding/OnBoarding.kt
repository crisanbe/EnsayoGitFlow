package com.example.refactorsistecreditodiseocompose.OnBoarding

import android.widget.Toast
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun onBoarding(
    PantallaLogin: () -> Unit
) {

    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    Column(
        Modifier
            .fillMaxSize()
    ) {
        //TopSection()
        var texValue by remember { mutableStateOf("") }
        val items = OnBoardingItem.get()
        val state = rememberPagerState(pageCount = 3)

        HorizontalPager(
            state = state,
            /*modifier = Modifier
                .fillMaxSize()
                .weight(0.9f)*/
        )
        { page ->
            OnBoardingItem(items[page])
        }

        Spacer(modifier = Modifier.padding(top = 30.dp))

        BottonSection(size = items.size, index = state.currentPage) {
            if (state.currentPage + 1 < items.size)
                scope.launch {
                    state.scrollToPage(state.currentPage + 1)
                }

        }

        BottonSectionAtras(size = items.size, index = state.currentPage) {
            if (state.currentPage - 1 < items.size)
                scope.launch {
                    state.scrollToPage(state.currentPage - 1)
                }

        }

        Box(
        ) {
                if (state.currentPage == 2) {//pagina == a la posicion 2
                    Button(
                        modifier = Modifier
                            .offset(x = 205.dp, y = (-21).dp),
                        onClick = {
                            PantallaLogin()
                            Toast.makeText(context, "Start Login", Toast.LENGTH_SHORT).show()
                        },
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            text = "Empezar",
                            modifier = Modifier.padding(
                                vertical = 15.dp,
                                horizontal = 43.dp
                            )
                        )
                    }

                } else if (state.currentPage == 0) {
                    Button(
                        modifier = Modifier
                            .offset(x = 20.dp, y = (-60).dp),
                        onClick = { PantallaLogin() },
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.textButtonColors(
                            backgroundColor = Color.White
                        )
                    ) {
                        Text(
                            text = "Omitir",
                            modifier = Modifier
                                .padding(
                                    vertical = 15.dp,
                                    horizontal = 45.dp
                                )
                                .clickable {
                                    PantallaLogin()
                                    Toast
                                        .makeText(
                                            context,
                                            "Start Inicio Sesión",
                                            Toast.LENGTH_SHORT
                                        )
                                        .show()
                                },
                            color = MaterialTheme.colors.background,
                        )
                    }
                }
            }

    }
}

@Preview
@Composable
fun TopSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {

        IconButton(
            onClick = { },
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Icon(Icons.Outlined.KeyboardArrowLeft, null)

        }
        TextButton(
            onClick = { },
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Text("Skip", color = MaterialTheme.colors.onBackground)
        }
    }

}


@Composable
fun BottonSection(
    size: Int,
    index: Int,
    onNextClicked: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(bottom = 20.dp, start = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = if (index != 2) {
                Arrangement.SpaceBetween
            } else {
                Arrangement.Center
            }
        ) {
            if (index == 0) {//pagina == a la posicion 2

                Button(
                    modifier = Modifier
                        .offset(x = 0.dp, y = 130.dp)
                        .padding(bottom = 40.dp, start = 170.dp),
                    onClick = onNextClicked,
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "Siguiente",
                        modifier = Modifier.padding(
                            vertical = 15.dp,
                            horizontal = 40.dp
                        )
                    )
                }
            } else if (index == 1)
                Button(
                    modifier = Modifier
                        .offset(x = 170.dp, y = 130.dp)
                        .padding(bottom = 20.dp),
                    onClick = onNextClicked,
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "Siguiente",
                        modifier = Modifier
                            .padding(
                                vertical = 15.dp,
                                horizontal = 40.dp
                            )
                            .clickable {
                                onNextClicked
                                //onBoardViewModel.setCurrentPage(pagerState.currentPage + 1)
                            }
                    )
                }
        }

        //Indicators
        Indicators(size = size, index = index)
    }
}


@Composable
fun BottonSectionAtras(
    size: Int,
    index: Int,
    onNextClickedAtras: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(15.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(bottom = 20.dp, start = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = if (index != 2) {
                Arrangement.SpaceBetween
            } else {
                Arrangement.Center
            }
        ) {
            if (index == 1) {//pagina == a la posicion 1
                Button(
                    modifier = Modifier
                        .offset(x = (-15).dp, y = (-5).dp),
                    onClick = onNextClickedAtras,
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = Color.White
                    )
                ) {
                    Text(
                        text = "Atras",
                        modifier = Modifier
                            .padding(
                                vertical = 15.dp,
                                horizontal = 49.dp
                            )
                            .clickable {

                                //onBoardViewModel.setCurrentPage(pagerState.currentPage - 1)
                            },
                        color = MaterialTheme.colors.background,
                    )
                }
            } else if (index == 2) {//pagina == a la posicion 1
                Button(
                    modifier = Modifier
                        .offset(x = (-110).dp, y = 81.5.dp),
                    onClick = onNextClickedAtras,
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = Color.White
                    )
                ) {
                    Text(
                        text = "Atras",
                        modifier = Modifier
                            .padding(
                                vertical = 15.dp,
                                horizontal = 49.dp
                            )
                            .clickable {
                                onNextClickedAtras
                                //onBoardViewModel.setCurrentPage(pagerState.currentPage - 1)
                            },
                        color = MaterialTheme.colors.background,
                    )
                }

            }

        }

    }
}


@Composable
fun Indicators(size: Int, index: Int) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(start = 160.dp, top = 0.dp)
    ) {
        repeat(size) {
            Indicator(isSelectec = it == index)
        }
    }
}


@Composable
fun Indicator(isSelectec: Boolean) {
    val width = animateDpAsState(
        targetValue = if (isSelectec) 25.dp else 10.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
    )

    Box(
        modifier = Modifier
            .padding(2.dp)
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelectec) Color.Green
                else Color.White.copy(alpha = 0.5f)
            )
    ) {

    }
}

@Composable
fun OnBoardingItem(
    item: OnBoardingItem
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(top = 10.dp)
    )
    {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .padding(top = 20.dp),
            painter = painterResource(item.image), contentDescription = null,

            )


        Text(
            text = stringResource(item.title),
            fontSize = 24.sp,
            color = MaterialTheme.colors.onBackground,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )



        Text(
            text = stringResource(item.text),
            fontSize = 20.sp,
            color = MaterialTheme.colors.onBackground.copy(alpha = 0.8f),
            textAlign = TextAlign.Center
        )

    }
}