package com.boson.simple.akka;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * Created by wanqiang.mwq on 2016/5/20.
 */
public class HelloActor extends UntypedActor {

    LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof String) {
            log.info("recv msg:{}", message);
        } else {
            log.info("unhandled recv msg:{}", message);
            unhandled(message);
        }
    }
}
