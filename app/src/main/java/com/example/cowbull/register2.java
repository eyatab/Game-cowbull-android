package com.example.cowbull;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
public class register2  extends AppCompatActivity {

    EditText t1,t2,t3;
    Button reg;
    public String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "Register";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multijoueur);


        reg = (Button) findViewById(R.id.register);
        t1= (EditText) findViewById(R.id.tx1);
        t2= (EditText) findViewById(R.id.tx2);
        t3= (EditText) findViewById(R.id.tx3);
        File dir = new File(path);
        dir.mkdirs();
        File dir2 = new File(path);
        dir2.mkdirs();
        File dir3 = new File(path);
        dir3.mkdirs();


    }
    public void buttonregister (View view)
    {
        File file = new File (path + "/nom.txt");
        String [] savenom = String.valueOf(t1.getText()).split(System.getProperty("line.separator"));
        t1.setText("");

        Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
        Save (file,savenom);

        File file2 = new File (path + "/email.txt");
        String [] saveemail = String.valueOf(t1.getText()).split(System.getProperty("line.separator"));
        t2.setText("");

        Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
        Save (file2,saveemail);


        File file3 = new File (path + "/password.txt");
        String [] savepass = String.valueOf(t1.getText()).split(System.getProperty("line.separator"));
        t3.setText("");

        Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
        Save (file3,savepass);
    }

    public static void Save(File file, String[] data)
    {
        FileOutputStream fos = null;
        try
        {
            fos = new FileOutputStream(file);
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        try
        {
            try
            {
                for (int i = 0; i<data.length; i++)
                {
                    fos.write(data[i].getBytes());
                    if (i < data.length-1)
                    {
                        fos.write("\n".getBytes());
                    }
                }
            }
            catch (IOException e) {e.printStackTrace();}
        }
        finally
        {
            try
            {
                fos.close();
            }
            catch (IOException e) {e.printStackTrace();}
        }
    }
}
