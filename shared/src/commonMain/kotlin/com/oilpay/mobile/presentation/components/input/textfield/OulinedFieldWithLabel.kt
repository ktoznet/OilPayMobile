package com.oilpay.mobile.presentation.components.input.textfield

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.presentation.components.functions.filterDigit
import com.oilpay.mobile.presentation.components.functions.maxChars
import com.oilpay.mobile.presentation.components.functions.takeOnlyMask
import com.oilpay.mobile.presentation.components.input.textfield.transformations.CARD_DATE_VISUAL_MASK
import com.oilpay.mobile.presentation.components.input.textfield.transformations.CARD_VISUAL_MASK
import com.oilpay.mobile.presentation.components.input.textfield.transformations.MaskVisualTransformation
import com.oilpay.mobile.presentation.components.input.textfield.transformations.PHONE_VISUAL_MASK
import com.oilpay.mobile.presentation.components.theme.CustomSpacer
import com.oilpay.mobile.presentation.components.theme.OilPayTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BaseTF(
    label: String,
    placeholder: @Composable () -> Unit,
    value: String,
    onValueChange: (String) -> Unit,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    Column {
        Text(text = label, style = OilPayTheme.typography.smallTitle)
        CustomSpacer(12.dp)
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth().height(40.dp).then(modifier),
            interactionSource = interactionSource,
            visualTransformation = visualTransformation,
            textStyle = TextStyle(color = OilPayTheme.colors.onBackground),
            cursorBrush = SolidColor(OilPayTheme.colors.primary),
        ) {
            OutlinedTextFieldDefaults.DecorationBox(
                value = value,
                innerTextField = it,
                enabled = true,
                singleLine = true,
                visualTransformation = visualTransformation,
                interactionSource = interactionSource,
                trailingIcon = trailingIcon,
                leadingIcon = leadingIcon,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = OilPayTheme.colors.onBackground,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    cursorColor = OilPayTheme.colors.primary,
                    unfocusedBorderColor = OilPayTheme.colors.text,
                    focusedBorderColor = OilPayTheme.colors.primary
                ),
                placeholder = placeholder,
                contentPadding = TextFieldDefaults.contentPaddingWithoutLabel(
                    top = 0.dp,
                    bottom = 0.dp,
                ),
            )
        }
    }
}

enum class TextFieldType {
    PHONE,
    CARD,
    CARD_DATE,
    SEARCH,
    DATE,
    TEXT,
    PASSPORT,
}

@Composable
private fun PhoneTF(
    label: String,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val regionNumber = placeholder.substring(range = IntRange(0, 3))
    val estimateNumber = placeholder.substring(startIndex = 4)
    BaseTF(
        label = label,
        value = value,
        onValueChange = { onValueChange(it.takeOnlyMask(PHONE_VISUAL_MASK).filterDigit()) },
        modifier = modifier,
        placeholder = {
            Row {
                Text(regionNumber, style = OilPayTheme.typography.mediumLabel)
                Text(estimateNumber, style = OilPayTheme.typography.mediumLabel, color = OilPayTheme.colors.text)
            }
        },
        visualTransformation = MaskVisualTransformation(
            mask = PHONE_VISUAL_MASK
        ),
        leadingIcon = {
            Icon(
                Icons.Outlined.Phone,
                null,
                Modifier.padding(start = 25.dp).padding(end = 10.dp),
                tint = OilPayTheme.colors.text
            ) },

        )
}

@Composable
fun CustomTF(
    type: TextFieldType,
    label: String,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    onTrailingIconClick: () -> Unit = {},
) {
    when (type) {
        TextFieldType.PHONE -> PhoneTF(label, placeholder, value, onValueChange, modifier)
        TextFieldType.CARD -> CardTF(label, placeholder, value, onValueChange, modifier)
        TextFieldType.CARD_DATE -> CardDateTF(label, placeholder, value, onValueChange, modifier)
        TextFieldType.SEARCH -> TODO()
        TextFieldType.DATE -> DateTF(
            label,
            placeholder,
            value,
            onValueChange,
            modifier,
            onTrailingIconClick
        )

        TextFieldType.TEXT -> BaseTF(
            label,
            { Text(placeholder, style = OilPayTheme.typography.mediumLabel, color = OilPayTheme.colors.text) },
            value,
            onValueChange,
            modifier = modifier
        )

        TextFieldType.PASSPORT -> PassportTF(label, placeholder, value, onValueChange, modifier)
    }

}

@Composable
private fun PassportTF(
    label: String,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    BaseTF(
        label = label,
        placeholder = { Text(placeholder, style = OilPayTheme.typography.mediumLabel, color = OilPayTheme.colors.text) },
        value = value,
        onValueChange = { c ->
            val digit = c.filterIndexed { index, char ->
                when {
                    (index < 2) -> {
                        !char.isDigit()
                    }
                    else -> char.isDigit()
                }
            }
            digit.maxChars(9) { onValueChange(it) }
                        },
        modifier = modifier,
    )
}

@Composable
private fun CardTF(
    label: String,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    BaseTF(
        label = label,
        placeholder = { Text(placeholder, style = OilPayTheme.typography.mediumLabel, color = OilPayTheme.colors.text) },
        value = value,
        onValueChange = { onValueChange(it.takeOnlyMask(CARD_VISUAL_MASK).filterDigit()) },
        modifier = Modifier.then(modifier),
        visualTransformation = MaskVisualTransformation(
            mask = CARD_VISUAL_MASK,
        )
    )
}

@Composable
private fun CardDateTF(
    label: String,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    BaseTF(
        label = label,
        placeholder = { Text(placeholder, style = OilPayTheme.typography.mediumLabel, color = OilPayTheme.colors.text) },
        value = value,
        onValueChange = { onValueChange(it.takeOnlyMask(CARD_DATE_VISUAL_MASK).filterDigit()) },
        modifier = Modifier.then(modifier),
        visualTransformation = MaskVisualTransformation(
            mask = CARD_DATE_VISUAL_MASK,
        )
    )
}

@Composable
private fun DateTF(
    label: String,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    onTrailingIconClick: () -> Unit,
) {
    BaseTF(
        label = label,
        placeholder = { Text(placeholder, style = OilPayTheme.typography.mediumLabel, color = OilPayTheme.colors.text) },
        value = value,
        onValueChange = {
            val digit = it.filter { char ->
                char.isDigit()
            }
            if (digit.length <= 8) {
                onValueChange(digit)
            }
        },
        visualTransformation = MaskVisualTransformation("00.00.0000"),
        trailingIcon = {
            IconButton(onClick = onTrailingIconClick) {
                Icon(
                    imageVector = Icons.Outlined.CalendarMonth ,
                    contentDescription = null
                )
            }
            },
        modifier = modifier
    )
}