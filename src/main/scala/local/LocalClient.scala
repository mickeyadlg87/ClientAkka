package local

import akka.actor._

object Local extends App {

  val system = ActorSystem("LocalSystem")
  val localActor = system.actorOf(Props[LocalActor], name = "LocalActor") // the local actor
  localActor ! "START" // start the action

}

class LocalActor extends Actor {

  // create the remote actor (Akka 2.1 syntax)
  val remote = context.actorFor("akka://HelloRemoteSystem@127.0.0.1:5150/user/RemoteActor")
  var counter = 0

  def receive = {
    case "START" =>
      remote ! "Hello from the LocalActor"
    case msg: String =>
      println(s"LocalActor received message: '$msg'")
      sender ! readLine()
//      if (counter < 5) {
//        sender ! "Hello back to you"
//        counter += 1
//      }
  }
}