package com.example.lights_out;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.PaintDrawable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Game extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		RelativeLayout fl = new RelativeLayout(this);

		int top=73;	
		int s=0;
		for (int j=0 ; j<3 ; j++ )
		{
			
			int left=12;
			
		for (int i=0 ; i<3 ; i++)
		{
			Button button = new Button(this);
			RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(95,95);
			
			button.setBackgroundDrawable(new PaintDrawable(Color.YELLOW));
			
			params.setMargins(left,top,10,0);
			left = left+100;
			button.setId(s);
			//button.setText(""+s+"");
			
	    	button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {

				int myId=v.getId(); 
				if (myId==0)
				{
				ToggleColor(myId);
				ToggleColor(myId+1);
				ToggleColor(myId+3);
				}else if(myId==1){
					ToggleColor(myId);
					ToggleColor(myId+1);
					ToggleColor(myId+3);
					ToggleColor(myId-1);
				}else if(myId==2){
					ToggleColor(myId);
					ToggleColor(myId-1);
					ToggleColor(myId+3);
				}else if(myId==3){
					ToggleColor(myId);
					ToggleColor(myId-3);
					ToggleColor(myId+3);
					ToggleColor(myId+1);
					
				}else if(myId==4){
					ToggleColor(myId);
					ToggleColor(myId+1);
					ToggleColor(myId+3);
					ToggleColor(myId-3);
					ToggleColor(myId-1);
				}else if (myId==5)
				{
				ToggleColor(myId);
				ToggleColor(myId-1);
				ToggleColor(myId-3);
				ToggleColor(myId+3);
				}else if(myId==6){
					ToggleColor(myId);
					ToggleColor(myId+1);
					ToggleColor(myId-3);
				}else if(myId==7){
					ToggleColor(myId);
					ToggleColor(myId-1);
					ToggleColor(myId+1);
					ToggleColor(myId-3);
				}else{
					ToggleColor(myId);
					ToggleColor(myId-1);
					ToggleColor(myId-3);
					
				}
				
				checkVictory();
				}
				
			});
			s++;
			fl.addView(button,params);
		}
		top = top + 100;
		
		}
		setContentView(fl);
		Random no_off = new Random();
    	int off=no_off.nextInt(9-0);
    	for (int k=0 ; k < off ; k++ )
    	{
    	Random r = new Random();
    	int i1=r.nextInt(9-0);
    	
    	findViewById(i1).setBackgroundDrawable(new PaintDrawable(Color.BLACK));
	}}
	

public void ToggleColor(int myId){
		
		PaintDrawable drawable =  (PaintDrawable) findViewById(myId).getBackground();
		if ( drawable.getPaint().getColor() == Color.YELLOW)
		{
			findViewById(myId).setBackgroundDrawable(new PaintDrawable(Color.BLACK));
		}else
		{
			findViewById(myId).setBackgroundDrawable(new PaintDrawable(Color.YELLOW));
		}
	}
	
	public void checkVictory(){
		int a=0;
		for (int i=0 ; i<9 ; i++ )
		{
			PaintDrawable drawable=(PaintDrawable)(findViewById(i).getBackground());
			if( drawable.getPaint().getColor() == Color.BLACK)
			{
				a++;
			}
		}
		if ( a==9 )
		{
			won();
		}
	}
		
	public void won(){
		AlertDialog victory = new AlertDialog.Builder(this).create();
		victory.setTitle("U Won");
		victory.setMessage("You Have won the game");
		victory.setButton("Okay", new DialogInterface.OnClickListener() {
		
			public void onClick(DialogInterface dialog, int which) {
				onBackPressed();
			
			}
		});
		victory.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
