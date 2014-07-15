package com.example.qnotes;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ChoiceMainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_main);
        final ImageButton obtn=(ImageButton)findViewById(R.id.btnadd);
        final ImageButton obtnview=(ImageButton)findViewById(R.id.btnview);
        final ImageButton obtnedit=(ImageButton)findViewById(R.id.btnedit);
        final ImageButton obtndel=(ImageButton)findViewById(R.id.btndel);
        final Button signout=(Button)findViewById(R.id.btnsnout);
        obtn.setOnClickListener(new View.OnClickListener() {
        			
        			public void onClick(View v) {
        				Intent in=new Intent(getApplicationContext(),AddMainActivity.class);
        				startActivity(in);
        			}});
        obtndel.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent in=new Intent(getApplicationContext(),delete.class);
				startActivity(in);
			}});
        
        obtnedit.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent in=new Intent(getApplicationContext(),edit.class);
				startActivity(in);
			}});

 obtnview.setOnClickListener(new View.OnClickListener() {
			
			
			public void onClick(View v) {
				Intent in=new Intent(getApplicationContext(),view_main.class);
				startActivity(in);
			}});

       signout.setOnClickListener(new View.OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
		Intent login=new Intent(getApplicationContext(), LoginMainActivity.class);
		startActivity(login);
		finish();
		}
	});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_choice_main, menu);
        return true;
    }
}
