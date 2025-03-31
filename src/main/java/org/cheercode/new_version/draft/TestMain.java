package org.cheercode.new_version.draft;

import org.cheercode.new_version.ScoreCounter;

public class TestMain {

    public static void main(String[] args) {
        int min = 7;
        int max = 15;
        int score = 10;
        ScoreCounter scoreCounter = new ScoreCounter(min, max, score);

        System.out.println(scoreCounter);

        scoreCounter.add(50);
        System.out.println(scoreCounter);
        scoreCounter.add(-36);
        System.out.println(scoreCounter);
        scoreCounter.sub(73);
        System.out.println(scoreCounter);
        scoreCounter.sub(-34);
        System.out.println(scoreCounter);

    }

}
