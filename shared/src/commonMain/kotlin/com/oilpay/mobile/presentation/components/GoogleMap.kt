package com.oilpay.mobile.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.oilpay.mobile.domain.entities.CameraMoveState
import com.oilpay.mobile.domain.entities.ZoomLevelState
import com.oilpay.mobile.core.configuration.DefaultMapProperties
import com.oilpay.mobile.core.configuration.DefaultMapUiSettings
import com.oilpay.mobile.core.configuration.MapProperties
import com.oilpay.mobile.core.configuration.MapUiSettings
import com.oilpay.mobile.core.updater.MapUpdater
import com.oilpay.mobile.core.utils.map.CameraPosition
import com.oilpay.mobile.core.utils.map.Projection
import com.oilpay.mobile.core.ext.GoogleMap

@Composable
expect fun GoogleMap(
    cameraPositionProvider: () -> CameraPosition,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Unspecified,
    contentPadding: PaddingValues = PaddingValues(),
    mapProperties: MapProperties = DefaultMapProperties,
    mapUiSettings: MapUiSettings = DefaultMapUiSettings,
    onMapLoad: (GoogleMap) -> Unit = {},
    onMapUpdaterChange: (MapUpdater?) -> Unit = {},
    onProjectionChange: (Projection) -> Unit = {},
    onZoomChange: (ZoomLevelState) -> Unit = {},
    cameraMoveStateChange: (CameraMoveState) -> Unit = {}
)