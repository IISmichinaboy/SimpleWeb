package com.boson.sample.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.dispatch.Futures;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * Created by wanqiang.mwq on 2016/5/20.
 */
public class HelloWorld {

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("MySystem");
        ActorRef myActor = system.actorOf(Props.create(PrintActor.class), "printActor");
        myActor.tell("send string msg!", myActor);
        myActor.tell(Integer.valueOf(1), myActor);
        myActor.tell("shutdown", myActor);
    }
}

class ShutdownActor extends UntypedActor {
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    @Override
    public void onReceive(Object message) throws Exception {
        log.info("shutdown!");
        getContext().system().shutdown();
    }
}

class PrintActor extends UntypedActor {
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    private  final ActorRef shutdownActor = getContext().actorOf(Props.create(ShutdownActor.class), "shutdownActor");

    @Override
    public void preStart() throws Exception {
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof String) {
            log.info("recv msg:{}", message);
            if ("shutdown".equals(message)) {
                shutdownActor.tell(message, this.getSelf());
            }
        } else {
            log.info("unhandled recv msg:{}", message);
            // 丢弃消息
            unhandled(message);
        }
    }
}
