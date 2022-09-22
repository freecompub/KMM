package fr.acs.kmm

import kotlinx.serialization.Serializable

@Serializable
data class LogData(
    val message: String,
    val timestamp: String,
    val severity: Level,
    val correlationId: String = Constants.defaultCorrelationId,
    val featureId: String = Constants.defaultFeatureId,
    val featureName: String = Constants.defaultFeatureName,
    val machineName: String = Constants.defaultMachineName,
    val threadName: String?,
    val requestId: String?,
    val applicativeCode: String?,
    val errorCode: String?,
    val stacktrace: String?,
    val file: String?,
    val function: String?,
    val line: UInt?
)
