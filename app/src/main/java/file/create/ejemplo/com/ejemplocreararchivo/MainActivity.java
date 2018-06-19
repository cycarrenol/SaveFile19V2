package file.create.ejemplo.com.ejemplocreararchivo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    Button create, read;

    TextView text, text2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        create = (Button) findViewById(R.id.create);// asigno a la variable create (de tipo botton) al elemento Button del layout
        read   = (Button) findViewById(R.id.read);
        text = (TextView) findViewById(R.id.texto);// tenga presente que lo que está después del  R.id es el id del elemento del layout
        text2 = (TextView) findViewById(R.id.texto2);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 String fileName = "MyFile.txt";
                 String content = "Este es el contenido del mensaje";




                FileOutputStream fileOutputStream = null;

                try {
                    fileOutputStream = openFileOutput(fileName,Context.MODE_PRIVATE);
                    fileOutputStream.write(content.getBytes());

                    Context context = getApplicationContext();

                    String folder = context.getFilesDir().getAbsolutePath();
                    text2.setText(folder);

                    fileOutputStream.close();
                } catch ( Exception e) {// Con exception  se maneja cualquier excepción
                    e.printStackTrace();
                }
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
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

                    text.setText(stringBuilder.toString());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }catch (UnsupportedEncodingException e){

                }catch (IOException e){

                }

            }
        });


    }
}
