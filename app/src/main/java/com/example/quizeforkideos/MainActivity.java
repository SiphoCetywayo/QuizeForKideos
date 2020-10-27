package com.example.quizeforkideos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
 /*QuizMenu method Opens the application menu selection screen, Ideally this screen contain multiple quiz for users to select from */
    public void quizMenu(View view) {
        Intent intent = new Intent(MainActivity.this, QuizMenuSelect.class);
        startActivity(intent);
    }

     /*Play method skips the quizMenu and hits the question number 1 of the animal quiz questions*/
    public void Play(View view) {
        Intent startGame = new Intent(MainActivity.this, QuestionOne.class);
        startActivity(startGame);

    }
}
