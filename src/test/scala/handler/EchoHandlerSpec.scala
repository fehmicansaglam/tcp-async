package handler

import org.scalatest.matchers.MustMatchers
import org.scalatest.{ BeforeAndAfterAll, WordSpec }
import akka.actor.ActorSystem
import akka.testkit.{ ImplicitSender, TestKit }
import akka.io.Tcp._
import akka.util.ByteString
import akka.io.Tcp.Received

class EchoHandlerSpec(_system: ActorSystem)
    extends TestKit(_system)
    with ImplicitSender
    with WordSpec
    with MustMatchers
    with BeforeAndAfterAll {

  def this() = this(ActorSystem("EchoHandlerSpec"))

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  "A EchoHandler" must {

    "echo the message" in {
      val handler = system.actorOf(EchoHandler.props(testActor))
      val data = ByteString("hello")
      handler ! Received(data)
      expectMsg(Write(data))
    }

    "close itself if close message is received" in {
      val handler = system.actorOf(EchoHandler.props(testActor))
      watch(handler)
      val data = ByteString("close")
      handler ! Received(data)
      expectTerminated(handler)
    }

    "close itself if peer closed" in {
      val handler = system.actorOf(EchoHandler.props(testActor))
      watch(handler)
      handler ! PeerClosed
      expectTerminated(handler)
    }

  }

}