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

public class SquareEquation extends AppCompatActivity {
    double aa;
    double b;
    double c;
    EditText a1;
    String a2 ;
    EditText b1 ;
    String b2 ;
    EditText c1;
    String c2;
    Function x2;
    GraphView gV2;
    Graph graph2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_equation);

        x2 = new Function() {

            @Override
            public double apply(double x) {
                return x = (double) aa * Math.pow(x, 2) + b * x + c;
            }
        };
        graph2 = new Graph.Builder().addFunction(x2).setXTicks(new double[]{-9,-8,-7,-6,-5,-4,-3,-2,-1,1,2,3,4,5,6,7,8,9})
                .setYTicks(new double[]{-9,-8,-7,-6,-5,-4,-3,-2,-1,1,2,3,4,5,6,7,8,9}).build();

        gV2 = findViewById(R.id.graphView);
        gV2.setGraph(graph2);

        }
    public void countEquation(View view) {
        boolean Err1 = false;
        boolean Err2 = false;
        boolean Err3 = false;
        a1 = (EditText) findViewById(R.id.dataA);
        a2 = a1.getText().toString();
        if (TextUtils.isEmpty(a2)) {
            a1.setError(getString(R.string.complet));
            Err1 = true;
        }
        b1 = (EditText) findViewById(R.id.dataB);
        b2 = b1.getText().toString();
            if (TextUtils.isEmpty(b2)) {
                b1.setError(getString(R.string.complet));
                Err2 = true;
            }
        c1 = (EditText) findViewById(R.id.dataC);
        c2 = c1.getText().toString();
                if (TextUtils.isEmpty(c2)) {
                    c1.setError(getString(R.string.complet));
                    Err2 = true;
                }

        if (!Err1&&!Err2&&!Err3 ) {

            aa = Double.parseDouble(a2);
            b = Double.parseDouble(b2);
            c = Double.parseDouble(c2);
            TextView text1 = (TextView) findViewById(R.id.solution1);
            TextView text2 = (TextView) findViewById(R.id.solution2);
            TextView deltaText = (TextView)findViewById(R.id.delta);
            if (aa == 0.00) {
                text1.setText(R.string.liniowe);
                if (b == 0) {
                    if (c == 0)

                        text1.setText(R.string.tożsamociowe);

                    else {
                        text1.setText(R.string.contra);
                    }
                } else {
                    double x;
                    x = -c / b;
                    String x11 = String.format("%.2f", x);
                    text1.setText("x = " + x11);

                }
            } else {
                String deltaString;
                double delta;
                delta = (b * b) - (4 * aa * c);
                if (delta < 0) {
                    deltaString = String.format("%.2f", delta);
                    deltaText.setText(" ∆ = "+ deltaString);
                    text1.setText(R.string.no_solution);
                } else if (delta == 0) {
                    double x;
                    x = -b / (2 * aa);
                    String x1 = String.format("%.2f", x);
                    deltaString = String.format("%.2f", delta);
                    text1.setText(x1);
                    deltaText.setText(" ∆ = "+ deltaString);
                } else {
                    double x1;
                    double x2;
                    delta = (b * b) - (4 * aa * c);
                    x1 = (-b - Math.sqrt(delta)) / (2 * aa);
                    x2 = (-b + Math.sqrt(delta)) / (2 * aa);
                    deltaString = String.format("%.2f", delta);
                    deltaText.setText(" ∆ = "+ deltaString);
                    String x11 = String.format("%.2f", x1);
                    text1.setText("x1 = " + x11);
                    String x22 = String.format("%.2f", x2);
                    text2.setText("x2 = " + x22);
                }
            }


        }
        graph2 = new Graph.Builder().addFunction(x2).setXTicks(new double[]{-9,-8,-7,-6,-5,-4,-3,-2,-1,1,2,3,4,5,6,7,8,9})
                .setYTicks(new double[]{-9,-8,-7,-6,-5,-4,-3,-2,-1,1,2,3,4,5,6,7,8,9}).build();
        gV2 = findViewById(R.id.graphView);
        gV2.setGraph(graph2);
    }
    public void clear(View view) {
        EditText a1 = (EditText) findViewById(R.id.dataA);
        EditText b1 = (EditText) findViewById(R.id.dataB);
        EditText c1 = (EditText) findViewById(R.id.dataC);
        TextView text1 = (TextView)findViewById(R.id.solution1);
        TextView text2 = (TextView)findViewById(R.id.solution2);

        a1.setText("");
        b1.setText("");
        c1.setText("");
        text1.setText("");
        text2.setText("");
      graph2 = new Graph.Builder().addFunction(new Function() {
            @Override
            public double apply(double x) {
                return 0;
            }
        }).setXTicks(new double[]{-9,-8,-7,-6,-5,-4,-3,-2,-1,1,2,3,4,5,6,7,8,9})
                .setYTicks(new double[]{-9,-8,-7,-6,-5,-4,-3,-2,-1,1,2,3,4,5,6,7,8,9}).build();
        gV2 = findViewById(R.id.graphView);
        gV2.setGraph(graph2);

    }


}