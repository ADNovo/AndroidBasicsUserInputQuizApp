package com.example.android.quizapp;

import android.widget.RadioGroup;

public class RadioGroupQuestion extends Question {
    /**
     * {@link RadioGroupQuestion} is a concrete class that inherits from the {@link Question}
     * abstract class and implements the {@link #processAnswer()} method, for questions answered
     * through a {@link RadioGroup} view.
     */

    private RadioGroup radioGroupView;

    /**
     * Subclass constructor that uses the super class constructor and initiates an additional
     * attribute (radioGroupView) to store the view object through which the question is answered.
     *
     * @param radioGroupView       {@link RadioGroup} view object related to the question.
     * @param correctAnswer        Correct answer for the question: ID of the correct RadioButton
     *                             answer.
     */
    public RadioGroupQuestion(RadioGroup radioGroupView, int correctAnswer) {
        super(correctAnswer);
        this.radioGroupView = radioGroupView;
    }

    /**
     * Method that passes the ID of the RadioButton of the {@link RadioGroup} view related
     * to this question to the {@link #answerQuestion(int)} method as the argument "answerGiven".
     */
    public void processAnswer(){
        answerQuestion(radioGroupView.getCheckedRadioButtonId());
    }
}
