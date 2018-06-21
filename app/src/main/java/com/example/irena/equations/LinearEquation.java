package com.example.irena.equations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.softmoore.android.graphlib.Function;
import com.softmoore.android.graphlib.Graph;
import com.softmoore.android.graphlib.GraphView;
import com.softmoore.android.graphlib.Point;

public class LinearEquation extends AppCompatActivity {
    public static Point[] values;
    double a ;
    double b ;
    Graph graph1;
    GraphView gV;
    EditText b2;
    String b1;
    EditText c2;
    String c1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_equation);
        graph1 = new Graph.Builder().addFunction(
                new Function() {
                    @Override
                    public double apply(double x) {
                        return x = (double) a * x + b;
                    }
                }).setXTicks(new double[]{-9,-8,-7,-6,-5,-4,-3,-2,-1,1,2,3,4,5,6,7,8,9})
                .setYTicks(new double[]{-9,-8,-7,-6,-5,-4,-3,-2,-1,1,2,3,4,5,6,7,8,9}).build();

         gV = findViewById(R.id.graphView1);
        gV.setGraph(graph1);

    }

    public void countLin(View view) {
        TextView text1 = (TextView) findViewById(R.id.solutionL);
         b2 = (EditText) findViewById(R.id.dataA1);
         b1 = b2.getText().toString();
        boolean isErr = false;
        boolean isErr2 = false;
        if (TextUtils.isEmpty(b1)) {
            b2.setError(getString(R.string.complet));
            isErr = true;
        }
         c2 = (EditText) findViewById(R.id.dataB1);
         c1 = c2.getText().toString();
        if (TextUtils.isEmpty(c1)) {
            c2.setError(getString(R.string.complet));
            isErr2 = true;
        }
        if (!isErr && !isErr2) {
            a = Double.parseDouble(b1);
            b = Double.parseDouble(c1);

            if (a == 0) {
                if (b == 0)

                    text1.setText(R.string.tożsamociowe);

                else {
                    text1.setText(R.string.contra);
                }
            } else {
                double x;
                x = -b / a;
                String x11 = String.format("%.2f", x);
                text1.setText("x = " + x11);

            }
        }
        graph1 = new Graph.Builder().addFunction(
                new Function() {
                    @Override
                    public double apply(double x) {
                        return x = (double) a * x + b;
                    }
                }).setXTicks(new double[]{-9,-8,-7,-6,-5,-4,-3,-2,-1,1,2,3,4,5,6,7,8,9})
                .setYTicks(new double[]{-9,-8,-7,-6,-5,-4,-3,-2,-1,1,2,3,4,5,6,7,8,9}).build();
        gV = findViewById(R.id.graphView1);
        gV.setGraph(graph1);

    }
    public void clear(View view) {

        TextView text1 = (TextView) findViewById(R.id.solutionL);
         b2 = (EditText) findViewById(R.id.dataA1);
         c2 = (EditText) findViewById(R.id.dataB1);
        text1.setText("");
        b2.setText("");
        c2.setText("");
         graph1 = new Graph.Builder().addFunction(new Function() {
            @Override
            public double apply(double x) {
                return 0;
            }
        }).setXTicks(new double[]{-9,-8,-7,-6,-5,-4,-3,-2,-1,1,2,3,4,5,6,7,8,9})
                .setYTicks(new double[]{-9,-8,-7,-6,-5,-4,-3,-2,-1,1,2,3,4,5,6,7,8,9}).build();
        gV = findViewById(R.id.graphView1);
        gV.setGraph(graph1);
    }


}

