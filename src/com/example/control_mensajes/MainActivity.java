package com.example.control_mensajes;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnTouchListener {

	TextView tvWeb, tvCreador, tvApp;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tvWeb 		= (TextView) findViewById(R.id.tvWeb);
        tvCreador 	= (TextView) findViewById(R.id.tvCreador);
        tvApp 		= (TextView) findViewById(R.id.tvApp);
        
        //Listen
        tvWeb.setOnTouchListener(this);
        tvCreador.setOnTouchListener(this);
        tvApp.setOnTouchListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

	@Override
	public boolean onTouch(View v, MotionEvent event)
	{
		switch (v.getId()) 
		{
		case R.id.tvWeb:
			//Mensajes Emergentes para el usuario
			Toast t = Toast.makeText(this, "Visitanos en www.notnull.cl", Toast.LENGTH_LONG);
			t.show();
			break;
		case R.id.tvCreador:
			//Otro tipos de mensajes
			Dialog d = new Dialog(this);
			//Set el Título
			d.setTitle("Valóranos");
			//Muestra una nueva ventana (Activity)
			d.setContentView(R.layout.mensaje);
			
			d.show();
			
			break;
		case R.id.tvApp:
			tvApp.setText("Ahora te gusta nuestra App");
			tvApp.setTextColor(Color.BLUE);
			break;
		default:
			break;
		}
		return true;
	}
}
