package com.github.uuidcode.akka.test;

import akka.actor.ActorSystem;
import akka.testkit.TestKit;

public class TestUtil {
    public static TestKit createTestKit() {
        ActorSystem actorSystem  = ActorSystem.create("test-system");
        return new TestKit(actorSystem);
    }
}
