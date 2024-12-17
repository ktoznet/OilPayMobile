package com.oilpay.mobile.presentation.ui.onBoarding.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oilpay.mobile.compose.resources.Res
import com.oilpay.mobile.compose.resources.built_in_map
import com.oilpay.mobile.compose.resources.cashback_oil
import com.oilpay.mobile.compose.resources.fifth_boarding
import com.oilpay.mobile.compose.resources.first_boarding
import com.oilpay.mobile.compose.resources.fourth_boarding
import com.oilpay.mobile.compose.resources.gas_station_network
import com.oilpay.mobile.compose.resources.info_free_card
import com.oilpay.mobile.compose.resources.order
import com.oilpay.mobile.compose.resources.partners_ship
import com.oilpay.mobile.compose.resources.second_boarding
import com.oilpay.mobile.compose.resources.third_boarding
import com.oilpay.mobile.presentation.ui.onBoarding.component.OnBoardingAction
import com.oilpay.mobile.presentation.ui.onBoarding.component.DefaultOnBoardingComponent
import com.oilpay.mobile.presentation.ui.onBoarding.component.OnBoardingState
import com.oilpay.mobile.presentation.ui.onBoarding.ui.composable.OnBoardingTopBar
import com.oilpay.mobile.core.content.ComponentContent
import com.oilpay.mobile.presentation.components.theme.CustomSpacer
import com.oilpay.mobile.presentation.components.theme.WeightSpacer
import com.oilpay.mobile.presentation.components.buttons.PrimaryButton
import com.oilpay.mobile.presentation.components.layout_helpers.TrapezoidRow
import com.oilpay.mobile.presentation.components.pager.PagerIndicators
import com.oilpay.mobile.presentation.components.text.TwoColorText
import com.oilpay.mobile.presentation.components.theme.OilPayTheme
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.stringArrayResource
import org.jetbrains.compose.resources.stringResource

internal class OnBoardingScreen(
    private val component: DefaultOnBoardingComponent
): ComponentContent {

    companion object {
        private const val PAGE_COUNT = 5
        private val textSizeBoarding = 24.sp
    }

    @Composable
    override fun Content(modifier: Modifier) {
        val state by component.store.container.stateFlow.collectAsState()

        OnBoardingView(
            state = state
        )
    }

    @Composable
    private fun OnBoardingView(
        state: OnBoardingState
    ) {
        val pagerState = rememberPagerState(pageCount = { PAGE_COUNT })

        LaunchedEffect(pagerState) {
            snapshotFlow { pagerState.currentPage }.collect { page ->
                component.dispatchAction(OnBoardingAction.ChangePage(page))
            }
        }

        Scaffold(
            containerColor = OilPayTheme.colors.background,
            topBar = { OnBoardingTopBar { component.dispatchAction(OnBoardingAction.Skip) } },
            bottomBar = { PagerIndicators(PAGE_COUNT, state.page, Modifier.navigationBarsPadding().padding(bottom = 20.dp)) },
        ) { padding ->
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(bottom = 25.dp)
            ) { page ->
                PagerContent(page, PAGE_COUNT)
            }
        }

    }

    @Composable
    private fun PagerContent(page: Int, countPage: Int) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TrapezoidRow { pagerTitle(page) }
            CustomSpacer(70.dp)
            Image(
                bitmap = pagerImage(page),
                contentDescription = null,
                modifier = Modifier
                    .size(350.dp)
                    .offset(x = 75.dp)
            )
            if (page == countPage - 1) {
                WeightSpacer()
                PrimaryButton(
                    text = stringResource(Res.string.order),
                    onClick = {
                        component.dispatchAction(OnBoardingAction.NavigateToAuth)
                    },
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }
        }
    }

    @Composable
    private fun pagerImage(page: Int): ImageBitmap {
        return when(page + 1) {
            1 -> imageResource(Res.drawable.first_boarding)
            2 -> imageResource(Res.drawable.second_boarding)
            3 -> imageResource(Res.drawable.third_boarding)
            4 -> imageResource(Res.drawable.fourth_boarding)
            5 -> imageResource(Res.drawable.fifth_boarding)
            else -> imageResource(Res.drawable.first_boarding)
        }
    }

    @Composable
    private fun pagerTitle(page: Int) {
        when (page + 1) {
            1 -> TwoColorText(
                stringArrayResource(Res.array.cashback_oil)[0],
                stringArrayResource(Res.array.cashback_oil)[1], isInverted = true,
                spaceBar = "  ",
                fontSize = textSizeBoarding
            )
            2 -> TwoColorText(
                stringArrayResource(Res.array.partners_ship)[0],
                stringArrayResource(Res.array.partners_ship)[1],
                fontSize = textSizeBoarding
            )
            3 -> TwoColorText(
                stringArrayResource(Res.array.built_in_map)[0],
                stringArrayResource(Res.array.built_in_map)[1],
                fontSize = textSizeBoarding
            )
            4 -> TwoColorText(
                stringArrayResource(Res.array.gas_station_network)[0],
                stringArrayResource(Res.array.gas_station_network)[1],
                fontSize = textSizeBoarding
            )
            5 -> TwoColorText(
                stringArrayResource(Res.array.info_free_card)[0],
                stringArrayResource(Res.array.info_free_card)[1], isInverted = true,
                fontSize = textSizeBoarding
            )
            else -> TwoColorText(
                stringArrayResource(Res.array.cashback_oil)[0],
                stringArrayResource(Res.array.cashback_oil)[1], isInverted = true,
                fontSize = textSizeBoarding
            )
        }
    }
}