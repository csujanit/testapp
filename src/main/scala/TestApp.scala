import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import akka.event.Logging
import scala.util.Properties
import com.typesafe.config.ConfigFactory

/**
  * Created by crramya on 18/01/17. 139805
  */

object TestApp extends  App{
  {
    implicit  val system = ActorSystem()
    implicit  val materializer  = ActorMaterializer()
    implicit  val executionContext = system.dispatcher
  val config = ConfigFactory.load()

  val port = if (config.getIsNull("http.port")) {
    8080
  } else {
    config.getInt("http.port")
  }
    val logger = Logging(system,getClass)
    val route = {       
      path("test"){
        get{       
        complete("OK")          
                              
        } 
      }
    }
    Http().bindAndHandle(route,interface="0.0.0.0",port = port)
  }
}