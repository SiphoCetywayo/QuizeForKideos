package com.example.quizeforkideos;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class QuestionOne extends AppCompatActivity implements View.OnClickListener {

    quizeAppUtils quizeAppUtils = new quizeAppUtils();
    Button btn1, btn2, btn3, btn4;
    public static int questionOneAnswer;
    int TotalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_question_one);

        btn1 = findViewById(R.id.Opt1);
        btn2 = findViewById(R.id.Opt2);
        btn3 = findViewById(R.id.Opt3);
        btn4 = findViewById(R.id.btn_next);
        setBtnInvinsible();


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

    }


    @SuppressLint("ResourceType")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.Opt1:
                incorrectAnswer();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    btn1.setBackground(getDrawable(R.drawable.btnincorrectanswer));
                }
                questionOneAnswer = quizeAppUtils.zeroCount();
                TotalScore = QuizFinalScore(questionOneAnswer);
                btnDisable();
                makeBtnVissible();
                break;

            case R.id.Opt2:
                incorrectAnswer();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    btn2.setBackground(getDrawable(R.drawable.btnincorrectanswer));
                }
                questionOneAnswer = quizeAppUtils.zeroCount();
                TotalScore = QuizFinalScore(questionOneAnswer);
                btnDisable();
                makeBtnVissible();
                break;

            case R.id.Opt3:
                correctAnswer();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    btn3.setBackground(getDrawable(R.drawable.btncorrectanswer));
                }
                questionOneAnswer = quizeAppUtils.scoreCount();
                TotalScore = QuizFinalScore(questionOneAnswer);
                btnDisable();
                makeBtnVissible();
                break;

            case R.id.btn_next:
                nextQuestion();
                break;
        }
    }

    public void btnDisable() {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
    }

    public void setBtnInvinsible() {
        btn4.setVisibility(View.INVISIBLE);

    }

    public void makeBtnVissible() {
        btn4.setVisibility(View.VISIBLE);
    }


    public void incorrectAnswer() {
        Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();
    }

    public void correctAnswer() {
        Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
    }

    public int QuizFinalScore(int QuestionOne) {
        TotalScore = QuestionOne;
        return TotalScore;
    }

    public void nextQuestion() {
        Intent intent = new Intent(QuestionOne.this, QuestionTwo.class);
        intent.putExtra("questionOneAnswer", TotalScore);
        startActivity(intent);
    }

}
