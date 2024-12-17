package com.oilpay.mobile.presentation.ui.main.notifications

data class NotificationElement(
    val id: Int,
    val title: String,
    val desc: String,
    val date: String, //TODO Refactor?
    val type: NotificationType,
)
