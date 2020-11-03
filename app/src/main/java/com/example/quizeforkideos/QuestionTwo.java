package com.example.quizeforkideos;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class QuestionTwo extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    quizAppUtils quizeAppUtils = new quizAppUtils();
    CheckBox btn1, btn2, btn3, btn4;
    Button btn5;
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
        btn4 = findViewById(R.id.BtnFour_Section2);
        btn5 = findViewById(R.id.btn_nextSectionTwo);

        /*setBtnInvinsible() calling statement to set btn_next invinsible until a maximum 2 checkboxes is selected */
        setBtnInvinsible();

        //OnclickListeners for click events
        setBtnOnclickLisnter();

        //OnCheckedChangeListener for checkbox events
        setOncheckeListner();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    /*Switch statement to control user option selection during quiz*/
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.BtnOne_Section2:
            case R.id.BtnFour_Section2:
                break;

            /*nextQuestion() calling statement incorporated with if/else if statement to control user interaction */
            case R.id.btn_nextSectionTwo:
                if (btn1.isChecked() && btn3.isChecked() && Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    correctAnswer();/*incorrectAnswer calling statement*/
                    btn1.setBackground(getDrawable(R.drawable.btncorrectanswer));
                    btn3.setBackground(getDrawable(R.drawable.btncorrectanswer));
                    Question2Answer = quizeAppUtils.scoreCount();
                    btnDisable();/*btnDisable() calling statement*/

                } else if (btn1.isChecked() && btn2.isChecked()) {
                    incorrectAnswer();/*correctAnswer() calling statement*/
                    btn2.setBackground(getDrawable(R.drawable.btnincorrectanswer));
                    btn1.setBackground(getDrawable(R.drawable.btnincorrectanswer));
                    Question2Answer = quizeAppUtils.zeroCount();
                    btnDisable(); /*btnDisable() calling statement*/

                } else if (btn2.isChecked() && btn3.isChecked()) {
                    incorrectAnswer();/*incorrectAnswer() calling statement*/
                    btn3.setBackground(getDrawable(R.drawable.btnincorrectanswer));
                    btn2.setBackground(getDrawable(R.drawable.btnincorrectanswer));
                    Question2Answer = quizeAppUtils.zeroCount();
                    btnDisable();/*btnDisable() calling statement*/

                } else if (btn1.isChecked() && btn4.isChecked()) {
                    incorrectAnswer();
                    btn4.setBackground(getDrawable((R.drawable.btnincorrectanswer)));
                    btn1.setBackground(getDrawable((R.drawable.btnincorrectanswer)));
                    Question2Answer = quizeAppUtils.zeroCount();
                    btnDisable();/*btnDisable() calling statement*/

                } else if (btn3.isChecked() && btn4.isChecked()) {
                    incorrectAnswer();
                    btn3.setBackground(getDrawable(R.drawable.btnincorrectanswer));
                    btn4.setBackground(getDrawable((R.drawable.btnincorrectanswer)));
                    Question2Answer = quizeAppUtils.zeroCount();
                    btnDisable();/*btnDisable() calling statement*/

                } else if (btn2.isChecked() && btn4.isChecked()) {
                    incorrectAnswer();
                    btn2.setBackground(getDrawable(R.drawable.btnincorrectanswer));
                    btn4.setBackground(getDrawable(R.drawable.btnincorrectanswer));
                    Question2Answer = quizeAppUtils.zeroCount();
                    btnDisable();/*btnDisable() calling statement*/

                }
                nextQuestion(Question2Answer);
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (btn1.isChecked() && btn2.isChecked()) {
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            makeBtnVisible();
        } else if (btn1.isChecked() && btn3.isChecked()) {
            btn2.setEnabled(false);
            btn4.setEnabled(false);
            makeBtnVisible();
        } else if (btn1.isChecked() && btn4.isChecked()) {
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            makeBtnVisible();
        } else if (btn2.isChecked() && btn3.isChecked()) {
            btn1.setEnabled(false);
            btn4.setEnabled(false);
            makeBtnVisible();
        } else if (btn2.isChecked() && btn4.isChecked()) {
            btn1.setEnabled(false);
            btn3.setEnabled(false);
            makeBtnVisible();
        } else if (btn3.isChecked() && btn4.isChecked()) {
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            makeBtnVisible();

        } else {
            btn1.setEnabled(true);
            btn2.setEnabled(true);
            btn3.setEnabled(true);
            btn4.setEnabled(true);
            setBtnInvinsible();
        }
    }

    /*btnDisable method controls button disablement */
    public void btnDisable() {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
    }

    public void setBtnOnclickLisnter(){
       btn5.setOnClickListener(this);
    }

    public void setOncheckeListner(){
        btn1.setOnCheckedChangeListener(this);
        btn2.setOnCheckedChangeListener(this);
        btn3.setOnCheckedChangeListener(this);
        btn4.setOnCheckedChangeListener(this);
    }

    /*setBtnInvinsible() set btn4 invisible*/
    public void setBtnInvinsible() {
        btn5.setVisibility(View.INVISIBLE);

    }

    /*makeBtnVisible() changes button invisibility to visible*/
    public void makeBtnVisible() {
        btn5.setVisibility(View.VISIBLE);
    }

    /*incorrectAnswer() method called when an incorrect option is selected*/
    public void incorrectAnswer() {
        Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();
    }

    /*correctAnswer() called when a correct answer is selected*/
    public void correctAnswer() {
        Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
    }

    /*nextQuestion() method navigates users to the next question(Activity)*/
    public void nextQuestion(int question2) {
        Intent mIntent = getIntent();
        Integer QuestionOneAnswer = mIntent.getIntExtra("questionOneAnswer", 0);
        totalScore = question2 + QuestionOneAnswer;
        Intent next = new Intent(getApplicationContext(), QuestionThree.class);
        next.putExtra("question1&2 answer", totalScore);
        startActivity(next);
    }

}