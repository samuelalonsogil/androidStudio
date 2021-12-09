package com.sbdiaz.listbiew;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    ArrayList<Nombres> nombres;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        nombres = new ArrayList<Nombres>();

        nombres.add(new Nombres("Albacete", "Albacete", R.drawable.albacete));
        nombres.add(new Nombres("Madrid", "La capital", R.drawable.albacete));

        MyAdapter adapter = new MyAdapter(this, R.layout.row, nombres);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               TextView textView = findViewById(R.id.seleccion) ;
               textView.setText("Has pulsado: " + nombres.get(position).getName());
            }
        });
    }

    /** @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Array de elementos a introducir en las listas
        String[] elementos = {"Toledo", "Ciudad Real", "Cuenca", "Guadalajara", "Albacete"};
        // Adaptador de texto
        ArrayAdapter<String> adaptador;
        // Llamamos a super
        super.onCreate(savedInstanceState);
        // Ponemos el activity main
        setContentView(R.layout.activity_main);
        // Instanciamos una list view (en referencia a los resources)
        ListView l = (ListView) findViewById(R.id.listView);
        // Le decimos que va a ser de seleccion multiple
        l.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        // Creamos el adaptador (usamos el layout de android de simple list item multiple choice
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, elementos);
        // Le decimos a la list view que establezca el adapter
        l.setAdapter(adaptador);
        // Le ponemos el listener a la list view (que en este caso es nuestra propia clase)
        l.setOnItemClickListener(this);
    }**/

    /**@Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Decleramos un textview que obtenemos desde los resources
        TextView t = (TextView) findViewById(R.id.textView);
        // Declaramos una listview que obtenemos desde los resources
        ListView l = (ListView) findViewById(R.id.listView);
        // Declaramos un string donde almacenaremos los los items que vamos a seleccionar
        String seleccionado = "";
        // Declaramos un array de booleanos al que le asignaremos los booleanos del list view
        SparseBooleanArray checked = l.getCheckedItemPositions();
        // Iteraremos a traves de este array de booleanos
        for (int i = 0; i < checked.size(); i++)
            // Si es true el valor que hemos puesto ( es decir esta seleccionado )
            if (checked.valueAt(i)) {
                // A seleccionado le añadimos el valor de el item que esta a true
                seleccionado = seleccionado +
                        parent.getItemAtPosition(checked.keyAt(i)).toString()
                        + ";";
            }
        // Y por el ultimo al textview le asignamos la string que hemos seleccionado
        t.setText(seleccionado);
    }**/
}