import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent

interface AntiRadarComponent: DecomposeComponent {
    fun onBack()

    fun interface Factory {
        fun create(
            context: AppComponentContext,
            onBack: () -> Unit
        ): AntiRadarComponent
    }
}
