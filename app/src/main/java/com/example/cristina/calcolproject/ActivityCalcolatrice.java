package com.example.cristina.calcolproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class ActivityCalcolatrice extends AppCompatActivity {
    private Button btn_point, btn_zero, btn_add, btn_sub, btn_one, btn_two, btn_three, btn_mul,
            btn_four, btn_five, btn_six, btn_div, btn_seven, btn_eight, btn_nine, btn_equals, btnEnter,
            btnCe, btnCancelSingle, btnVuoto;
    private EditText editOne, editTwo;
    private Separatore sep = new Separatore();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcolatrice);

        btn_point = (Button) findViewById(R.id.btn_point);
        btn_zero = (Button) findViewById(R.id.btn_zero);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_sub = (Button) findViewById(R.id.btn_sub);
        btn_one = (Button) findViewById(R.id.btn_one);
        btn_two = (Button) findViewById(R.id.btn_two);
        btn_three = (Button) findViewById(R.id.btn_three);
        btn_mul = (Button) findViewById(R.id.btn_mul);
        btn_four = (Button) findViewById(R.id.btn_four);
        btn_five = (Button) findViewById(R.id.btn_five);
        btn_six = (Button) findViewById(R.id.btn_six);
        btn_div = (Button) findViewById(R.id.btn_div);
        btn_seven = (Button) findViewById(R.id.btn_seven);
        btn_eight = (Button) findViewById(R.id.btn_eight);
        btn_nine = (Button) findViewById(R.id.btn_nine);
        btn_equals = (Button) findViewById(R.id.btn_equals);
        btnEnter = (Button) findViewById(R.id.btnEnter);

        editOne = (EditText) findViewById(R.id.editOne);
        editTwo = (EditText) findViewById(R.id.editTwo);

        btn_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sep.addNumber(".");
                anyButtonClicked();
            }
        });
        btn_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sep.addNumber("0");
                anyButtonClicked();
            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sep.addOperator("+");
                anyButtonClicked();
            }
        });
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sep.addOperator("-");
                anyButtonClicked();
            }
        });
        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sep.addNumber("1");
                anyButtonClicked();
            }
        });
        btn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sep.addNumber("2");
                anyButtonClicked();
            }
        });
        btn_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sep.addNumber("3");
                anyButtonClicked();
            }
        });
        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sep.addOperator("*");
                anyButtonClicked();
            }
        });
        btn_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sep.addNumber("4");
                anyButtonClicked();
            }
        });
        btn_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sep.addNumber("5");
                anyButtonClicked();
            }
        });
        btn_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sep.addNumber("6");
                anyButtonClicked();
            }
        });
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sep.addOperator("/");
                anyButtonClicked();
            }
        });
        btn_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sep.addNumber("7");
                anyButtonClicked();
            }
        });
        btn_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sep.addNumber("8");
                anyButtonClicked();
            }
        });
        btn_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sep.addNumber("9");
                anyButtonClicked();
            }
        });
        btn_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anyButtonClicked();
            }
        });
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sep.enter();
                anyButtonClicked();
            }
        });


    }

    private void calcolaEspressione()
    {
        try {
            int type = getIntent().getExtras().getInt("TIPO_EXPRESSIONE");
            ArrayList<String> elementi = sep.getElementi();

            Espressione e = null;
            if (type == 0)
                e = Espressione.creaClassica(elementi);

            if (type == 1)
                e = Espressione.creaRPN(elementi);

            if (type == 2)
                e = Espressione.creaPolacca(elementi);

            editTwo.setText(String.valueOf(e.execute()));
        } catch (Exception e)
        {
            editTwo.setText("N/A");}
    }

    private void anyButtonClicked() {

        editOne.setText(sep.toString());

        calcolaEspressione();
    }
}
