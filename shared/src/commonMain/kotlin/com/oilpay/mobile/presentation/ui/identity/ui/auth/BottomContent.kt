package com.oilpay.mobile.presentation.ui.identity.ui.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.compose.resources.Res
import com.oilpay.mobile.compose.resources.`continue`
import com.oilpay.mobile.compose.resources.i_accept
import com.oilpay.mobile.compose.resources.offer_link
import com.oilpay.mobile.compose.resources.public_offerts
import com.oilpay.mobile.presentation.components.widgets.CustomCheckbox
import com.oilpay.mobile.presentation.components.theme.CustomSpacer
import com.oilpay.mobile.presentation.components.buttons.PrimaryButton
import com.oilpay.mobile.presentation.components.text.TextLink
import com.oilpay.mobile.presentation.components.theme.OilPayTheme
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun BottomContent(
    modifier: Modifier = Modifier,
    isNotEmpty: Boolean,
    checked: Boolean,
    onChangeChecked: (Boolean) -> Unit,
    onClick: () -> Unit
) {
    val uriHandler = LocalUriHandler.current // TODO check work on IOS
    val uri = stringResource(Res.string.offer_link) // TODO replace link
    Column(
        modifier = modifier
    ) {
        CustomCheckbox(
            checked = checked,
            onCheckedChange = { onChangeChecked.invoke(!it) }
        ) {
            Text(
                text = stringResource(Res.string.i_accept),
                style = OilPayTheme.typography.smallLabel,
                color = OilPayTheme.colors.onBackground,
            )
            TextLink(
                text = stringResource(Res.string.public_offerts),
                fontWeight = 400,
                textDecoration = TextDecoration.Underline
            ) {
                uriHandler.openUri(uri)
            }
        }
        CustomSpacer(15.dp)
        PrimaryButton(
            text = stringResource(Res.string.`continue`),
            isEnabled = (checked && isNotEmpty)
        ) {
            onClick.invoke()
        }
    }
}