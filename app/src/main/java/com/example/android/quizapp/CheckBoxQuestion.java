package com.example.android.quizapp;

import android.widget.CheckBox;

import java.util.ArrayList;

public class CheckBoxQuestion extends Question {
    /**
     * {@link CheckBoxQuestion} is a concrete class that inherits from the {@link Question} abstract
     * class and implements the {@link #processAnswer()} method, for questions answered through a
     * combination of {@link CheckBox} views.
     */

    private ArrayList<CheckBox> checkBoxViewArray;

    /**
     * Subclass constructor that uses the super class constructor and initiates an additional
     * attribute (checkBoxViewArray) to store the view objects through which the question is
     * answered.
     *
     * @param checkBoxViewArray         {@link ArrayList} of {@link CheckBox} objects related to
     *                                                   the question.
     * @param correctAnswer             Correct answer for the question: integer composed by a
     *                                  sequence of "1"s and "0"s, with a length equal to the
     *                                  number of CheckBox answers. Digits from left to right,
     *                                  represent answers from top to bottom, with "1"s for correct
     *                                  answers and "0"s for wrong answers.
     */
    public CheckBoxQuestion(ArrayList<CheckBox> checkBoxViewArray, int correctAnswer) {
        super(correctAnswer);
        this.checkBoxViewArray = checkBoxViewArray;
    }

    /**
     * Method that processes the answer from the views in the app related to this question and
     * passes it to the {@link #answerQuestion(int)} method as the argument "answerGiven".
     * Initiates an empty {@link String}.
     * For each {@link CheckBox} object related to the question, appends "1" to the previous
     * {@link String} if the {@link CheckBox} is checked, and "0" otherwise.
     * Converts the {@link String} to an {@link Integer} and passes it further.
     */
    public void processAnswer(){
        String answerGivenText = "";

        for(CheckBox answerCheckBox : checkBoxViewArray) {
            if(answerCheckBox.isChecked()) {
                answerGivenText += 1;
            }
            else {
                answerGivenText += 0;
            }
        }
        answerQuestion(Integer.parseInt(answerGivenText));
    }
}
