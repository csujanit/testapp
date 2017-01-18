import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import akka.http.scaladsl.server.Directives._

import scala.concurrent.{ExecutionContext, ExecutionContextExecutor}


/**
  * Created by crramya on 18/01/17.
  */




object TestApp extends  App{
  {
    implicit  val system = ActorSystem()
    implicit  val materializer  = ActorMaterializer()
    implicit  val executionContext = system.dispatcher
    val route = {
      path("test"){
        complete("OK")
      }
    }
    Http().bindAndHandle(route,"0.0.0.0",8080)
  }
}
