package com.example.qnotes;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddMainActivity extends Activity {
LoginMainActivity ol=new LoginMainActivity();
String cu=ol.u.toString();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_main);
        final EditText otitle=(EditText)findViewById(R.id.etitle);
        final EditText odis=(EditText)findViewById(R.id.edis);
      final   Button osubButton=(Button)findViewById(R.id.subButton);
      database oabc=new database(getApplicationContext(),"database1",null,1);
      final SQLiteDatabase db=oabc.getWritableDatabase();
//        osubButton.setOnClickListener(new OnClickListener() {
        	 osubButton.setOnClickListener(new OnClickListener() {	
			public void onClick(View v) {
				// TODO Auto-generated method stub
			 
				String n=otitle.getText().toString();
				String u_n=odis.getText().toString();
				Cursor c1=db.rawQuery("select * from notes where title='"+n+"'", null);
				if(c1.moveToNext())
				{
					Toast.makeText(getApplicationContext(), "TITLE already existing",3000).show();
					otitle.setText("");
					odis.setText("");
				}
				else{
					
				
				db.execSQL("insert into notes values('"+cu+"','"+n+"','"+u_n+"')");	
				otitle.setText("");
				odis.setText("");
				Toast.makeText(getApplicationContext(), "note saved", 5000).show();
				}}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_add_main, menu);
        return true;
    }
}
