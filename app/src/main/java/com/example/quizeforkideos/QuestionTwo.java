package com.example.quizeforkideos;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class QuestionTwo extends AppCompatActivity implements View.OnClickListener {

    quizeAppUtils quizeAppUtils = new quizeAppUtils();
    Button btn1, btn2, btn3, btn4;
   public static int Question2Answer;
    int totalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_two);

        btn1 = findViewById(R.id.BtnOne_Section2);
        btn2 = findViewById(R.id.BtnTwo_Section2);
        btn3 = findViewById(R.id.BtnThree_Section2);
        btn4 = findViewById(R.id.btn_nextSectionTwo);
        setBtnInvinsible();


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.BtnOne_Section2:
                incorrectAnswer();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    btn1.setBackground(getDrawable(R.drawable.btnincorrectanswer));
                }
                Question2Answer = quizeAppUtils.zeroCount();
                QuizFinalScore(Question2Answer);
                btnDisable();
                makeBtnVissible();
                break;

            case R.id.BtnTwo_Section2:
                correctAnswer();
                btn2.setBackground(getDrawable(R.drawable.btncorrectanswer));
                Question2Answer = quizeAppUtils.scoreCount();
                QuizFinalScore(Question2Answer);
                btnDisable();
                makeBtnVissible();
                break;

            case R.id.BtnThree_Section2:
                incorrectAnswer();
                btn3.setBackground(getDrawable(R.drawable.btnincorrectanswer));
                Question2Answer = quizeAppUtils.zeroCount();
                QuizFinalScore(Question2Answer);
                btnDisable();
                makeBtnVissible();
                break;

            case R.id.btn_nextSectionTwo:
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


    public int QuizFinalScore(int question2) {
        Intent mIntent = getIntent();
        Integer QuestionOneAnswer = mIntent.getIntExtra("questionOneAnswer", 0);
        totalScore = question2 + QuestionOneAnswer;
        return totalScore;
    }

    public void nextQuestion() {
        Intent next = new Intent(getApplicationContext(), QuestionThree.class);
        next.putExtra("question1&2 answer", totalScore);
        startActivity(next);
    }

}