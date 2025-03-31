package org.cheercode.after_review_version.games;

public class ScoreCounter {
    private final int minValue;
    private final int maxValue;
    private int score;

    public ScoreCounter(int minValue, int maxValue, int score) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.score = score;
    }

    public void add(int value) {
        score += value;
        correctScore();
    }

    private void correctScore() {
        if (score < minValue) {
            score = minValue;
        }
        if (score > maxValue) {
            score = maxValue;
        }
    }

    public void sub(int value) {
        score -= value;
        correctScore();
    }

    public int getScore() {
        return score;
    }

    public boolean isMaxValue() {
        return score == maxValue;
    }

    public boolean isMinValue() {
        return score == minValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    @Override
    public String toString() {
        return "ScoreCounter{" +
                "minValue=" + minValue +
                ", maxValue=" + maxValue +
                ", score=" + score +
                '}';
    }
}
