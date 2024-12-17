package com.oilpay.mobile.presentation.components.input.textfield

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.presentation.components.utils.PhoneVisualTransformation
import com.oilpay.mobile.presentation.components.theme.OilPayTheme

private const val MASK_NUMBER = '0'
private const val MASK = "000 000 00 00"

@Composable
fun PhoneField(
    phone: String,
    modifier: Modifier = Modifier,
    mask: String = MASK,
    maskNumber: Char = MASK_NUMBER,
    onPhoneChanged: (String) -> Unit
) {
    OutlinedTextField(
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Phone,
                null,
                modifier = Modifier
                    .padding(start = 25.dp)
                    .padding(end = 10.dp)
            )
        },
        value = phone,
        onValueChange = { it ->
            val digit = it.filter { char ->
                char.isDigit()
            }
            onPhoneChanged(digit.take(mask.count { it == maskNumber }))
        },
        placeholder = {
            Row {
                Text("+998", color = Color.White)
                Text(
                    text = " 00 000 00 00",
                    color = OilPayTheme.colors.text
                )
            }
        },
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedTextColor = OilPayTheme.colors.onBackground,
            unfocusedTextColor = OilPayTheme.colors.onBackground,

            focusedTrailingIconColor = OilPayTheme.colors.text,
            unfocusedTrailingIconColor = OilPayTheme.colors.text,

            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,

            unfocusedIndicatorColor = OilPayTheme.colors.primary,
            focusedIndicatorColor = OilPayTheme.colors.primary,

            cursorColor = OilPayTheme.colors.primary
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        visualTransformation = PhoneVisualTransformation(mask, maskNumber),
        modifier = modifier.fillMaxWidth(),
    )
}