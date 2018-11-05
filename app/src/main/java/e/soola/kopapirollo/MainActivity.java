package e.soola.kopapirollo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView emberkep;
    private ImageView gepkep;
    private TextView eredmeny;
    private Button ko;
    private Button papir;
    private Button ollo;
    private int emberpont = 0;
    private int geppont = 0;
    private String embervalaszt = "";
    private String gepvalaszt = "";
    private TextView gyoztes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emberkep = (ImageView) findViewById(R.id.emberkep);
        gepkep = (ImageView) findViewById(R.id.gepkep);
        eredmeny = (TextView) findViewById(R.id.eredmeny);
        ko = findViewById(R.id.ko);
        papir = findViewById(R.id.papir);
        ollo = findViewById(R.id.ollo);
        gyoztes = (TextView) findViewById(R.id.gyoztes);

        ko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emberkep.setBackgroundResource(R.drawable.rock);
                embervalaszt = "ko";
                Jatek();
            }
        });
        papir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emberkep.setBackgroundResource(R.drawable.paper);
                embervalaszt = "papir";
                Jatek();
            }
        });
        ollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emberkep.setBackgroundResource(R.drawable.scissors);
                embervalaszt = "ollo";
                Jatek();
            }
        });

    }
    private Random rnd = new Random();
    private void Gepvalasztasa(){
        int random = rnd.nextInt(3);
        switch (random){
            case 0: gepvalaszt = "ko"; gepkep.setBackgroundResource(R.drawable.rock); break;
            case 1: gepvalaszt = "papir"; gepkep.setBackgroundResource(R.drawable.paper); break;
            case 2: gepvalaszt = "ollo"; gepkep.setBackgroundResource(R.drawable.scissors); break;
        }
    }
    private void Jatek(){
        Gepvalasztasa();
        if (embervalaszt != gepvalaszt) {
            if (embervalaszt == "ko" && gepvalaszt != "papir") {
                emberpont++;
                gyoztes.setText("JÁTÉKOS NYERT");
            } else if (embervalaszt == "papir" && gepvalaszt != "ollo") {
                emberpont++;
                gyoztes.setText("JÁTÉKOS NYERT");
            } else if (embervalaszt == "ollo" && gepvalaszt != "ko") {
                emberpont++;
                gyoztes.setText("JÁTÉKOS NYERT");
            } else {
                geppont++;
                gyoztes.setText("GÉP NYERT");
            }
        }
        else{
            gyoztes.setText("DÖNTETLEN");
        }
        Eredmenyfissit();
    }
    private void Eredmenyfissit(){
        eredmeny.setText("Ember: " +emberpont +" Gép: " +geppont);
    }
}
