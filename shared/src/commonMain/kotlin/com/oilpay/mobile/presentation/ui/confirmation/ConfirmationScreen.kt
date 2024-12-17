package com.oilpay.mobile.presentation.ui.confirmation

import ConfirmationComponent
import DefaultConfirmationComponent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.core.content.ComponentContent
import com.oilpay.mobile.presentation.components.buttons.OutlinedPrimaryButton
import com.oilpay.mobile.presentation.components.buttons.PrimaryButton
import com.oilpay.mobile.presentation.components.input.textfield.CustomTF
import com.oilpay.mobile.presentation.components.input.textfield.TextFieldType
import com.oilpay.mobile.presentation.components.layout_helpers.CenteredColumn
import com.oilpay.mobile.presentation.components.text.TwoColorText
import com.oilpay.mobile.presentation.components.theme.CustomSpacer
import com.oilpay.mobile.presentation.components.theme.OilPayTheme
import com.oilpay.mobile.presentation.components.theme.WeightSpacer


class ConfirmationScreen(
    private val component: DefaultConfirmationComponent
): ComponentContent {

    @Composable
    override fun Content(modifier: Modifier) {
       // val state by component

        ConfirmationContent(component)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmationContent(component: ConfirmationComponent) {
    CenteredColumn(
        vertical = Arrangement.Top,
        modifier = Modifier
            .background(OilPayTheme.colors.background)
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(20.dp)
    ) {
        CustomSpacer(120.dp)
        TwoColorText("подтвердите свою", "личность")
        CustomSpacer(25.dp)
        CustomTF(
            type = TextFieldType.PASSPORT,
            placeholder = "АА9999999",
            label = "Серия и номер паспорта или ПИНФЛ",
            value = component.passportValue,
            onValueChange = component::onPassportChange
        )
        CustomSpacer(20.dp)
        val mainColor = OilPayTheme.colors.onBackground
        DatePickerDocked(
            value = component.birthDateValue,
            onValueChange = component::onBirthDateChange,
            onCalendarClick = component::onCalendarClick
        ) {
            if (component.showDatePicker) {
                BasicAlertDialog(
                    onDismissRequest = { component.onDateSelected(0L)}
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(OilPayTheme.colors.backgroundContainer)
                            .padding(16.dp),
                    ) {
                        val datePickerState = rememberDatePickerState()

                        DatePicker(
                            state = datePickerState,
                            showModeToggle = false,
                            colors = DatePickerDefaults.colors(
                                containerColor = OilPayTheme.colors.backgroundContainer,
                            titleContentColor = mainColor,
                        headlineContentColor = mainColor,
                        weekdayContentColor = mainColor,
                        subheadContentColor = mainColor,
                        navigationContentColor = mainColor,
                        yearContentColor = mainColor,
                        disabledYearContentColor = mainColor,
                        currentYearContentColor = mainColor,
                        selectedYearContentColor = mainColor,
                        disabledSelectedYearContentColor = mainColor,
                        selectedYearContainerColor = mainColor,
                        disabledSelectedYearContainerColor = mainColor,
                        dayContentColor = mainColor,
                        disabledDayContentColor = mainColor,
                        selectedDayContentColor = mainColor,
                        disabledSelectedDayContentColor = mainColor,
                        selectedDayContainerColor = mainColor,
                        disabledSelectedDayContainerColor = mainColor,
                        todayContentColor = mainColor,
                        todayDateBorderColor = mainColor,
                        dayInSelectionRangeContentColor = mainColor,
                        dayInSelectionRangeContainerColor = mainColor,
                        dividerColor = mainColor,

                            )
                        )
                    }
                }
            }

        }

        WeightSpacer()
        PrimaryButton(
            "Продолжить"
        ) { component.onConfirm() }

        CustomSpacer(8.dp)
        OutlinedPrimaryButton("Позже") {
            component.onCancel()
        }
    }
}