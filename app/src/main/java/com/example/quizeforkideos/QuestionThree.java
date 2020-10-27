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

        /*Applications button widget initialization*/
        btn1 = findViewById(R.id.BtnOne_Section3);
        btn2 = findViewById(R.id.BtnTwo_Section3);
        btn3 = findViewById(R.id.BtnThree_Section3);
        btn4 = findViewById(R.id.btn_nextSection3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

        /*setBtnInvisible() calling statement*/
        setBtnInvinsible();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override

    /*Switch statement to control user option selection during quiz*/
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.BtnOne_Section3:
                correctAnswer();/*correctAnswer() calling statement*/
                btn1.setBackground(getDrawable(R.drawable.btncorrectanswer));
                Question3Answer = qz3.scoreCount();
                totalScore = QuizFinalScore(Question3Answer);
                btnDisable();/*btnDisable() calling statement*/
                makeBtnVisible();/*makeBtnVisible calling statement*/
                break;

            case R.id.BtnTwo_Section3:
                incorrectAnswer();/*incorrectAnswer calling statement*/
                btn2.setBackground(getDrawable(R.drawable.btnincorrectanswer));
                Question3Answer = qz3.zeroCount();
                totalScore = QuizFinalScore(Question3Answer);
                btnDisable();/*btnDisable() calling statement*/
                makeBtnVisible();/*makeBtnVisible calling statement*/
                break;

            case R.id.BtnThree_Section3:
                incorrectAnswer();/*incorrectAnswer calling statement*/
                btn3.setBackground(getDrawable(R.drawable.btnincorrectanswer));
                Question3Answer = qz3.zeroCount();
                totalScore = QuizFinalScore(Question3Answer);
                btnDisable();/*btnDisable() calling statement*/
                makeBtnVisible(); /*makeBtnVisible calling statement*/
                break;

            /*nextQuestion() calling statement*/
            case R.id.btn_nextSection3:
                nextQuestion();
        }

    }

    /*nextQuestion() method navigates users to the next question(Activity)*/
    private void nextQuestion() {
        Intent next = new Intent(getApplicationContext(), QuestionFour.class);
        next.putExtra("Question3Answer", totalScore);
        startActivity(next);
    }

    /*QuizFinalScore() returns question 3 scoring*/
    private int QuizFinalScore(int question3Answer) {
        Intent mIntent = getIntent();
        Integer Q1andQ2answers = mIntent.getIntExtra("question1&2 answer", 0);
        totalScore = Q1andQ2answers + question3Answer;
        return totalScore;
    }

    /*setBtnInvinsible() set btn4 invisible*/
    public void setBtnInvinsible() {
        btn4.setVisibility(View.INVISIBLE);
    }

    /*makeBtnVisible() changes btn4 invisibility to visible*/
    public void makeBtnVisible() {
        btn4.setVisibility(View.VISIBLE);
    }

    /*incorrectAnswer() method called when an incorrect option is selected*/
    public void incorrectAnswer() {
        Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();
    }

    /*correctAnswer() called when a correct answer is selected*/
    public void correctAnswer() {
        Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
    }

    /*btnDisable method controls button disablement */
    public void btnDisable() {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
    }

}