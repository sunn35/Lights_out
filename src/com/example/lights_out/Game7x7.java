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

public class Game7x7 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		RelativeLayout fl = new RelativeLayout(this);

		int top=55;	
		int s=0;
		for (int j=0 ; j<7 ; j++ )
		{
			int left=10;	
		for (int i=0 ; i<7 ; i++)
		{
			Button button = new Button(this);
			RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(38,38);
			
			button.setBackgroundDrawable(new PaintDrawable(Color.YELLOW));
			
			params.setMargins(left,top,10,0);
			left = left+43;
			button.setId(s);
			//button.setText(""+s+"");
			
			button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {

				int myId=v.getId(); 
				if ((myId>=8 && myId<=12) || (myId>=15 && myId<=19) || (myId>=22 && myId<=26) || (myId>=29 && myId<=33) || (myId>=36 && myId<=40))
				{
					ToggleColor(myId,myId-1,myId+1,myId-7,myId+7);
				}else if(myId>=1 && myId<=5)
				{
					ToggleColor(myId,myId-1,myId+1,myId+7);
				}else if(myId>=43 && myId<=47){
					ToggleColor(myId,myId-1,myId+1,myId-7);
				}else if(myId>6 && myId<36 && myId%7==0)
				{
					ToggleColor(myId,myId-7,myId+7,myId+1);
				}else if(myId==13 || myId==20 || myId==27 || myId==34 || myId==41)
				{
					ToggleColor(myId,myId-7,myId+7,myId-1);
				}else if(myId==0)
				{
					ToggleColor(myId,myId+1,myId+7);
				}else if(myId==6)
				{
					ToggleColor(myId,myId-1,myId+7);
				}else if(myId==42)
				{
					ToggleColor(myId,myId+1,myId-7);
				}else
				{
					ToggleColor(myId,myId-1,myId-7);
				}
							checkVictory();
				}
				
			});
			s++;
			fl.addView(button,params);
		}
		top = top + 43;
		
		}
		setContentView(fl);
		Random no_off = new Random();
    	int off=no_off.nextInt(49-1);
    	for (int k=0 ; k < off ; k++ )
    	{
    	Random r = new Random();
    	int i1=r.nextInt(49-0);
    	
    	findViewById(i1).setBackgroundDrawable(new PaintDrawable(Color.BLACK));
	}}
	
	public void ToggleColor( int myId1 ,int myId2 , int myId3 ){
		int a[]={ myId1 , myId2 , myId3 };
				
		for (int i=0 ; i<3 ; i++ )
		{
			PaintDrawable drawable=(PaintDrawable)(findViewById(a[i])).getBackground();
				if (drawable.getPaint().getColor()==Color.YELLOW)
				{
					
					findViewById(a[i]).setBackgroundDrawable(new PaintDrawable(Color.BLACK));
				}
				else
				{
					findViewById(a[i]).setBackgroundDrawable(new PaintDrawable(Color.YELLOW));
				}
		}

			}
		public void ToggleColor( int myId1 ,int myId2 , int myId3 , int myId4 ){
		int a[]={ myId1 , myId2 , myId3 ,myId4};
				
		for (int i=0 ; i<4 ; i++ )
		{
			PaintDrawable drawable=(PaintDrawable)(findViewById(a[i])).getBackground();
				if (drawable.getPaint().getColor()==Color.YELLOW)
				{
					
					findViewById(a[i]).setBackgroundDrawable(new PaintDrawable(Color.BLACK));
				}
				else
				{
					findViewById(a[i]).setBackgroundDrawable(new PaintDrawable(Color.YELLOW));
				}
		}
		}
			
		public void ToggleColor( int myId1 ,int myId2 , int myId3 ,int myId4 , int myId5){
		int a[]={ myId1 , myId2 , myId3 ,myId4 , myId5};
				
		for (int i=0 ; i<5 ; i++ )
		{
			PaintDrawable drawable=(PaintDrawable)(findViewById(a[i])).getBackground();
				if (drawable.getPaint().getColor()==Color.YELLOW)
				{
					
					findViewById(a[i]).setBackgroundDrawable(new PaintDrawable(Color.BLACK));
				}
				else
				{
					findViewById(a[i]).setBackgroundDrawable(new PaintDrawable(Color.YELLOW));
				}
		}
		}

	
	public void checkVictory(){
		int a=0;
		for (int i=0 ; i<49 ; i++ )
		{
			PaintDrawable drawable=(PaintDrawable)(findViewById(i).getBackground());
			if( drawable.getPaint().getColor() == Color.BLACK)
			{
				a++;
			}
		}
		if ( a==49 )
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
