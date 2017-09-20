package com.example.menus_and_preferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
 
public class MainActivity extends AppCompatActivity {

    private TextView tvname;
    private EditText etname;
    private Toolbar toolbar;
    private SharedPreferences
            app_pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvname = (TextView) findViewById(R.id.tvname);
        etname = (EditText) findViewById(R.id.etname);
        setSupportActionBar(toolbar);
       app_pref= getSharedPreferences("app_pref",MODE_PRIVATE);//creating bject of shared preference through method,checking if app_pref file is present if not then it is created

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //add to preferences when that pink button is clicked
                SharedPreferences.Editor editor=app_pref.edit();//adding data to shared preference,app_pref.edit() is maing the file editable
                editor.putString("name_key",etname.getText().toString().trim());//saving the text with name_key
                editor.apply();//to save the file
                etname.setVisibility(View.GONE);//hiding the text box
            }
        });
        //read stuff from preferences when activity is opened
        String name=app_pref.getString("name_key","Hello user,name daalo yar");//checking if there is some data of the user saved with name_key,if not then print the default value give in"".
        tvname.setText(name);
        //hide stuff from preferences when preference value is loaded
        if(!name.contains("Hello")){
            etname.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                doSomething();
                return true;
            case R.id.action_1:
                doAction1();
                return true;
            case R.id.action_2:
                doAction2();
                return true;
            case R.id.action_3:
                doAction3();
                return true;
            case R.id.action_4:
                doAction4();
                return true;
            case R.id.action_5:
                doAction5();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void doAction5() {
        Toast.makeText(this, "this is action 5", Toast.LENGTH_SHORT).show();

    }

    private void doAction4() {
        Toast.makeText(this, "this is action 4", Toast.LENGTH_SHORT).show();
    }

    private void doAction3() {
        Toast.makeText(this, "this is action 3", Toast.LENGTH_SHORT).show();
    }

    private void doAction2() {
        Toast.makeText(this, "this is action 2", Toast.LENGTH_SHORT).show();
    }

    private void doAction1() {
        Toast.makeText(this, "this is action 1", Toast.LENGTH_SHORT).show();
    }

    private void doSomething() {
        Toast.makeText(this, "this is nothing", Toast.LENGTH_SHORT).show();
    }
}
