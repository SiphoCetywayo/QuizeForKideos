package com.example.quizeforkideos;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class QuestionFive extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2, btn3, btn4;
    public static int Question5Answer;
    int totalScore;
    quizeAppUtils qz5 = new quizeAppUtils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_five);

        btn1 = findViewById(R.id.BtnOne_Section5);
        btn2 = findViewById(R.id.BtnTwo_Section5);
        btn3 = findViewById(R.id.BtnThree_Section5);
        btn4 = findViewById(R.id.btn_nextSection5);

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
            case R.id.BtnOne_Section5:
                incorrectAnswer();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    btn1.setBackground(getDrawable(R.drawable.btnincorrectanswer));
                    Question5Answer = qz5.zeroCount();
                    totalScore = QuizFinalScore(Question5Answer);
                    btnDisable();
                    makeBtnVissible();
                }
                break;

            case R.id.BtnTwo_Section5:
                correctAnswer();
                btn2.setBackground(getDrawable(R.drawable.btncorrectanswer));
                Question5Answer = qz5.scoreCount();
                totalScore = QuizFinalScore(Question5Answer);
                btnDisable();
                makeBtnVissible();
                break;

            case R.id.BtnThree_Section5:
                incorrectAnswer();
                btn3.setBackground(getDrawable(R.drawable.btnincorrectanswer));
                Question5Answer = qz5.zeroCount();
                totalScore = QuizFinalScore(Question5Answer);
                btnDisable();
                makeBtnVissible();
                break;

            case R.id.btn_nextSection5:
                finalSubmit();
                break;
        }

    }

    private void finalSubmit() {
        Intent mIntent = new Intent(getApplicationContext(), FinalScore.class);
        mIntent.putExtra("FinalSubmit", totalScore);
        startActivity(mIntent);
    }

    private int QuizFinalScore(int Question5answer) {
        Intent mIntetn = getIntent();
        Integer Question4Answer = mIntetn.getIntExtra("FinalSubmit",0);
        totalScore = Question5answer + Question4Answer;
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
