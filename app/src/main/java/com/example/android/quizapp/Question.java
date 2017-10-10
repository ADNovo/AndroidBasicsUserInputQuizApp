package com.example.android.quizapp;

public abstract class Question {
    /**
    * {@link Question} is an abstract class that stores all attributes and methods of each question
    * in the Quiz app. This abstract class provides all the attributes and methods the
    * {@link #processAnswer()} method, which is implemented on its subclasses.
    */

    private int answerGiven;

    private boolean isQuestionAnswered;

    private int correctAnswer;

    /**
     * Question class constructor
     *
     * @param correctAnswer        Correct answer for the question.
     */
    public Question(int correctAnswer) {

        answerGiven = 0;
        this.correctAnswer = correctAnswer;
        isQuestionAnswered = false;
    }

    /**
     * Method that processes the answer from the views in the app related to this question and
     * passes it to the {@link #answerQuestion(int)} method as the argument "answerGiven".
     */
    public abstract void processAnswer();

    /**
     * Stores the answer given by the user through the views in the app related to this question
     * in the respective attribute and changes the attribute related to whether the question was
     * answered to "true".
     *
     * @param answerGiven           Answer given by the user through the views in the app related
     *                              to this question.
     */
    protected void answerQuestion(int answerGiven) {
        this.answerGiven = answerGiven;
        isQuestionAnswered = true;
    }

    /**
     * Checks whether the question was correctly answered or not.
     * Boolean isQuestionAnswered ensures that even if the correct answer is equal to the default
     * value of answerGiven, the answer will just be considered correct if it was actually answered.
     *
     * @return true if the question was answered correctly, false otherwise.
     */
    public boolean isAnswerCorrect() {
        return isQuestionAnswered && correctAnswer == answerGiven;
    }
}