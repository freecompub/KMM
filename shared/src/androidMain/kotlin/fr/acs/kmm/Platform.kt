package fr.acs.kmm

actual class Platform actual constructor() {
    actual val platform: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual interface Repository {
    actual fun log(log: Log)
    actual fun export(): List<Log>
    actual fun set(url: String)
    actual fun reset()
    actual fun clean(days: Int)
}