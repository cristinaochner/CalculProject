package com.example.cristina.calcolproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView TestoInizio;
    Button btnStandard,btnPolacca, btnPolaccaInversa, btnPol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TestoInizio= (TextView)findViewById(R.id.TestoInizio);
        btnStandard= (Button) findViewById(R.id.btnStandard);
        btnPolacca= (Button) findViewById(R.id.btnPolacca);
        btnPolaccaInversa= (Button) findViewById(R.id.btnPolaccaInversa);
        btnPol= (Button) findViewById(R.id.btnPol);

        btnStandard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent apriCalcolatrice= new Intent(MainActivity.this,Bottoni.class);
                apriCalcolatrice.putExtra("TIPO_EXPRESSIONE", 0);
                startActivity(apriCalcolatrice);

            }
        });

        btnPolacca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent apriCalcolatrice= new Intent(MainActivity.this,Bottoni.class);
                apriCalcolatrice.putExtra("TIPO_EXPRESSIONE", 2);
                startActivity(apriCalcolatrice);
            }
        });

        btnPolaccaInversa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent apriCalcolatrice= new Intent(MainActivity.this,Bottoni.class);
                apriCalcolatrice.putExtra("TIPO_EXPRESSIONE", 1);
                startActivity(apriCalcolatrice);
            }
        });

        btnPol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent apriHelp= new Intent(MainActivity.this,HelpActivity.class);
                apriHelp.putExtra("TIPO_EXPRESSIONE", 1);
                startActivity(apriHelp);
            }
        });




        Expression e = new Add(new Number(3.0), new Mul(new Number(2.0), new Number(5.0)));

        e.execute();


    }
}
