package com.example.speedcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import static com.example.speedcalculator.R.id.cost;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calButton = findViewById(R.id.Buttoncal);
        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText meteredit = findViewById(R.id.meter);
                EditText timeedit = findViewById(R.id.second);
                TextView km  = findViewById( cost );
                if  (meteredit.length()==0||timeedit.length()==0){
                    Toast t = Toast.makeText( MainActivity.this, R.string.st,Toast.LENGTH_LONG );
                    t.show();

                }
               else if(meteredit.length()>0&&timeedit.length()>0){
                    double m = Double.parseDouble(meteredit.getText().toString());
                    double s = Double.parseDouble(timeedit.getText().toString());
                    double speed = (m/s)/0.277778;

                    if(s > 0){
                        String str = String.format( Locale.getDefault(),"%.2f",speed );
                        km.setText(String.valueOf(str));
                        if(speed>80){
                       AlertDialog.Builder dialog = new AlertDialog.Builder( MainActivity.this );
                       dialog.setTitle("SPEED CALCULATOR");
                       dialog.setMessage( R.string.isover);
                       dialog.setPositiveButton("OK",null);
                       dialog.show();
                                               }
                    }else if (s==0){
                        Toast t = Toast.makeText(MainActivity.this,(getString( R.string.det)),Toast.LENGTH_LONG);
                        t.show();
                    }

                }



            }
        });

        Button cButton = findViewById(R.id.button5);
        cButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              EditText me =findViewById( R.id.meter);
              EditText se = findViewById( R.id.second );
              TextView is = findViewById( cost);

                me.getText().clear();
              se.getText().clear();
              is.setText("");
            }
        } );

    }
}