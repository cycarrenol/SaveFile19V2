package file.create.ejemplo.com.ejemplocreararchivo;

import android.content.Context;
import android.graphics.Color;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.Buffer;

public class MainActivity extends AppCompatActivity {

    Button create;

    TextView textTXT;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        create = (Button) findViewById(R.id.create);// asigno a la variable create (de tipo botton) al elemento Button del layout

        textTXT = (TextView) findViewById(R.id.textoTXT);// /Contenido del  archivo/ tenga presente que lo que está después del  R.id es el id del elemento del layout
       // textRuta = (TextView) findViewById(R.id.textoRUTA);// muestra la ruta de almacenamiento del archivo


        create.setOnClickListener(new View.OnClickListener() {// METODO PARA CREAR EL ARCHIVO EN UNA CARPETA
            @Override
            public void onClick(View view) {

                String archivo ="Miarchivo.txt";
                create.setBackgroundColor(Color.GREEN);

                FileOutputStream fileOutputStream = null;

                File myDirectoty1 =  new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"Carpeta_resistividades");

                myDirectoty1.mkdir();
                File file = new File(myDirectoty1, archivo);

                Context context = getApplicationContext();

                String ruta = myDirectoty1.getAbsolutePath();
              //  textRuta.setText(ruta);// Imprime la ruta del almacenamiento  del archivo


                try {

                    FileOutputStream os = fileOutputStream = new FileOutputStream(file);
                    String data ="This is the Great text,This is the Great text,This is the Great text,This is the Great text,This is the Great text,This is the Great text";
                    textTXT.setText(data);
                    os.write(data.getBytes());
                    os.close();
                } catch ( Exception e) {// Con exception  se maneja cualquier excepción
                    e.printStackTrace();
                }
            }
        });







        /*
        read.setOnClickListener(new View.OnClickListener() {//Mostrar lo que tiene el archivo

            @Override
            public void onClick(View view) {
                try {
                    FileInputStream fileInputStream = getApplicationContext().openFileInput("MyFile.txt");
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;

                    while ((line = bufferedReader.readLine()) != null){
                        stringBuilder.append(line).append("\n");
                    }

                    textTXT.setText(stringBuilder.toString());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }catch (UnsupportedEncodingException e){

                }catch (IOException e){

                }

            }
        });
        */



    }
}