package com.example.android.quizapp;

import android.widget.EditText;

public class EditTextQuestion extends Question {
    /**
     * {@link EditTextQuestion} is a concrete class that inherits from the {@link Question} abstract
     * class and implements the {@link #processAnswer()} method, for questions answered through an
     * {@link EditText} view.
     */

    private EditText editTextView;

    /**
     * Subclass constructor that uses the super class constructor and initiates an additional
     * attribute (editTextView) to store the view object through which the question is answered.
     *
     * @param editTextView         {@link EditText} view object related to the question.
     * @param correctAnswer        Correct answer for the question.
     */
    public EditTextQuestion(EditText editTextView, int correctAnswer) {
        super(correctAnswer);
        this.editTextView = editTextView;
    }

    /**
     * Method that gets the {@link String} from the {@link EditText} view related to this question
     * and, if not empty, converts it to an {@link Integer} and passes it to the
     * {@link #answerQuestion(int)} method as the argument "answerGiven".
     */
    public void processAnswer() {
        String answerGivenText = editTextView.getText().toString();

        if (!answerGivenText.equals("")){
            answerQuestion(Integer.parseInt(answerGivenText));
        }
    }
}
