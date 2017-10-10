package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Initializes the {@link Question} objects for each question in the quiz and stores them in an
     * {@link ArrayList}.
     *
     * @return correctAnswers           {@link ArrayList} of {@link Question} objects, one for each
     *                                  question in the app.
     */
    private ArrayList<Question> createQuestions() {

        ArrayList<Question> questionList = new ArrayList<>();

        //Initializes Question 1 and adds it to the list.
        ArrayList<CheckBox> question1CheckBoxViewArray = new ArrayList<>();
        CheckBox question1Answer1View = (CheckBox) findViewById(R.id.question_1_check_box_1);
        question1CheckBoxViewArray.add(question1Answer1View);
        CheckBox question1Answer2View  = (CheckBox) findViewById(R.id.question_1_check_box_2);
        question1CheckBoxViewArray.add(question1Answer2View);
        CheckBox question1Answer3View  = (CheckBox) findViewById(R.id.question_1_check_box_3);
        question1CheckBoxViewArray.add(question1Answer3View);
        CheckBox question1Answer4View  = (CheckBox) findViewById(R.id.question_1_check_box_4);
        question1CheckBoxViewArray.add(question1Answer4View);

        CheckBoxQuestion question1CheckBoxQuestion = new CheckBoxQuestion(question1CheckBoxViewArray
                , 1010);
        questionList.add(question1CheckBoxQuestion);

        //Initializes Question 2 and adds it to the list.
        EditText question2EditText = (EditText) findViewById(R.id.question_2_edit_text);
        EditTextQuestion question2EditTextQuestion = new EditTextQuestion(question2EditText, 18);
        questionList.add(question2EditTextQuestion);

        //Initializes Question 3 and adds it to the list.
        EditText question3EditText = (EditText) findViewById(R.id.question_3_edit_text);
        EditTextQuestion question3EditTextQuestion = new EditTextQuestion(question3EditText, 30);
        questionList.add(question3EditTextQuestion);

        //Initializes Question 4 and adds it to the list.
        RadioGroup question4RadioGroup = (RadioGroup)findViewById(R.id.question_4_radio_group);
        RadioGroupQuestion question4RadioGroupQuestion = new RadioGroupQuestion(question4RadioGroup,
                R.id.question_4_radio_button_3);
        questionList.add(question4RadioGroupQuestion);

        //Initializes Question 5 and adds it to the list.
        RadioGroup question5RadioGroup = (RadioGroup)findViewById(R.id.question_5_radio_group);
        RadioGroupQuestion question5RadioGroupQuestion = new RadioGroupQuestion(question5RadioGroup,
                R.id.question_5_radio_button_3);
        questionList.add(question5RadioGroupQuestion);

        //Initializes Question 6 and adds it to the list.
        RadioGroup question6RadioGroup = (RadioGroup)findViewById(R.id.question_6_radio_group);
        RadioGroupQuestion question6RadioGroupQuestion = new RadioGroupQuestion(question6RadioGroup,
                R.id.question_6_radio_button_4);
        questionList.add(question6RadioGroupQuestion);

        return questionList;

    }

    /**
     * Checks how many questions of the quiz were answered correctly. For each {@link Question}
     * object in the questionList {@link ArrayList} object, processes the answer and checks whether
     * it was answered correctly.
     *
     * @param questionList              {@link ArrayList} of {@link Question} objects, one for each
     *                                  question in the app.
     * @return correctAnswers           Number of questions of the quiz answered correctly.
     */
    private int checkCorrectAnswers(ArrayList<Question> questionList) {

        int correctAnswers = 0;

        for (Question question : questionList) {
            if (question instanceof CheckBoxQuestion) {
                CheckBoxQuestion checkBoxQuestion = (CheckBoxQuestion) question;
                checkBoxQuestion.processAnswer();
            }
            else if (question instanceof EditTextQuestion) {
                EditTextQuestion editTextQuestion = (EditTextQuestion) question;
                editTextQuestion.processAnswer();
            }
            else if (question instanceof RadioGroupQuestion) {
                RadioGroupQuestion radioGroupQuestion = (RadioGroupQuestion) question;
                radioGroupQuestion.processAnswer();
            }
            if (question.isAnswerCorrect()) {
                correctAnswers++;
            }
        }
        return correctAnswers;
    }

    public void submitAnswers(View view) {

        //Initializes the questions objects for each question in the quiz and stores them in a list.
        ArrayList<Question> questionList = createQuestions();

        //Checks how many questions of the quiz were answered correctly.
        int correctAnswers = checkCorrectAnswers(questionList);

        //Initiliazes the toast message to be displayed, with the number of questions answered
        //correctly and the total number of questions in the quiz.
        String toastMessage = String.format(getString(R.string.toast_message),
                correctAnswers, questionList.size());

        //Generates the toast with the message above.
        Toast.makeText(this, toastMessage , Toast.LENGTH_SHORT).show();
    }
}