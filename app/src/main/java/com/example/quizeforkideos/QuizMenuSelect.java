package com.example.quizeforkideos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class QuizMenuSelect extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_menu_select);
        getSupportActionBar().setTitle("Quiz Menu");

    }

    /*The btnAnimal() method calls the Animal quize questions for the user to begin with their quize*/
    public void btnAnimal(View view) {
        Intent intent = new Intent(QuizMenuSelect.this, QuestionOne.class);
        startActivity(intent);
    }
}