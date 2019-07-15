# Ud3_Ejemplo4
_Ejemplo 4 de la Unidad 3._ 

Vamos a pasar datos entre Actividades creando _Intets_ explícitos con datos extras. Para ello vamos a basarnos en el proyecto [Ud3_Ejemplo3](https://github.com/Fpcarlosc/Ud3_Ejemplo3) y 
realizaremos los siguientes cambios (los demás ficheros no necesitarán cambios salvo el nombre del proyecto):

## _actividad1.xml_ y _actividad2.xml_
En este ejemplo los _TextViews_ de los _layouts_ de las actividades no tendrán texto asociado ya que será el que le pase la
actividad principal. Sí es necesario que tengan sus _ids_ para posteriormente buscarlos.

_actividad1.xml_:
```
<android.support.constraint.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:id="@+id/TextViewAct1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</android.support.constraint.ConstraintLayout>
```
_actividad2.xml_:
```
<android.support.constraint.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:id="@+id/TextViewAct2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</android.support.constraint.ConstraintLayout>
```
## _MainActivity.java_
En el fichero _MainActivity.java_ deberemos añadir los datos extra que los _Intents_ pasarán:
```
...
 // Asignamos un Click Listener sobre el TextView
        actividad1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAct1 = new Intent(MainActivity.this, Actividad1.class);
                // Añadimos los datos extra para pasárselos a la actividad
                intentAct1.putExtra(Intent.EXTRA_TEXT,"Texto Actividad 1");
                startActivity(intentAct1);
            }
        });
...
 // Asignamos un Click Listener sobre el TextView
        actividad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAct2 = new Intent(MainActivity.this, Actividad2.class);

                // Añadimos los datos extra para pasárselos a la actividad
                intentAct2.putExtra(Intent.EXTRA_TEXT,"Texto Actividad 2");
                startActivity(intentAct2);
            }
        });
...
```
## _Actividad1.java_ y _Actividad2.java_
El último cambio que debemos hacer es recoger los datos enviados por la actividad principal a las otras dos actividades.
Para ello debemos comprobar si el _Intent_ recibido tiene datos extras y si es así incluirlos en el _TextView_ del _layout_ 
asociado a la actividad.

_Actividad1.java_:
```
public class Actividad1 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad1);

        TextView texto = findViewById(R.id.TextViewAct1);

        // Si hay datos extra los mostramos.
        if (getIntent() != null && getIntent().hasExtra(Intent.EXTRA_TEXT)) {
            texto.setText(getIntent().getStringExtra(Intent.EXTRA_TEXT));
        }
    }
}
```
_Actividad2.java_:
```
public class Actividad2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad2);

        TextView texto = findViewById(R.id.TextViewAct2);

        // Si hay datos extra los mostramos.
        if (getIntent() != null && getIntent().hasExtra(Intent.EXTRA_TEXT)) {
            texto.setText(getIntent().getStringExtra(Intent.EXTRA_TEXT));
        }
    }
}
```
