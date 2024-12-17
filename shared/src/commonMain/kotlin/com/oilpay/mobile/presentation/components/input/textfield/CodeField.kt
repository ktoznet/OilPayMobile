package com.oilpay.mobile.presentation.components.input.textfield

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oilpay.mobile.compose.resources.Res
import com.oilpay.mobile.compose.resources.incorrect_code
import com.oilpay.mobile.presentation.components.theme.CustomSpacer
import com.oilpay.mobile.presentation.components.theme.OilPayTheme
import org.jetbrains.compose.resources.stringResource

private val box_size = 50.dp
private val space_between_box = 17.dp

@Composable
fun CodeField(
    value: String,
    length: Int,
    status: CodeStatus,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    keyboardActions: KeyboardActions = KeyboardActions(),
    onValueChange: (String) -> Unit,
) {
    val color = when (status) {
        CodeStatus.Default -> OilPayTheme.colors.text
        CodeStatus.Error -> Color.Red
        CodeStatus.Correct -> OilPayTheme.colors.primary
    }
    val animatedColor by animateColorAsState(color)
    BasicTextField(modifier = modifier,
        value = value,
        singleLine = true,
        onValueChange = {
            val digit = it.filter { char ->
                char.isDigit()
            }
            if (digit.length <= length) {
                onValueChange(digit)
            }
        },
        enabled = enabled,

        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        decorationBox = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    Modifier.size(
                        width = (box_size + space_between_box) * length,
                        height = box_size
                    ),
                    horizontalArrangement = Arrangement.spacedBy(space_between_box),
                ) {
                    repeat(length) { index ->
                        Box(
                            modifier = Modifier
                                .size(box_size)
                                .border(
                                    1.dp,
                                    color = animatedColor,
                                    shape = RoundedCornerShape(4.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = value.getOrNull(index)?.toString() ?: "",
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.labelLarge,
                                color = if (status == CodeStatus.Default) Color.White else animatedColor
                            )
                        }
                    }
                }
                AnimatedVisibility(status == CodeStatus.Error) {
                    CustomSpacer(25.dp)
                    Text(
                        text = stringResource(Res.string.incorrect_code),
                        fontSize = 12.sp,
                        color = Color.Red
                    )
                }
            }
        })
}

enum class CodeStatus {
    Default,
    Error,
    Correct
}