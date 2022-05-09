package fr.acs.kmm

import platform.UIKit.UIDevice

actual class Platform actual constructor() {
    actual val platform: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual interface Repository {
    actual fun log(log: Log)
    actual fun export(): List<Log>
    actual fun set(url: String)
    actual fun reset()
    actual fun clean(days: Int)
}