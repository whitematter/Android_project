package com.example.qnotes;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class edit extends Activity{
LoginMainActivity oo=new LoginMainActivity();
String t3=oo.u.toString();
String t;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
	
        final Spinner osp3=(Spinner)findViewById(R.id.spinner3);
        database oabc=new database(getApplicationContext(),"database1",null,1);
     final EditText otv=(EditText)findViewById(R.id.textView3);
      final Button obtnmodify=(Button)findViewById(R.id.butnmodify);  
        final ArrayAdapter a=new ArrayAdapter(edit.this, android.R.layout.simple_spinner_item);
        final SQLiteDatabase db=oabc.getWritableDatabase();
        Cursor c=db.rawQuery("select title from notes where user_name='"+t3+"'", null);
       if(c.moveToNext())
       {
    	 do
    	 {
    		 a.add(c.getString(0));
    	 }while(c.moveToNext());
       }
       else
       {
    	   Toast.makeText(getApplicationContext(),"title not found", 5000).show();
       }
 osp3.setAdapter(a);
osp3.setOnItemSelectedListener(new OnItemSelectedListener() {

	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		otv.setText("");
		t=a.getItem(osp3.getSelectedItemPosition()).toString();
		
		Cursor c=db.rawQuery("select detail from notes where title='"+t+"'", null);
		if(c.moveToNext())
		{
			otv.setText(c.getString(0));
		}
		
	}

	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
}) ;
obtnmodify.setOnClickListener(new OnClickListener() {	
	public void onClick(View v) {
		// TODO Auto-generated method stub
	
	 	db.execSQL("update notes set detail='"+otv.getText().toString()+"' where title='"+t+"'");
	 	db.acquireReference();
	 	Toast.makeText(getApplicationContext(), "note modified", 5000).show();
	 	Intent in=new Intent(getApplicationContext(),ChoiceMainActivity.class);
		startActivity(in);
		
		
	}
});
 
 
}
}

