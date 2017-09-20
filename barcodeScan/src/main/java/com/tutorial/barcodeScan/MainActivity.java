package com.tutorial.barcodeScan;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */

	static final String SCAN = "com.google.zxing.client.android.SCAN";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	  public void ScanBar(View v){
		  
		    try{
		    	
		    	 Intent in = new Intent (SCAN);
		    	
		    	  in.putExtra("SCAN_MODE", "PRODUCT_MODE");
		    	  
		    	  startActivityForResult(in, 0);
		    	  
		    	  
		      }catch (ActivityNotFoundException e) {
				// TODO: handle exception
		    	  
showDialog(MainActivity.this, "No Scanner Found", "Download a scanner code activity?", "Yes", "No").show();
		    	  
		    	  
		    	  
			}
		 }
	  
	  
	   public void ScanQR(View v){
		  
		  
		  try{
			  
			  Intent in = new Intent (SCAN);
		    	
	    	  in.putExtra("SCAN_MODE", "QR_CODE_MODE");
	    	  
	    	  startActivityForResult(in, 0);
			   
			  
			  
			   }catch (ActivityNotFoundException e) {
				// TODO: handle exception
				   
	  showDialog(MainActivity.this, "No Scanner Found", "Download a scanner code activity?", "Yes", "No").show();	   
				   
				   
	       }
		  
		  
	 }
	  
	  
	  
	  
	  
	  
	private Dialog showDialog(final Activity act, CharSequence title,
			CharSequence message, CharSequence Yes,  CharSequence No) {
		// TODO Auto-generated method stub
		
		
		
		AlertDialog.Builder download = new AlertDialog.Builder(act);
		
		download.setTitle(title);
		
		download.setMessage(message);
		
		download.setPositiveButton(Yes, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int i){
				// TODO Auto-generated method stub
				
				
				
			Uri uri = Uri.parse("market://search?q=pname:" + "com.google.zxing.client.android");
				
			Intent in = new Intent(Intent.ACTION_VIEW, uri);	
			
			try{
				
				 act.startActivity(in);
				
				
			}catch(ActivityNotFoundException anfe){
				
				
				
			}
				
				
			}
		});
		
		
		
		download.setNegativeButton(No, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int i) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
	     return download.show();
	}
	
	
	
	

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent in) {
		// TODO Auto-generated method stub
	
		
		if(requestCode ==0){
			
			
		 if(resultCode == RESULT_OK){
			 
			 
			String contents = in.getStringExtra("SCAN_RESULT");
			 
			String format =  in.getStringExtra("SCAN_RESULT_FORMAT") ;
			
			
			Toast toast = Toast.makeText(this, "Content:" + contents + " Format:" + format, Toast.LENGTH_LONG);
			
			
			toast.show();
			 
		 }
			
			
		
		
     }
	
	
   }

}
