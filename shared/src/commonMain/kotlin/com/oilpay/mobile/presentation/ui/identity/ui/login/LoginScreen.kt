package com.oilpay.mobile.presentation.ui.identity.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.presentation.ui.identity.component.login.LoginAction
import com.oilpay.mobile.presentation.ui.identity.component.login.DefaultLoginComponent
import com.oilpay.mobile.compose.resources.Res
import com.oilpay.mobile.compose.resources.and
import com.oilpay.mobile.compose.resources.enter_your_phone
import com.oilpay.mobile.compose.resources.entrance
import com.oilpay.mobile.compose.resources.`for`
import com.oilpay.mobile.compose.resources.on_here_number_send_code
import com.oilpay.mobile.compose.resources.placeholder_phone
import com.oilpay.mobile.compose.resources.registration
import com.oilpay.mobile.core.content.ComponentContent
import com.oilpay.mobile.presentation.components.theme.CustomSpacer
import com.oilpay.mobile.presentation.components.theme.WeightSpacer
import com.oilpay.mobile.presentation.components.layout_helpers.CenteredColumn
import com.oilpay.mobile.presentation.components.input.textfield.PhoneField
import com.oilpay.mobile.presentation.components.text.TwoColorText
import com.oilpay.mobile.presentation.components.theme.OilPayTheme
import com.oilpay.mobile.presentation.ui.identity.ui.auth.BottomContent
import org.jetbrains.compose.resources.stringResource

internal class LoginScreen(
    private val component: DefaultLoginComponent
) : ComponentContent {

    @Composable
    override fun Content(modifier: Modifier) {
        val state by component.store.container.stateFlow.collectAsState()
        val error by component.store.error.collectAsState(null)

        CenteredColumn(
            modifier = Modifier
                .background(OilPayTheme.colors.background)
                .padding(horizontal = 20.dp)
                .navigationBarsPadding()
                .padding(bottom = 20.dp)
                .imePadding()

        ) {
            WeightSpacer()

            TwoColorText(
                defaultText = stringResource(Res.string.`for`),
                accentText = stringResource(Res.string.entrance)
            )
            TwoColorText(
                defaultText = stringResource(Res.string.and),
                accentText = stringResource(Res.string.registration)
            )

            CustomSpacer(25.dp)
            Text(
                text = stringResource(Res.string.enter_your_phone),
                style = OilPayTheme.typography.smallTitle
            )
            CustomSpacer(12.dp)

            PhoneField(
                phone = state.phone,
                mask = stringResource(Res.string.placeholder_phone),
                maskNumber = '0',
                onPhoneChanged = { phone -> component.dispatchAction(LoginAction.InputPhone(phone)) }
            )
            CustomSpacer(8.dp)
            Text(
                text = stringResource(Res.string.on_here_number_send_code),
                style = OilPayTheme.typography.smallLabel
            )
            WeightSpacer()

            BottomContent(
                isNotEmpty = state.phone.isNotEmpty(),
                checked = state.checked,
                onChangeChecked = { component.dispatchAction(LoginAction.ClickCheckbox(it)) },
                onClick = { component.dispatchAction(LoginAction.ClickLogin) }
            )
        }
    }

}