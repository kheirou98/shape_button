package com.example.shape_bouton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class file extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        EditText edtxt =findViewById(R.id.editText);
    }

    public void onclick(View view) {
        EditText edtxt =findViewById(R.id.editText);
        try {
            FileOutputStream fout =this.openFileOutput("abc.txt",this.MODE_PRIVATE);

            String txt =edtxt.getText().toString();
            byte b[]=txt.getBytes();
            fout.write(b);
            fout.close();
            edtxt.setText("Succès............");
        }catch(Exception exc ){
            edtxt.setText(exc.getMessage());
        }
    }

    public void buttonfile(View view) {
        EditText edtxt =findViewById(R.id.editText);
        try{
            FileInputStream fin =this.openFileInput("abc.txt");
            int i=0;
            String field="";
            while ((i=fin.read())!=-1){
                field+=String.valueOf((char) i);
            }
            fin.close();
            edtxt.setText(field);
        }
        catch(Exception exc){
            edtxt.setText(exc.getMessage());
        }
    }
}
