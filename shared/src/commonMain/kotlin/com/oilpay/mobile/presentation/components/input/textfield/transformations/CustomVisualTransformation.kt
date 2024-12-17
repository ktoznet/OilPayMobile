package com.oilpay.mobile.presentation.components.input.textfield.transformations

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation


const val MASK_CHAR = '0'
const val CARD_VISUAL_MASK = "0000  0000  0000  0000"
const val PHONE_VISUAL_MASK = "+998 000 00 00 00"
const val CARD_DATE_VISUAL_MASK = "00/00"


const val AUTO_NUMBER_TRANSFORM_MASK = "00А000АА"

class MaskVisualTransformation(
    private val mask: String,
) : VisualTransformation {
    private val maxLength = mask.count { it == MASK_CHAR }

    override fun filter(text: AnnotatedString): TransformedText {
        val trimmed = if (text.length > maxLength) text.take(maxLength) else text

        val annotatedString = buildAnnotatedString {
            if (trimmed.isEmpty()) return@buildAnnotatedString

            var maskIndex = 0
            var textIndex = 0
            while (textIndex < trimmed.length && maskIndex < mask.length) {
                if (mask[maskIndex] != MASK_CHAR) {
                    val nextDigitIndex = mask.indexOf(MASK_CHAR, maskIndex)
                    append(mask.substring(maskIndex, nextDigitIndex))
                    maskIndex = nextDigitIndex
                }
                append(trimmed[textIndex++])
                maskIndex++
            }
        }

        return TransformedText(
            annotatedString,
            DigitOffsetTranslator(mask)
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MaskVisualTransformation) return false
        if (mask != other.mask) return false
        return true
    }

    override fun hashCode(): Int {
        return mask.hashCode()
    }
}


class DigitOffsetTranslator(private val mask: String): OffsetMapping {
    override fun originalToTransformed(offset: Int): Int {
        var noneDigitCount = 0
        var i = 0
        while (i < offset + noneDigitCount) {
            if (mask[i++] != MASK_CHAR) noneDigitCount++
        }
        return offset + noneDigitCount
    }

    override fun transformedToOriginal(offset: Int): Int =
        offset - mask.take(offset).count { it != MASK_CHAR }
}
