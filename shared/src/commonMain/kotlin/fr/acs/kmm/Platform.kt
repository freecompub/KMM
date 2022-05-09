package fr.acs.kmm

expect class Platform() {
    val platform: String
}

expect interface Repository {
    fun log(log: LogData)
    fun export(): List<LogData>
    fun set(url: String)
    fun reset()
    fun clean(days: Int)
}