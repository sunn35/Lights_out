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

public class Game5x5 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		RelativeLayout fl = new RelativeLayout(this);

		int top=60;	
		int s=0;
		for (int j=0 ; j<5 ; j++ )
		{
			
			int left=12;
			
		for (int i=0 ; i<5 ; i++)
		{
			Button button = new Button(this);
			RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(55,55);
			
			button.setBackgroundDrawable(new PaintDrawable(Color.YELLOW));
			
			params.setMargins(left,top,10,0);
			left = left+60;
			button.setId(s);
			//button.setText(""+s+"");
			
			button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {

				int myId=v.getId(); 
				if ( myId>=1 && myId<=3 )
				{
					ToggleColor( myId ,myId-1 , myId+1 , myId+5);
				}else if ( (myId>=6 && myId<=8) || (myId>=11 && myId<=13) || (myId>=16 && myId<=18) ){
					ToggleColor( myId ,myId-1 ,myId+1 ,myId-5 ,myId+5 );
				}else if(myId>=21 && myId<=23 ){
					ToggleColor( myId ,myId-1 ,myId+1 ,myId-5);
				}else if ( myId==0 ){
					ToggleColor(myId , myId+1 , myId+5);
				}else if ( myId==4 ){
					ToggleColor(myId , myId-1 , myId+5);
				}else if ( myId==20 ){
					ToggleColor(myId , myId-5 , myId+1 );
				}else if (myId == 24){
					ToggleColor(myId , myId-5 , myId-1);
				}else if (myId==5 || myId==10 || myId==15){
					ToggleColor(myId , myId-5 , myId+5 , myId+1 );
				}else{
					ToggleColor(myId , myId-5 , myId+5 , myId-1);
				}
				checkVictory();
				}
				
			});
			s++;
			fl.addView(button,params);
		}
		top = top + 60;
		
		}
		setContentView(fl);
		Random no_off = new Random();
    	int off=no_off.nextInt(24-1);
    	for (int k=0 ; k < off ; k++ )
    	{
    	Random r = new Random();
    	int i1=r.nextInt(25-0);
    	
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
		for (int i=0 ; i<25 ; i++ )
		{
			PaintDrawable drawable=(PaintDrawable)(findViewById(i).getBackground());
			if( drawable.getPaint().getColor() == Color.BLACK)
			{
				a++;
			}
		}
		if ( a==25 )
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
