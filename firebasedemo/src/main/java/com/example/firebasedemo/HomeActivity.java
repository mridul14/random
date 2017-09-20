package com.example.firebasedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, ValueEventListener {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    return true;
                case R.id.navigation_dashboard:

                    return true;
                case R.id.logout:
                    FirebaseAuth.getInstance().signOut();//for logout

                    Intent intent=new Intent(HomeActivity.this,MainActivity.class);//sending to main page after logout

                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    startActivity(intent);

                    return true;
            }
            return false;
        }

    };
    private BottomNavigationView navigation;
    private EditText etQuote;
    private FloatingActionButton fabDone;
    private ProgressBar pbStatus;
    private DatabaseReference db;
    private ArrayList<QuoteModel> list;
    private RecyclerView rvList;
    private QuoteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        etQuote = (EditText) findViewById(R.id.etQuote);
        fabDone = (FloatingActionButton) findViewById(R.id.fabDone);
        pbStatus = (ProgressBar) findViewById(R.id.pbStatus);

        fabDone.setOnClickListener(this);


        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FirebaseDatabase fd=FirebaseDatabase.getInstance();

        db = fd.getReference("Quote");

        list = new ArrayList<>();
        //loading data
        db.addValueEventListener(this);

        //Recycler View code

        rvList = (RecyclerView) findViewById(R.id.rvList);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new QuoteAdapter(this,list);
        rvList.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        show();
        String userQuote=etQuote.getText().toString().trim();
        if(userQuote.isEmpty()){
            return;
        }

        addToFirebase(userQuote);

    }

    private void addToFirebase(String userQuote) {

        etQuote.setText("");//clears data in edit text

        //FirebaseDatabase


        FirebaseUser currentUser=FirebaseAuth.getInstance().getCurrentUser();
        String email=currentUser.getEmail();

        HashMap<String,Object>map=new HashMap<>();

        map.put("quote",userQuote);
        map.put("email",email);

        db.push().setValue(map, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                hide();

                if(databaseError==null){
                    Toast.makeText(HomeActivity.this,"Success",Toast.LENGTH_SHORT).show();

                }
                else {

                    Toast.makeText(HomeActivity.this,databaseError.getMessage(),Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    public void show(){
        pbStatus.setVisibility(View.GONE);
    }
    public void hide(){
        pbStatus.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

        if(dataSnapshot.hasChildren()){
            //remove pevious data
            //checks if we have data or not
            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                list.add(snapshot.getValue(QuoteModel.class));//telling the firebase to store the data in Quote Model

            }
                //update Recyclerview adapter

            adapter.notifyDataSetChanged();//refresh krega list ko

        }
        else {
            Toast.makeText(this, "no data yet", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

        if(databaseError!=null){
            Toast.makeText(this, "there was a error"+databaseError.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}
