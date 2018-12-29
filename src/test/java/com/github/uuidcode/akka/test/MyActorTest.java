package com.github.uuidcode.akka.test;

import org.junit.Test;
import org.slf4j.Logger;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.testkit.TestKit;

import static org.slf4j.LoggerFactory.getLogger;

public class MyActorTest {
    protected static Logger logger = getLogger(MyActorTest.class);

    @Test
    public void test() {
        TestKit testKit = TestUtil.createTestKit();
        ActorRef actorRef = testKit.childActorOf(Props.create(MyActor.class));
        actorRef.tell("printit", testKit.testActor());

        testKit.expectMsg("Got Message");
    }
}