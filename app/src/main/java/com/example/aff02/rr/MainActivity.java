package com.example.aff02.rr;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtID,edtName;
    private Button btnSave,btnSelect,btnUpdate,btnclear;
    private TextView txtID,txtName;
    private SharedPreferences sharedPref;
    private String preffilename = "MYPREFS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("SharedPreferences");

        init();
        setListener();

    }

    private void init() {

        edtID = (EditText)findViewById(R.id.ID);
        edtName = (EditText)findViewById(R.id.name);
        btnSave = (Button)findViewById(R.id.btnsave);
        btnSelect = (Button)findViewById(R.id.btnselect);
        btnUpdate = (Button)findViewById(R.id.btnupdate);
        btnclear = (Button)findViewById(R.id.btnclear);
        txtID = (TextView)findViewById(R.id.txtID);
        txtName =(TextView)findViewById(R.id.txtName);

    }

    private void setListener() {

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sharedPref = getSharedPreferences(preffilename,0);
                SharedPreferences.Editor editor = sharedPref.edit();

                editor.putInt("ID",Integer.parseInt(edtID.getText().toString()));
                editor.putString("Name",edtName.getText().toString());
                editor.commit();
                editor.clear();
                edtID.setText("");
                edtName.setText("");


                Toast.makeText(getApplicationContext(),"Data Saved Successfully",Toast.LENGTH_LONG).show();
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sharedPref = getSharedPreferences(preffilename,0);

                int textID = sharedPref.getInt("ID",0);
                txtID.setText(String.valueOf(textID));

                String textName = sharedPref.getString("Name","");
                txtName.setText(textName);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sharedPref = getSharedPreferences(preffilename,0);

                SharedPreferences.Editor editor_update = sharedPref.edit();

                editor_update.putInt("ID",Integer.parseInt(edtID.getText().toString()));
                editor_update.putString("Name",edtName.getText().toString());
                editor_update.commit();

                Toast.makeText(getApplicationContext(),"Updated Data Successfully",Toast.LENGTH_LONG).show();

                int ID = sharedPref.getInt("Id",Integer.parseInt(edtID.getText().toString()));
                txtID.setText(String.valueOf(ID));

                String name = sharedPref.getString("Name","");
                txtName.setText(name);
            }
        });

        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sharedPref = getSharedPreferences(preffilename,0);
                SharedPreferences.Editor editor_clear = sharedPref.edit();

                editor_clear.clear();
                editor_clear.commit();
                edtID.setText("");
                edtName.setText("");

            }
        });




    }


}
