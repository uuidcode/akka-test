package com.github.uuidcode.akka.test;

import java.util.concurrent.CompletableFuture;

import org.junit.Test;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.testkit.TestKit;

import static akka.pattern.PatternsCS.ask;
import static org.assertj.core.api.Assertions.assertThat;

public class WordCounterActorTest {
    @Test
    public void test() throws Exception {
        TestKit testKit = TestUtil.createTestKit();
        ActorRef actorRef = testKit.childActorOf(Props.create(WordCounterActor.class));

        CountWords countWords = CountWords.of().setLine("this is a text");
        CompletableFuture<Object> future = ask(actorRef, countWords, 1000)
            .toCompletableFuture();

        Integer numberOfWords = (Integer) future.get();
        assertThat(numberOfWords).isEqualTo(4);
    }
}