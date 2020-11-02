package com.example.quizeforkideos;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class QuestionOne extends AppCompatActivity implements View.OnClickListener {

    quizAppUtils quizeAppUtils = new quizAppUtils();
    RadioButton btn1, btn2, btn3;
    Button btn4;
    public static int questionOneAnswer;
    int TotalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_question_one);

        /*Applications button widget initialization*/
        btn1 = findViewById(R.id.Opt1);
        btn2 = findViewById(R.id.Opt2);
        btn3 = findViewById(R.id.Opt3);
        btn4 = findViewById(R.id.btn_next);

        /*setBtnInvinsible() calling statement*/
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
        /*Switch statement to control user option selection during quiz*/
        switch (v.getId()) {
            case R.id.Opt1:

            case R.id.Opt2:

            case R.id.Opt3:

                /*makeBtnVisible() calling statement*/
                makeBtnVisible();
                break;

            case R.id.btn_next:
                /*nextQuestion() calling statement*/
                nextQuestion();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && btn1.isChecked()) {
                    btn1.setBackground(getDrawable(R.drawable.btnincorrectanswer));
                    questionOneAnswer = quizeAppUtils.zeroCount();
                    TotalScore = QuizFinalScore(questionOneAnswer);
                    incorrectAnswer();
                    btnDisable();/*btnDisable() calling statement*/

                } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && btn2.isChecked()) {
                    btn2.setBackground(getDrawable(R.drawable.btnincorrectanswer));
                    questionOneAnswer = quizeAppUtils.zeroCount();
                    TotalScore = QuizFinalScore(questionOneAnswer);
                    incorrectAnswer();
                    btnDisable();/*btnDisable() calling statement*/

                } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    btn3.setBackground(getDrawable(R.drawable.btncorrectanswer));
                    questionOneAnswer = quizeAppUtils.scoreCount();
                    TotalScore = QuizFinalScore(questionOneAnswer);
                    correctAnswer();
                    btnDisable();/*btnDisable() calling statement*/

                }
                break;
        }
    }

    /*btnDisable method controls button disablement */
    public void btnDisable() {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
    }

    /*setBtnInvinsible() set button invisible*/
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

    /*QuizFinalScore() returns question 1 scoring*/
    public int QuizFinalScore(int QuestionOne) {
        TotalScore = QuestionOne;
        return TotalScore;
    }

    /*nextQuestion() method navigates users to the next question(Activity)*/
    public void nextQuestion() {
        Intent intent = new Intent(QuestionOne.this, QuestionTwo.class);
        intent.putExtra("questionOneAnswer", TotalScore);
        startActivity(intent);
    }
}