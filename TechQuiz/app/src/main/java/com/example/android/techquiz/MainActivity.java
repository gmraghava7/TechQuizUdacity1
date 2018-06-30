package com.example.android.techquiz;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    int marks;
    // no. of quetions
    int n=6;
    // Question 1
    String messageToShow;
    RadioButton question1_choice1;
    // Question 2
    RadioButton question2_choice2;
    // Question 3
    CheckBox question3_choice1;
    CheckBox question3_choice2;
    CheckBox question3_choice3;
    CheckBox question3_choice4;
    // Question 4
    CheckBox question4_choice1;
    CheckBox question4_choice2;
    CheckBox question4_choice3;
    CheckBox question4_choice4;
    // Question 5
    EditText question5_answer;
    // Question 6
    EditText question6_answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the keyboard
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_main);
    }


    public void submitAnswers(View view) {
        String resultsDisplay;
        int answer1_score;
        int answer2_score;
        int answer3_score;
        int answer4_score;
        int answer5_score;
        int answer6_score;
        int final_score;

        //------------------------------------------------------------------------------------------
        // Question 1 - Correct Answer is #1)
        //------------------------------------------------------------------------------------------
        Boolean answer1;

        question1_choice1 = (RadioButton) this.findViewById(R.id.question1_choice1);
        answer1 = question1_choice1.isChecked();
        if (answer1) {
            answer1_score = 1;
        } else {
            answer1_score = 0;
        }

        //------------------------------------------------------------------------------------------
        // Question 2 - Correct Answer is #2
        //------------------------------------------------------------------------------------------

        Boolean answer2;
        question2_choice2 = (RadioButton) this.findViewById(R.id.question2_choice2);
        answer2 = question2_choice2.isChecked();
        if (answer2) {
            answer2_score = 1;
        } else {
            answer2_score = 0;
        }

        //------------------------------------------------------------------------------------------
        // Question 3  - Correct Answers are #1  #2 and #3
        //------------------------------------------------------------------------------------------
        Boolean answer3_choice1;
        Boolean answer3_choice2;
        Boolean answer3_choice3;
        Boolean answer3_choice4;
        question3_choice1 = (CheckBox) this.findViewById(R.id.question3_choice1);
        question3_choice2 = (CheckBox) this.findViewById(R.id.question3_choice2);
        question3_choice3 = (CheckBox) this.findViewById(R.id.question3_choice3);
        question3_choice4 = (CheckBox) this.findViewById(R.id.question3_choice4);
        answer3_choice1 = question3_choice1.isChecked();
        answer3_choice2 = question2_choice2.isChecked();
        answer3_choice3 = question3_choice3.isChecked();
        answer3_choice4 = question3_choice4.isChecked();
        if (answer3_choice1 && answer3_choice2 && answer3_choice3 && !answer3_choice4)
        {
            answer3_score = 1;
        } else {
            answer3_score = 0;
        }


        //------------------------------------------------------------------------------------------
        // Question 4  - Correct Answers are #2  and #4
        //------------------------------------------------------------------------------------------
        Boolean answer4_choice1;
        Boolean answer4_choice2;
        Boolean answer4_choice3;
        Boolean answer4_choice4;
        question4_choice1 = (CheckBox) this.findViewById(R.id.question4_choice1);
        question4_choice2 = (CheckBox) this.findViewById(R.id.question4_choice2);
        question4_choice3 = (CheckBox) this.findViewById(R.id.question4_choice3);
        question4_choice4 = (CheckBox) this.findViewById(R.id.question4_choice4);
        answer4_choice1 = question4_choice1.isChecked();
        answer4_choice2 = question4_choice2.isChecked();
        answer4_choice3 = question4_choice3.isChecked();
        answer4_choice4 = question4_choice4.isChecked();
        if (!answer4_choice1 && answer4_choice2 && !answer4_choice3 && answer4_choice4) {
            answer4_score = 1;
        } else {
            answer4_score = 0;
        }

        //------------------------------------------------------------------------------------------
        // Question 5  - Correct Answers is #Motorola
        //------------------------------------------------------------------------------------------

        String answer5;
        question5_answer = (EditText) this.findViewById(R.id.question5_answer);
        answer5 = question5_answer.getText().toString().toLowerCase();
        if (answer5.equals("motorola")) {
            answer5_score = 1;
        } else {
            answer5_score = 0;
        }

        //------------------------------------------------------------------------------------------
        // Question 6  - Correct Answers is #1980
        //------------------------------------------------------------------------------------------

        String answer6;
        question6_answer = (EditText) this.findViewById(R.id.question6_answer);
        answer6 = question6_answer.getText().toString().toLowerCase();
        if (answer6.equals("1980")) {
            answer6_score = 1;
        } else {
            answer6_score = 0;
        }


        //------------------------------------------------------------------------------------------
        // Final Score
        //------------------------------------------------------------------------------------------
        final_score = answer1_score + answer2_score + answer3_score + answer4_score + answer5_score +
                answer6_score ;
        marks=final_score;

        if (marks == n) {
            resultsDisplay = "Perfect! You scored " + n + " out of " + n;
        } else {
            resultsDisplay = "Try again. You scored " + marks + " out of "+n;
        }
        messageToShow = resultsDisplay;
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, resultsDisplay, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        display(marks);
        displayMessage(messageToShow);
        displayEach(answer1_score,answer2_score,answer3_score,answer4_score,answer5_score,answer6_score);



    }
    private void displayEach(int n1, int n2, int n3, int n4, int n5, int n6) {
        TextView eachTextView = (TextView) findViewById(R.id.each_text_view);
        eachTextView.setText("" + n1+n2+n3+n4+n5+n6);
    }
    private void display(int number) {
        TextView resultTextView = (TextView) findViewById(R.id.result_text_view);
        resultTextView.setText("" + number);
    }

    private void displayMessage(String message) {
        TextView messageTextView = (TextView) findViewById(R.id.message_text_view);
        messageTextView.setText(message);
    }
}