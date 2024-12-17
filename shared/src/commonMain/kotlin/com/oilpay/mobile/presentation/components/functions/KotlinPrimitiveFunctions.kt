package com.oilpay.mobile.presentation.components.functions

import com.oilpay.mobile.presentation.components.input.textfield.transformations.MASK_CHAR

inline fun String.filterDigit(
    predicate: (Int, Char) -> Boolean = { _, c -> c.isDigit() }
) = this.filterIndexed(predicate = predicate)

inline fun String.maxChars(count: Int, function: (String) -> Unit) {
    if (this.length <= count) function.invoke(this)
}

inline fun String.addSpace(chunk: Int, function: (String) -> Unit) = function(
    this.chunked(chunk).joinToString(separator = " ")
)

inline fun String.maxCharsWithSpace(count: Int, chunk: Int, function: (String) -> Unit) {
    this.maxChars(count) { c ->
        c.addSpace(chunk) {
            function.invoke(it)
        }
    }
}


fun String.takeOnlyMask(mask: String) =
    this.take(mask.count { it == MASK_CHAR })