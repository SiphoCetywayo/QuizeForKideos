package com.example.quizeforkideos;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class QuestionFour extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2, btn3, btn4;
    public static int question4Answer;
    quizeAppUtils qz4 = new quizeAppUtils();
    int totalScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_four);

        btn1 = findViewById(R.id.BtnOne_Section4);
        btn2 = findViewById(R.id.BtnTwo_Section4);
        btn3 = findViewById(R.id.BtnThree_Section4);
        btn4 = findViewById(R.id.btn_next);
        setBtnInvinsible();

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.BtnOne_Section4:
                correctAnswer();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    btn1.setBackground(getDrawable(R.drawable.btncorrectanswer));
                    question4Answer = qz4.scoreCount();
                    totalScore = QuizFinalScore(question4Answer);
                    btnDisable();
                    makeBtnVissible();
                    break;
                }

            case R.id.BtnTwo_Section4:
                incorrectAnswer();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    btn2.setBackground(getDrawable(R.drawable.btnincorrectanswer));
                    question4Answer = qz4.zeroCount();
                    totalScore = QuizFinalScore(question4Answer);
                    btnDisable();
                    makeBtnVissible();
                    break;
                }

            case R.id.BtnThree_Section4:
                incorrectAnswer();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    btn3.setBackground(getDrawable(R.drawable.btnincorrectanswer));
                    question4Answer = qz4.zeroCount();
                    totalScore = QuizFinalScore(question4Answer);
                    btnDisable();
                    makeBtnVissible();
                    break;
                }

            case R.id.btn_next:
                submit();
        }
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

    public int QuizFinalScore(int Question4Answer) {
        Intent mInntent = getIntent();
        Integer Question3Answer = mInntent.getIntExtra("Question3Answer", 0);
        totalScore = Question4Answer + Question3Answer;
        return totalScore;
    }

    public void submit() {
        Intent intent = new Intent(QuestionFour.this, QuestionFive.class);
        intent.putExtra("FinalSubmit", totalScore);
        startActivity(intent);

    }
}
