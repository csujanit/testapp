import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import akka.event.Logging
import scala.util.Properties


/**
  * Created by crramya on 18/01/17. 139805
  */

object TestApp extends  App{
  {
    implicit  val system = ActorSystem()
    implicit  val materializer  = ActorMaterializer()
    implicit  val executionContext = system.dispatcher
    val port = Properties.envOrElse("PORT", "8080").toInt
    val logger = Logging(system,getClass)
    val route = {
      {
       (get&path("/test")){
      {        
        complete("OK")          
      }        
      }
      }
    }
    Http().bindAndHandle(route,interface="0.0.0.0",port = port)
  }
}