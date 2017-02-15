import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer


/**
  * Created by crramya on 18/01/17. 139805
  */

object TestApp extends  App{
  {
    implicit  val system = ActorSystem()
    implicit  val materializer  = ActorMaterializer()
    implicit  val executionContext = system.dispatcher
    val route = {
      path("test"){
        get{
        complete("OK")          
      }
      }
    }
    Http().bindAndHandle(route,"0.0.0.0",8080)
  }
}