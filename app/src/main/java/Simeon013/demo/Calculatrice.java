package Simeon013.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculatrice extends AppCompatActivity {

    TextView workingsTV;
    TextView resultsTV;

    String workings = "";

    private double click = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatrice);
        initTextView();
    }

    private void initTextView() {
        workingsTV = (TextView)findViewById(R.id.workingsTextview);
        resultsTV = (TextView) findViewById(R.id.resultTextview);
    }

    private void setWorkingsTV(String givenValue){
        workings = workings + givenValue;
        workingsTV.setText(workings);
    }


    public void resultOnclick(View view) {
        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName( "rhino");

        try {
            result = (double)engine.eval(workings);
        }
        catch (ScriptException e){
            Toast.makeText( this,  "Invalid Input", Toast.LENGTH_SHORT).show();
        }

        if(result != null)
            resultsTV.setText(String.valueOf(result.doubleValue()));
    }

    public void clearOnclick(View view) {
        workingsTV.setText("");
        workings = "";
        resultsTV.setText("0");
    }

    public void switchOnclick(View view) {
        char[] p = new char[workings.length()];
        int oc = 0;
        if (workings == "") {
            workingsTV.setText("");
            workings = "";
            resultsTV.setText("0");
        }
        else {
            int negative = Integer.parseInt(workings);
            negative = 0 - negative;
            workings = String.valueOf(negative);
            workingsTV.setText(workings);
        }

    }

    public void pourOnclick(View view) {
        setWorkingsTV("%") ;
    }

    public void divOnclick(View view) {
        setWorkingsTV("/");
    }

    public void sevenOnclick(View view) {
        setWorkingsTV("7");
    }

    public void eightOnclick(View view) {
        setWorkingsTV("8");
    }


    public void nineOnclick(View view) {
        setWorkingsTV("9");
    }

    public void multiOnclick(View view) {
        setWorkingsTV("*");
    }

    public void fourOnclick(View view) {
        setWorkingsTV("4");
    }

    public void fiveOnclick(View view) {
        setWorkingsTV("5");
    }

    public void sixOnclick(View view) {
        setWorkingsTV("6");
    }

    public void sousOnclick(View view) {
        setWorkingsTV("-");
    }

    public void oneOnclick(View view) {
        setWorkingsTV("1");
    }

    public void twoOnclick(View view) {
        setWorkingsTV("2");
    }

    public void treeOnclick(View view) {
        setWorkingsTV("3");
    }

    public void addOnclick(View view) {
        setWorkingsTV("+");
    }

    public void zeroOnclick(View view) {
        setWorkingsTV("0");
    }

    public void virOnclick(View view) {
        setWorkingsTV(".");

    }
}