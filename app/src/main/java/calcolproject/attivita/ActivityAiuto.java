package calcolproject.attivita;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import calcolproject.R;

public class ActivityAiuto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int t = getIntent().getExtras().getInt("TIPO_EXPRESSIONE");

        switch (t) {
            case 0:
                setContentView(R.layout.activity_help_st);
                break;
            case 1:
                setContentView(R.layout.activity_help_rpn);
                break;
            case 2:
                setContentView(R.layout.activity_aiuto);
                break;
        }


    }
}
