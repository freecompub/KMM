package fr.acs.kmm

import fr.acs.kmm.OSIAWebService.Reachability
import fr.acs.kmm.OSIAWebService.Scheduler
import fr.acs.kmm.OSIAWebService.WebService
import kotlinx.datetime.Clock

class LoggerConfiguration(var featureId: String? = null,
                          var featureName: String? = null,
                          var correlationId: String? = null,
                          var machineName: String? = null,
                          var applicativeCode: String? = null,
                          var verbose:Boolean = false,
                          var cleanPeriod: Int = 30,
                          var maxLogs:Int = 3000,
                          var logLevel: Level = Level.Info)



 object Logger {
    private val loggerConfiguration = LoggerConfiguration()
    /// `featureId` is a global var to handle featureId in the logs (it can be overriden
    /// here or in the log call see `Logger.log` method)
    public var featureId: String?
    get() { return loggerConfiguration.featureId}
    set(value) {loggerConfiguration.featureId = value}

    /// `featureName` is a global var to handle featureName in the logs (it can be overriden
    /// here or in the log call see `Logger.log` method)
      var featureName: String?
       get() { return loggerConfiguration.featureName}
        set(value) {loggerConfiguration.featureName = value}

    /// `correlationId` is a global var to handle correlationId in the logs (it can be overriden
    /// here or in the log call see `Logger.log` method)
     var correlationId: String?
       get() { return loggerConfiguration.correlationId}
        set(value) {loggerConfiguration.correlationId = value}

    /// `machineName` is a global var to handle machineName in the logs
     var machineName: String?
       get() { return loggerConfiguration.machineName}
        set(value) {loggerConfiguration.machineName = value}

    /// `applicativeCode` is a global var to handle applicativeCode in the logs
     var applicativeCode: String?
       get() { return loggerConfiguration.applicativeCode}
        set(value) {loggerConfiguration.applicativeCode = value}

    /// `verbose` is a global var to print logs from SQLite
     var verbose:Boolean
       get() { return loggerConfiguration.verbose}
        set(value) {loggerConfiguration.verbose = value}

    /// `cleanPeriod` is a global var to clean all logs that are more than cleanPeriod (by default : 30)
     var cleanPeriod:Int
       get() { return loggerConfiguration.cleanPeriod}
        set(value) {loggerConfiguration.cleanPeriod = value}

    /// `maxLogs` is a global var to for the maximumLogs for the DB
     var maxLogs: Int
       get() { return loggerConfiguration.maxLogs}
        set(value) {loggerConfiguration.maxLogs = value}

    /// `logLevel` is a global var to for the highest level sent to webservice
     var logLevel: Level
   get() { return loggerConfiguration.logLevel}
    set(value) {loggerConfiguration.logLevel = value}


     private var repository: Repository? = null
     private var webservice: WebService? = null
     private var reachability: Reachability? = null
     private var scheduler: Scheduler? = null


      fun info(message: String,
     featureId: String? = null,
     featureName: String? = null,
     correlationId: String? = null,
     file: String? = null,
     function: String? = null,
     line: UInt? = null
     ) {
         /*log(level: .info,
         message(),
         errorCode: nil,
         featureId: featureId,
         featureName: featureName,
         correlationId: correlationId,
         file: file,
         function: function,
         line: line)*/
     }

     fun debug(message: String,
              featureId: String? = null,
              featureName: String? = null,
              correlationId: String? = null,
              file: String? = null,
              function: String? = null,
              line: UInt? = null
     ) {
         /*log(level: .info,
         message(),
         errorCode: nil,
         featureId: featureId,
         featureName: featureName,
         correlationId: correlationId,
         file: file,
         function: function,
         line: line)*/
     }


     fun warning(message: String,
               featureId: String? = null,
               featureName: String? = null,
               correlationId: String? = null,
               file: String? = null,
               function: String? = null,
               line: UInt? = null
     ) {
         val logData = LogData(message = message,
             timestamp = Clock.System.now().toString(),
             severity = Level.Warning,
             correlationId = correlationId ?: Constants.defaultCorrelationId,
             featureId = featureId ?: Constants.defaultFeatureId,
             featureName = featureName ?: Constants.defaultFeatureName, machineName = Logger.machineName)
         /*log(level: .info,
         message(),
         errorCode: nil,
         featureId: featureId,
         featureName: featureName,
         correlationId: correlationId,
         file: file,
         function: function,
         line: line)*/
     }


     fun error(message: String,
                 featureId: String? = null,
                 featureName: String? = null,
                 correlationId: String? = null,
                 file: String? = null,
                 function: String? = null,
                 line: UInt? = null
     ) {
         /*log(level: .info,
         message(),
         errorCode: nil,
         featureId: featureId,
         featureName: featureName,
         correlationId: correlationId,
         file: file,
         function: function,
         line: line)*/
     }


     fun reset() {
         //TODO Samir
     }

     fun export() {
         //TODO Samir
     }

 }

public enum class Level(val value:Int){
    Debug(3),
    Info(2),
    Warning(1),
    Error(0),
}


public enum class Error {
     NotInitialised,
     RepoNotDefined
}

public enum class ErrorCode {
    /// Used in case no code is needed.
     NoCode,
    /// Used in case a code should be sent (code has to be a string).
    Code//(String)
}