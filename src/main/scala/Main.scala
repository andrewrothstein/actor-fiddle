import akka.actor.ActorSystem
import akka.actor.Props

object Main extends App { 
  val system = ActorSystem("MySystem")
  val testActor = system.actorOf(Props[TestActor], name = "testActor")
}
