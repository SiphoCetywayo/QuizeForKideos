package com.example.quizeforkideos;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class QuestionThree extends AppCompatActivity implements View.OnClickListener {

    quizAppUtils qz3 = new quizAppUtils();
    Button btn4;
    EditText userInputField;
    String txt;
    public static int Question3Answer;
    int totalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_three);

        btn4 = findViewById(R.id.btn_nextSection3);
        userInputField = findViewById(R.id.freeTextfield);
        btn4.setOnClickListener(this);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            /*nextQuestion() calling statement*/
            case R.id.btn_nextSection3:
                txt = userInputField.getText().toString();
                if (txt.equalsIgnoreCase("Tiger")) {
                    correctAnswer();
                    Question3Answer = qz3.scoreCount();
                    totalScore = QuizFinalScore(Question3Answer);
                    userInputField.setBackground(getDrawable(R.drawable.btncorrectanswer));
                    userInputField.setEnabled(false);

                } else if (TextUtils.isEmpty(txt)) {
                    userInputField.setError("Field answer cant be empty");
                    break;
                } else {
                    incorrectAnswer();
                    userInputField.setBackground(getDrawable(R.drawable.btnincorrectanswer));
                    userInputField.setEnabled(false);
                    Question3Answer = qz3.zeroCount();
                }
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

    /*correctAnswer() called when a correct option is selected*/
    public void correctAnswer() {
        Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
    }

}