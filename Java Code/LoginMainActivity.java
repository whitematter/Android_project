package com.example.qnotes;





import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginMainActivity extends Activity {
public static String u;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        
        database obj=new database(getApplicationContext(), "database1", null,1);
        final SQLiteDatabase db=obj.getWritableDatabase();
        
        final EditText oet1=(EditText)findViewById(R.id.et1);
        final EditText oet2=(EditText)findViewById(R.id.et2);
        final Button obtn=(Button)findViewById(R.id.btn);
        final Button obtn1=(Button)findViewById(R.id.btn1);
        final Button obtn3=(Button)findViewById(R.id.btn2);
        final TextView otvuser=(TextView)findViewById(R.id.tvuser);
        final TextView otvpass=(TextView)findViewById(R.id.tvpass);
        
        obtn1.setOnClickListener(new View.OnClickListener() {
			
			
			public void onClick(View v) {
				Intent in=new Intent(getApplicationContext(),SignUpMainActivity.class);
				startActivity(in);
			}});
        
        obtn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				 u=oet1.getText().toString();
				String p=oet2.getText().toString();
				
				Cursor c=db.rawQuery("select password from user where user_name='"+u+"'",null);
				if(c.moveToNext())
				{
					if(p.equals(c.getString(0)))
					{
						Intent in=new Intent(getApplicationContext(), ChoiceMainActivity.class);
						startActivity(in);
						finish();
					}
					else
					{
						Toast.makeText(getApplicationContext(),"wrong password or username", 3000).show();
						oet1.setText("");
						oet2.setText("");
						
					}
				}
				else
				{
					Toast.makeText(getApplicationContext(),"wrong username", 3000).show();
				}
				
			}
		});
        obtn3.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
			finish();	
			}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_login_main, menu);
        return true;
    }
}
