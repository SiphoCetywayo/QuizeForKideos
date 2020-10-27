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

        /*Applications button widget initialization*/
        btn1 = findViewById(R.id.BtnOne_Section2);
        btn2 = findViewById(R.id.BtnTwo_Section2);
        btn3 = findViewById(R.id.BtnThree_Section2);
        btn4 = findViewById(R.id.btn_nextSectionTwo);

        /*setBtnInvisible() calling statement*/
        setBtnInvinsible();


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override

    /*Switch statement to control user option selection during quiz*/
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.BtnOne_Section2:
                incorrectAnswer();/*incorrectAnswer calling statement*/
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    btn1.setBackground(getDrawable(R.drawable.btnincorrectanswer));
                }
                Question2Answer = quizeAppUtils.zeroCount();
                QuizFinalScore(Question2Answer);
                btnDisable();/*btnDisable() calling statement*/
                makeBtnVisible();/*makeBtnVisible calling statement*/
                break;

            case R.id.BtnTwo_Section2:
                correctAnswer();/*correctAnswer() calling statement*/
                btn2.setBackground(getDrawable(R.drawable.btncorrectanswer));
                Question2Answer = quizeAppUtils.scoreCount();
                QuizFinalScore(Question2Answer);
                btnDisable(); /*btnDisable() calling statement*/
                makeBtnVisible(); /*makeBtnVisible calling statement*/
                break;

            case R.id.BtnThree_Section2:
                incorrectAnswer();/*incorrectAnswer() calling statement*/
                btn3.setBackground(getDrawable(R.drawable.btnincorrectanswer));
                Question2Answer = quizeAppUtils.zeroCount();
                QuizFinalScore(Question2Answer);
                btnDisable();/*btnDisable() calling statement*/
                makeBtnVisible();/*makeBtnVisible calling statement*/
                break;

            /*nextQuestion() calling statement*/
            case R.id.btn_nextSectionTwo:
                nextQuestion();
                break;
        }

    }

    /*btnDisable method controls button disablement */
    public void btnDisable() {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
    }

    /*setBtnInvinsible() set btn4 invisible*/
    public void setBtnInvinsible() {
        btn4.setVisibility(View.INVISIBLE);

    }

    /*makeBtnVissible() changes button invisibility to visible*/
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


    /*QuizFinalScore() returns question 2 scoring*/
    public int QuizFinalScore(int question2) {
        Intent mIntent = getIntent();
        Integer QuestionOneAnswer = mIntent.getIntExtra("questionOneAnswer", 0);
        totalScore = question2 + QuestionOneAnswer;
        return totalScore;
    }

    /*nextQuestion() method navigates users to the next question(Activity)*/
    public void nextQuestion() {
        Intent next = new Intent(getApplicationContext(), QuestionThree.class);
        next.putExtra("question1&2 answer", totalScore);
        startActivity(next);
    }

}