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

    public void btnAnimal(View view) {
        Intent intent = new Intent(QuizMenuSelect.this, QuestionOne.class);
        startActivity(intent);
    }
}