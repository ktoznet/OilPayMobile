@file:OptIn(ExperimentalMaterial3Api::class)

package com.oilpay.mobile.presentation.ui.confirmation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.oilpay.mobile.presentation.components.input.textfield.CustomTF
import com.oilpay.mobile.presentation.components.input.textfield.TextFieldType



@Composable
internal fun DatePickerDocked(
    value: String,
    onValueChange: (String) -> Unit,
    onCalendarClick: () -> Unit,
    datePicker: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        CustomTF(
            type = TextFieldType.DATE,
            label = "Дата рождения",
            placeholder = "ДД.ММ.ГГГГ.",
            value = value,
            onValueChange = onValueChange,
            onTrailingIconClick = onCalendarClick
        )
        datePicker()
    }
}


//class MaskVisualTransformation(private val mask: String) : VisualTransformation {
//    private val specialSymbolsIndices = mask.indices.filter { mask[it] != '#' }
//
//    override fun filter(text: AnnotatedString): TransformedText {
//        var out = ""
//        var maskIndex = 0
//        text.forEach { char ->
//            while (specialSymbolsIndices.contains(maskIndex)) {
//                out += mask[maskIndex]
//                maskIndex++
//            }
//            out += char
//            maskIndex++
//        }
//        return TransformedText(AnnotatedString(out), offsetTranslator())
//    }
//
//    private fun offsetTranslator() = object : OffsetMapping {
//        override fun originalToTransformed(offset: Int): Int {
//            val offsetValue = offset.absoluteValue
//            if (offsetValue == 0) return 0
//            var numberOfHashtags = 0
//            val masked = mask.takeWhile {
//                if (it == '#') numberOfHashtags++
//                numberOfHashtags < offsetValue
//            }
//            return masked.length + 1
//        }
//
//        override fun transformedToOriginal(offset: Int): Int {
//            return mask.take(offset.absoluteValue).count { it == '#' }
//        }
//    }
//}