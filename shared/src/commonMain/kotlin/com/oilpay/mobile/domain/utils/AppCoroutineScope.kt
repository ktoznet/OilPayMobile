import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

object AppCoroutineScope {
    val ioScope = CoroutineScope(SupervisorJob() + AppDispatchers.io)// TODO("ЮЗать для данных")
    val mainScope = CoroutineScope(SupervisorJob() + AppDispatchers.main)// TODO("ЮЗать для верстки")
    val defScope = CoroutineScope(SupervisorJob() + AppDispatchers.default) // TODO("ЮЗать для вычислений")
    val UnconfinedScope = CoroutineScope(SupervisorJob() + AppDispatchers.Unconfined) // TODO("ЮЗать в крайних случаях")
}
