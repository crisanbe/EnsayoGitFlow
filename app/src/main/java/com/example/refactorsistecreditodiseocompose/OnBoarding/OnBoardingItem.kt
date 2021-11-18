package com.example.refactorsistecreditodiseocompose.OnBoarding

import com.example.refactorsistecreditodiseocompose.R


class OnBoardingItem(
    val title:Int,
    val text:Int,
    val image:Int,
) {

    companion object{

        fun get(): List<OnBoardingItem>{
            return listOf(
                OnBoardingItem(R.string.onBoardingTitle1,R.string.onBoardingText1,R.drawable.solicitadtucupo1),
                OnBoardingItem(R.string.onBoardingTitle2,R.string.onBoardingText2,R.drawable.gestionatuscreditos2),
                OnBoardingItem(R.string.onBoardingTitle3,R.string.onBoardingText3,R.drawable.comprainteres3),
            )
        }
    }
}