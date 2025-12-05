package mx.edu.tesoem.isc.tsdmh_7s21_proy_zehk_p3;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class PRINActivity extends AppCompatActivity {

    TabHost tabHost;
    Button btnSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prinactivity);

        tabHost = findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec spec1 = tabHost.newTabSpec("Tab1");
        spec1.setIndicator("saludargentes");
        spec1.setContent(R.id.tab1);
        tabHost.addTab(spec1);

        btnSaludo = findViewById(R.id.btnSaludo);
        btnSaludo.setOnClickListener(v ->
                Toast.makeText(this, "odaaaaa", Toast.LENGTH_SHORT).show()
        );


        TabHost.TabSpec spec2 = tabHost.newTabSpec("Tab2");
        spec2.setIndicator("paises");
        spec2.setContent(R.id.tab2);
        tabHost.addTab(spec2);

        Spinner spinner = findViewById(R.id.spinnerPaises);
        String[] paises = {"México", "Argentina", "Brasil", "Chile", "España","Colombia", "Perú", "Uruguay", "Italia", "Japón"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, paises);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(PRINActivity.this,
                        "Seleccionaste: " + paises[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(android.widget.AdapterView<?> parent) {}
        });


        TabHost.TabSpec spec3 = tabHost.newTabSpec("Tab3");
        spec3.setIndicator("datos");
        spec3.setContent(R.id.tab3);
        tabHost.addTab(spec3);


        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.tab3, new DatosFragment())
                .commit();
    }
}

