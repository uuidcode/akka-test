package com.github.uuidcode.akka.test;

import org.slf4j.Logger;

import akka.actor.AbstractActor;

import static org.slf4j.LoggerFactory.getLogger;

public class WordCounterActor extends AbstractActor {
    protected static Logger logger = getLogger(WordCounterActor.class);

    @Override
    public Receive createReceive() {
        return receiveBuilder()
            .match(CountWords.class, countWords -> {
                try {
                    if (logger.isDebugEnabled()) {
                        logger.debug(">>> Received CountWords from {}", getSender());
                    }

                    int numberOfWords = countWordsFromLine(countWords.getLine());
                    getSender().tell(numberOfWords, getSelf());
                } catch (Throwable t) {
                    if (logger.isErrorEnabled()) {
                        logger.error(">>> error WordCounterActor createReceive", t);
                    }
                }
            })
            .build();
    }

    private int countWordsFromLine(String line) {
        int numberOfWords = 0;

        String[] words = line.split(" ");

        for (String word : words) {
            if (word.trim().length() > 0) {
                numberOfWords++;
            }
        }

        return numberOfWords;
    }
}
