package xshadows.laboratorio_02_c;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.security.PrivateKey;
import java.security.interfaces.RSAMultiPrimePrivateCrtKey;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private android.widget.ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView =(ListView) findViewById(R.id.listView);

        //DATOS A MOSTRAS
        List<String> names= new ArrayList<String>();
        names.add("ANGEL");
        names.add("PEDRO");
        names.add("MARIA");
        names.add("MARTHA");
        names.add("THOMAS");

        //ADAPTADOR, FORMA VISUAL QUE SE MOSTRARAN NUESTROS  DATOS
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,names);

        //ENLAZAMOS EL ADAPTADOR CON NUESTRO LIST VIEW
        listView.setAdapter(adapter);
    }
}
