import com.arkivanov.decompose.value.MutableValue
import com.oilpay.mobile.core.content.ComponentContent
import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.presentation.ui.biometry.BiometryScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class DefaultBiometryComponent(
    componentContext: AppComponentContext,
    private val onConfirmationRequest: () -> Unit,
    private  val onNavigateToIdentify: () -> Unit
) : BiometryComponent, AppComponentContext by componentContext {
    override val content: ComponentContent = BiometryScreen(this)


    private val _biometryType = MutableStateFlow(BiometryType.FACEID)
    private val _isAlertActive = MutableValue(false)

    override val biometryType: StateFlow<BiometryType> get() = _biometryType.asStateFlow()
    override val isAlertActive: Boolean get() = _isAlertActive.value
    override fun onBiometryToggle() {
        if (_biometryType.value == BiometryType.TOUCHID) {
            onConfirmationRequest()
        } else {
            _biometryType.value = BiometryType.TOUCHID
        }
    }

    override fun onAlertDismiss() {
        _isAlertActive.value = false
    }
    override fun onNavToIden(){
        onNavigateToIdentify()
    }

    override fun onConfirmationRequested() {
        _isAlertActive.value = false
        onConfirmationRequest()
    }
}
