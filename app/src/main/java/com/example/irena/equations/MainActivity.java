package com.example.irena.equations;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToSolution1(View view) {
        Intent eqS1 = new Intent(getApplicationContext(),SquareEquation.class);
        startActivity(eqS1);
    }

    public void goToSolution2(View view) {
        Intent eqL = new Intent(getApplicationContext(),LinearEquation.class);
        startActivity(eqL);
    }
}
