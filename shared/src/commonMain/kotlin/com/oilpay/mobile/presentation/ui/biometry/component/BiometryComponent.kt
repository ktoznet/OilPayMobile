import com.oilpay.mobile.core.content.ComponentContentOwner
import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent
import kotlinx.coroutines.flow.StateFlow

interface BiometryComponent: DecomposeComponent, ComponentContentOwner
{
    val biometryType: StateFlow<BiometryType>
    val isAlertActive: Boolean

    fun onBiometryToggle()
    fun onAlertDismiss()
    fun onConfirmationRequested()
    fun onNavToIden()

    fun interface Factory {
        fun create(context: AppComponentContext): BiometryComponent
    }
}
enum class BiometryType {
    FACEID,
    TOUCHID
}