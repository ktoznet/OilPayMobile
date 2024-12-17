import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO


object AppDispatchers {
    val io = Dispatchers.IO
    val default = Dispatchers.Default
    val main = Dispatchers.Main
    val Unconfined = Dispatchers.Unconfined
}
