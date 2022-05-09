package fr.acs.kmm.bdd

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import com.squareup.sqldelight.runtime.coroutines.mapToOne
import fr.acs.kmm.Log
import fr.acs.kmm.db.AFSlogsTable
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.datetime.*
import kotlin.time.Duration.Companion.milliseconds

class DatabaseHelper(
    sqlDriver: SqlDriver,
    private val backgroundDispatcher: CoroutineDispatcher
) {
    private val bdd = AFSlogsTable(sqlDriver)

    fun selectAllLogs(): Flow<List<Log>> =
        bdd.tableQueries
            .selectAll()
            .asFlow()
            .mapToList()
            .flowOn(backgroundDispatcher)

    fun delete(uuids: List<String>) {
        uuids.forEach {
            bdd.tableQueries.deleteLog(it)
        }
    }

    fun clean(days: Int) {
        val currentTime =
            Clock.System.now().minus(days, DateTimeUnit.DAY, TimeZone.currentSystemDefault())
        bdd.tableQueries
            .selectAll().executeAsList().filter {
                currentTime.until(it.timestamp.toInstant(),DateTimeUnit.MILLISECOND,TimeZone.currentSystemDefault()) > 0
            }.map { it.id }.let {
                delete(it)
            }


    }

    fun reset(){
        bdd.tableQueries.deleteAll()
    }

    fun log( log: Log, identifier: String)
    {
        bdd.tableQueries.insertLog(message = log.message,
            timestamp = log.timestamp,
            severity = log.severity,
            correlationId = log.correlationId,
            featureId = log.featureId,
            featureName = log.featureName,
            machineName = log.machineName,
            threadName = log.threadName,
            requestId = log.requestId,
            applicativeCode = log.applicativeCode,
            errorCode = log.errorCode,
            stacktrace = log.stacktrace,
            file_ = log.file_,
            function = log.function,
            line = log.line
        )
    }
}