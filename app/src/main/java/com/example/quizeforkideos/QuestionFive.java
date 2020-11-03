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

public class QuestionFive extends AppCompatActivity implements View.OnClickListener {

    EditText userInputField;
    Button btn4;
    public static int Question5Answer;
    String finalQuestionTxtinput;
    public static int totalScore;

    quizAppUtils qz5 = new quizAppUtils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_five);

        /*Applications button widget initialization*/
        btn4 = findViewById(R.id.btn_nextSection5);
        userInputField = findViewById(R.id.Q5freeEditText);
        btn4.setOnClickListener(this);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    /*Switch statement to control user option selection during quiz*/
    public void onClick(View v) {
        switch (v.getId()) {

            /*finalSubmit() calling statement incorporated with if/else if conditional statements to determine user input to the quiz questions*/
            case R.id.btn_nextSection5:
                finalQuestionTxtinput = userInputField.getText().toString();
                if (finalQuestionTxtinput.equalsIgnoreCase("oozing chemicals")) {
                    Question5Answer = qz5.scoreCount();
                    correctAnswer(Question5Answer);
                    userInputField.setBackground(getDrawable(R.drawable.btncorrectanswer));
                    userInputField.setEnabled(false);
                } else if (TextUtils.isEmpty(finalQuestionTxtinput)) {
                    userInputField.setError("Field answer can not be left empty");
                    break;
                } else {
                    userInputField.setBackground(getDrawable(R.drawable.btnincorrectanswer));
                    userInputField.setEnabled(false);
                    Question5Answer = qz5.zeroCount();
                    incorrectAnswer(Question5Answer);
                }
                finalSubmit(Question5Answer);
                break;
        }

    }

    /*finalSubmit() submits the final quiz question and navigates the user to score board*/
    private void finalSubmit(int question5Answer) {
        Intent mIntetn = getIntent();
        Intent mIntent = new Intent(getApplicationContext(), FinalScore.class);
        mIntent.putExtra("FinalSubmit", totalScore);
        Integer Question4Answer = mIntetn.getIntExtra("FinalSubmit", 0);
        Intent intent = new Intent(QuestionFive.this, FinalScore.class);
        totalScore = question5Answer + Question4Answer;
        startActivity(mIntent);
    }

    /*incorrectAnswer() method called when an incorrect option is selected*/
    public void incorrectAnswer(int score) {
        Toast.makeText(getApplicationContext(), "Wrong Answer "+ score, Toast.LENGTH_SHORT).show();
    }

    /*correctAnswer() called when a correct answer is selected*/
    public void correctAnswer(int score) {
        Toast.makeText(getApplicationContext(), "Correct Answer "+ score, Toast.LENGTH_SHORT).show();
    }
}
