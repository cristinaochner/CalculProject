package calcolproject.attivita;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import calcolproject.R;

import calcolproject.espressione.Add;
import calcolproject.espressione.Espressione;
import calcolproject.espressione.Mol;
import calcolproject.espressione.Numero;

public class ActivityScelta extends AppCompatActivity {

    TextView TestoInizio;
    Button btnStandard,btnPolacca, btnPolaccaInversa, btnPol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scelta);

        TestoInizio= findViewById(R.id.TestoInizio);
        btnStandard= findViewById(R.id.btnStandard);
        btnPolacca= findViewById(R.id.btnPolacca);
        btnPolaccaInversa= findViewById(R.id.btnPolaccaInversa);
        btnPol= findViewById(R.id.btnPol);

        btnStandard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent apriCalcolatrice= new Intent(ActivityScelta.this,ActivityCalcolatrice.class);
                apriCalcolatrice.putExtra("TIPO_EXPRESSIONE", 0);
                startActivity(apriCalcolatrice);

            }
        });

        btnPolacca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent apriCalcolatrice= new Intent(ActivityScelta.this,ActivityCalcolatrice.class);
                apriCalcolatrice.putExtra("TIPO_EXPRESSIONE", 2);
                startActivity(apriCalcolatrice);
            }
        });

        btnPolaccaInversa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent apriCalcolatrice= new Intent(ActivityScelta.this,ActivityCalcolatrice.class);
                apriCalcolatrice.putExtra("TIPO_EXPRESSIONE", 1);
                startActivity(apriCalcolatrice);
            }
        });

        btnPol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent apriHelp= new Intent(ActivityScelta.this,ActivityAiuto.class);
                apriHelp.putExtra("TIPO_EXPRESSIONE", 1);
                startActivity(apriHelp);
            }
        });




        Espressione e = new Add(new Numero(3.0), new Mol(new Numero(2.0), new Numero(5.0)));

        e.execute();


    }
}
