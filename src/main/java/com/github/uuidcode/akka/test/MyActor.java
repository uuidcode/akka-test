package com.github.uuidcode.akka.test;

import org.slf4j.Logger;

import akka.actor.AbstractActor;

import static org.slf4j.LoggerFactory.getLogger;

public class MyActor extends AbstractActor {
    protected static Logger logger = getLogger(MyActor.class);

    public Receive createReceive() {
        return receiveBuilder().matchEquals("printit", p -> {
           if (logger.isDebugEnabled()) {
               logger.debug(">>> The address of this actor is : {}", getSelf());
           }

            getSender().tell("Got Message", getSelf());
        }).build();
    }
}
