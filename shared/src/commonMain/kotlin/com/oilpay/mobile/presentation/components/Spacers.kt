package com.oilpay.mobile.presentation.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
@NonRestartableComposable
fun ColumnScope.CustomSpacer(height: Dp) = Spacer(Modifier.height(height))

@Composable
@NonRestartableComposable
fun RowScope.CustomSpacer(width: Dp) = Spacer(Modifier.width(width))

@Composable
@NonRestartableComposable
fun ColumnScope.WeightSpacer(weight: Float = 1f) = Spacer(Modifier.weight(weight))

@Composable
@NonRestartableComposable
fun RowScope.WeightSpacer(weight: Float = 1f) = Spacer(Modifier.weight(weight))