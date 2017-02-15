import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import akka.event.Logging


/**
  * Created by crramya on 18/01/17. 139805
  */

object TestApp extends  App{
  {
    implicit  val system = ActorSystem()
    implicit  val materializer  = ActorMaterializer()
    implicit  val executionContext = system.dispatcher
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
    Http().bindAndHandle(route,"0.0.0.0",8080)
  }
}