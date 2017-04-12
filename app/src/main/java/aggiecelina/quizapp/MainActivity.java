package aggiecelina.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int scoreA = 0;
    int scoreB = 0;
    int scoreC = 0;
    int scoreD = 0;
    private ViewHolder viewHolder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewHolder = new ViewHolder();
        viewHolder.ans1a = (RadioButton) findViewById(R.id.ans1a);
        viewHolder.ans1b = (RadioButton) findViewById(R.id.ans1b);
        viewHolder.ans1c = (RadioButton) findViewById(R.id.ans1c);
        viewHolder.ans1d = (RadioButton) findViewById(R.id.ans1d);

        viewHolder.ans2a = (RadioButton) findViewById(R.id.ans2a);
        viewHolder.ans2b = (RadioButton) findViewById(R.id.ans2b);
        viewHolder.ans2c = (RadioButton) findViewById(R.id.ans2c);
        viewHolder.ans2d = (RadioButton) findViewById(R.id.ans2d);

        viewHolder.ans3a = (RadioButton) findViewById(R.id.ans3a);
        viewHolder.ans3b = (RadioButton) findViewById(R.id.ans3b);
        viewHolder.ans3c = (RadioButton) findViewById(R.id.ans3c);
        viewHolder.ans3d = (RadioButton) findViewById(R.id.ans3d);

        viewHolder.ans4a = (RadioButton) findViewById(R.id.ans4a);
        viewHolder.ans4b = (RadioButton) findViewById(R.id.ans4b);
        viewHolder.ans4c = (RadioButton) findViewById(R.id.ans4c);
        viewHolder.ans4d = (RadioButton) findViewById(R.id.ans4d);

        viewHolder.ans5a = (CheckBox) findViewById(R.id.ans5a);
        viewHolder.ans5b = (CheckBox) findViewById(R.id.ans5b);
        viewHolder.ans5c = (CheckBox) findViewById(R.id.ans5c);
        viewHolder.ans5d = (CheckBox) findViewById(R.id.ans5d);
        viewHolder.ans5e = (CheckBox) findViewById(R.id.ans5e);

        viewHolder.nameEditText =  (EditText) findViewById(R.id.nameEditText);
        viewHolder.resultImage = (ImageView) findViewById(R.id.resultImage);
        viewHolder.submitButton =(Button) findViewById(R.id.submit);


    }


    public void onRadioButtonClicked(View view) {

        int max;
        String message;


        ans1();
        ans2();
        ans3();
        ans4();
        ans5();


        max = sortScore(scoreA, scoreB, scoreC, scoreD);
        message = describeResult(max);
        displayResult(max, message);


    }

    public String describeResult(int max){

        String message = "";

        if(max == 0){
            message = getString(R.string.AS);
            viewHolder.resultImage.setImageResource(R.drawable.schopenhauer);
        }

        if(max == 1){
            message = getString(R.string.D);
            viewHolder.resultImage.setImageResource(R.drawable.dalailama);
        }
        if(max == 2){
            message = getString(R.string.L);
            viewHolder.resultImage.setImageResource(R.drawable.lenin);
        }
        if(max ==3){

            message = getString(R.string.Sdb);
            viewHolder.resultImage.setImageResource(R.drawable.simone);
        }

        return message;

    }

    public int sortScore(int scoreA, int scoreB, int scoreC, int scoreD) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(scoreA);
        list.add(scoreB);
        list.add(scoreC);
        list.add(scoreD);

        int max = scoreA;
        int scoreOfMax = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
                scoreOfMax = i;

            }
        }

        return scoreOfMax;
    }

    public void ans5() {

        boolean isAns5aChecked = viewHolder.ans5a.isChecked();
        boolean isAns5bChecked = viewHolder.ans5b.isChecked();
        boolean isAns5cChecked = viewHolder.ans5c.isChecked();
        boolean isAns5dChecked = viewHolder.ans5d.isChecked();
        boolean isAns5eChecked = viewHolder.ans5d.isChecked();

        addScore(isAns5aChecked, isAns5bChecked, isAns5cChecked, isAns5dChecked, isAns5eChecked);


    }

    public void ans4() {


        boolean isAns4aChecked = viewHolder.ans4a.isChecked();
        boolean isAns4bChecked = viewHolder.ans4b.isChecked();
        boolean isAns4cChecked = viewHolder.ans4c.isChecked();
        boolean isAns4dChecked = viewHolder.ans4d.isChecked();

        addScore(isAns4aChecked, isAns4bChecked, isAns4cChecked, isAns4dChecked);


    }

    public void ans3() {


        boolean isAns3aChecked = viewHolder.ans3a.isChecked();
        boolean isAns3bChecked = viewHolder.ans3b.isChecked();
        boolean isAns3cChecked = viewHolder.ans3c.isChecked();
        boolean isAns3dChecked = viewHolder.ans3d.isChecked();

        addScore(isAns3aChecked, isAns3bChecked, isAns3cChecked, isAns3dChecked);


    }

    public void ans2() {


        boolean isAns2aChecked = viewHolder.ans2a.isChecked();
        boolean isAns2bChecked = viewHolder.ans2b.isChecked();
        boolean isAns2cChecked = viewHolder.ans2c.isChecked();
        boolean isAns2dChecked = viewHolder.ans2d.isChecked();

        addScore(isAns2aChecked, isAns2bChecked, isAns2cChecked, isAns2dChecked);


    }


    public void ans1() {


        boolean isAns1aChecked = viewHolder.ans1a.isChecked();
        boolean isAns1bChecked = viewHolder.ans1b.isChecked();
        boolean isAns1cChecked = viewHolder.ans1c.isChecked();
        boolean isAns1dChecked = viewHolder.ans1d.isChecked();

        addScore(isAns1aChecked, isAns1bChecked, isAns1cChecked, isAns1dChecked);


    }

    public void addScore(boolean isAnsAChecked, boolean isAnsBChecked, boolean isAnsCChecked, boolean isAnsDChecked) {

        if (isAnsAChecked)
            scoreA = scoreA + 1;
        if (isAnsBChecked)
            scoreB = scoreB + 1;
        if (isAnsCChecked)
            scoreC = scoreC + 1;
        if (isAnsDChecked)
            scoreD = scoreD + 1;


    }

    public void addScore(boolean isAnsAChecked, boolean isAnsBChecked, boolean isAnsCChecked, boolean isAnsDChecked, boolean isAnsEChecked) {

        if (isAnsAChecked)
            scoreC = scoreC + 1;
        if (isAnsBChecked) {
            scoreC = scoreC + 1;
            scoreD = scoreD + 1;
        }
        if (isAnsCChecked)
            scoreA = scoreA + 1;
        if (isAnsDChecked)
            scoreB = scoreB + 1;
        if (isAnsEChecked)
            scoreD = scoreD + 1;


    }

    public void displayResult(int max, String message) {

        TextView viewResultTextView = (TextView) findViewById(R.id.viewResult);
        String resultTextView = viewHolder.nameEditText.getText().toString() + ", " +  "\n" + message;
        viewResultTextView.setText(resultTextView);

    }

    private class ViewHolder {

        RadioButton ans1a;
        RadioButton ans1b;
        RadioButton ans1c;
        RadioButton ans1d;

        RadioButton ans2a;
        RadioButton ans2b;
        RadioButton ans2c;
        RadioButton ans2d;

        RadioButton ans3a;
        RadioButton ans3b;
        RadioButton ans3c;
        RadioButton ans3d;

        RadioButton ans4a;
        RadioButton ans4b;
        RadioButton ans4c;
        RadioButton ans4d;

        CheckBox ans5a;
        CheckBox ans5b;
        CheckBox ans5c;
        CheckBox ans5d;
        CheckBox ans5e;

        EditText nameEditText;
        ImageView resultImage;
        Button submitButton;

    }

}




