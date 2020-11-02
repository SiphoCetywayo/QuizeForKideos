package com.example.quizeforkideos;

public final class quizeAppUtils {


    static int scoreCount() {
        int score = +1;
        return score;
    }

    int zeroCount() {

        int score = +0;
        return score;
    }

    public void delay(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
