package calcolproject.attivita;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import calcolproject.R;
import calcolproject.espressione.Espressione;
import calcolproject.separatore.Separatore;

public class ActivityCalcolatrice extends AppCompatActivity {
    private Button btn_point, btn_zero, btn_add, btn_sub, btn_one, btn_two, btn_three, btn_mul,
            btn_four, btn_five, btn_six, btn_div, btn_seven, btn_eight, btn_nine, btn_equals, btnEnter, btnVuoto;

    private Button btnCe;
    private Button btnCd;
    private Button btnC;

    private EditText editOne, editTwo;
    private Separatore sep = new Separatore();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcolatrice);

        btn_point = findViewById(R.id.btn_point);
        btn_zero = findViewById(R.id.btn_zero);
        btn_add = findViewById(R.id.btn_add);
        btn_sub = findViewById(R.id.btn_sub);
        btn_one = findViewById(R.id.btn_one);
        btn_two = findViewById(R.id.btn_two);
        btn_three = findViewById(R.id.btn_three);
        btn_mul = findViewById(R.id.btn_mul);
        btn_four = findViewById(R.id.btn_four);
        btn_five = findViewById(R.id.btn_five);
        btn_six = findViewById(R.id.btn_six);
        btn_div = findViewById(R.id.btn_div);
        btn_seven = findViewById(R.id.btn_seven);
        btn_eight = findViewById(R.id.btn_eight);
        btn_nine = findViewById(R.id.btn_nine);
        btn_equals = findViewById(R.id.btn_equals);
        btnEnter = findViewById(R.id.btnEnter);


        btnC = findViewById(R.id.btnC);
        btnCd = findViewById(R.id.btnCd);
        btnCe = findViewById(R.id.btnCe);

        editOne = findViewById(R.id.editOne);
        editTwo = findViewById(R.id.editTwo);

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

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sep.cancellaTutto();
                anyButtonClicked();
            }
        });
        btnCd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sep.cancellaCifra();
                anyButtonClicked();
            }
        });
        btnCe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sep.cancellaElemento();
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

    private void calcolaEspressione() {
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
        } catch (Exception e) {
            editTwo.setText("N/A");
        }
    }

    private void anyButtonClicked() {

        editOne.setText(sep.toString());

        calcolaEspressione();
    }
}
