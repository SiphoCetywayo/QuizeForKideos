package com.example.quizeforkideos;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class QuestionThree extends AppCompatActivity implements View.OnClickListener {

    quizeAppUtils qz3 = new quizeAppUtils();
    Button btn1, btn2, btn3, btn4;
    public static int Question3Answer;
    int totalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_three);

        btn1 = findViewById(R.id.BtnOne_Section3);
        btn2 = findViewById(R.id.BtnTwo_Section3);
        btn3 = findViewById(R.id.BtnThree_Section3);
        btn4 = findViewById(R.id.btn_nextSection3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        setBtnInvinsible();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.BtnOne_Section3:
                correctAnswer();
                btn1.setBackground(getDrawable(R.drawable.btncorrectanswer));
                Question3Answer = qz3.scoreCount();
                totalScore = QuizFinalScore(Question3Answer);
                btnDisable();
                makeBtnVissible();
                break;

            case R.id.BtnTwo_Section3:
                incorrectAnswer();
                btn2.setBackground(getDrawable(R.drawable.btnincorrectanswer));
                Question3Answer = qz3.zeroCount();
                totalScore = QuizFinalScore(Question3Answer);
                btnDisable();
                makeBtnVissible();
                break;

            case R.id.BtnThree_Section3:
                incorrectAnswer();
                btn3.setBackground(getDrawable(R.drawable.btnincorrectanswer));
                Question3Answer = qz3.zeroCount();
                totalScore = QuizFinalScore(Question3Answer);
                btnDisable();
                makeBtnVissible();
                break;

            case R.id.btn_nextSection3:
                nextQuestion();
        }

    }

    private void nextQuestion() {
        Intent next = new Intent(getApplicationContext(), QuestionFour.class);
        next.putExtra("Question3Answer", totalScore);
        startActivity(next);
    }

    private int QuizFinalScore(int question3Answer) {
        Intent mIntent = getIntent();
        Integer Q1andQ2answers = mIntent.getIntExtra("question1&2 answer", 0);
        totalScore = Q1andQ2answers + question3Answer;
        return totalScore;
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

    public void btnDisable() {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
    }

}