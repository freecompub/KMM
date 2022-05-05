package fr.acs.kmm

expect class Platform() {
    val platform: String
}

expect interface Repository {
    fun log(log: Log)
    fun export(): List<Log>
    fun set(url: String)
    fun reset()
    fun clean(days: Int)
}