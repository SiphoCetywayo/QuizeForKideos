package com.example.quizeforkideos;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

public class FinalScore extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);
        TextView txtScore = findViewById(R.id.txt_score);
        TextView q1Opt = findViewById(R.id.q1Answer);
        TextView q2Opt = findViewById(R.id.q2Answer);
        TextView q3Opt = findViewById(R.id.q3Answer);
        TextView q4Opt = findViewById(R.id.q4Answer);
        TextView q5Opt = findViewById(R.id.q5Answer);

        Intent mIntent = getIntent();
        Integer QuizTotal = mIntent.getIntExtra("FinalSubmit", 0);
        txtScore.setText((QuizTotal + " / 5"));


        if (QuestionOne.questionOneAnswer == 1) {
            Drawable drawable = VectorDrawableCompat.create(getResources(), R.drawable.ic_check_black_24dp, getTheme());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                q1Opt.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, null, null, null);
                q1Opt.setText(getText(R.string.Cheetah));
            }
        } else {
            Drawable drawable = VectorDrawableCompat.create(getResources(), R.drawable.ic_clear_black_24dp, getTheme());
            q1Opt.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, null, null, null);
            q1Opt.setText(getText(R.string.Cheetah));
        }

        if (QuestionTwo.Question2Answer == 1) {
            Drawable drawable = VectorDrawableCompat.create(getResources(), R.drawable.ic_check_black_24dp, getTheme());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                q2Opt.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, null, null, null);
                q2Opt.setText(getText(R.string.Zebra));
            }
        } else {
            Drawable drawable = VectorDrawableCompat.create(getResources(), R.drawable.ic_clear_black_24dp, getTheme());
            q2Opt.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, null, null, null);
            q2Opt.setText(getText(R.string.Zebra));
        }

        if (QuestionThree.Question3Answer == 1) {
            Drawable drawable = VectorDrawableCompat.create(getResources(), R.drawable.ic_check_black_24dp, getTheme());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                q3Opt.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, null, null, null);
                q3Opt.setText(getText(R.string.Tiger));
            }
        } else {
            Drawable drawable = VectorDrawableCompat.create(getResources(), R.drawable.ic_clear_black_24dp, getTheme());
            q3Opt.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, null, null, null);
            q3Opt.setText(getText(R.string.Tiger));
        }

        if (QuestionFour.question4Answer == 1) {
            Drawable drawable = VectorDrawableCompat.create(getResources(), R.drawable.ic_check_black_24dp, getTheme());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                q4Opt.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, null, null, null);
                q4Opt.setText(getText(R.string.Question4));
            }
        } else {
            Drawable drawable = VectorDrawableCompat.create(getResources(), R.drawable.ic_clear_black_24dp, getTheme());
            q4Opt.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, null, null, null);
            q4Opt.setText(getText(R.string.Question4));
        }

        if (QuestionFive.Question5Answer == 1) {
            Drawable drawable = VectorDrawableCompat.create(getResources(), R.drawable.ic_check_black_24dp, getTheme());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                q5Opt.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, null, null, null);
                q5Opt.setText(getText(R.string.oozing_chemicals));
            }
        } else {
            Drawable drawable = VectorDrawableCompat.create(getResources(), R.drawable.ic_clear_black_24dp, getTheme());
            q5Opt.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, null, null, null);
            q5Opt.setText(getText(R.string.oozing_chemicals));
        }


    }
}