package org.ucb.promessas;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.TextView;

import com.parse.ParseAnalytics;

public class MainActivity extends Activity implements OnGestureListener,
													  OnDoubleTapListener{
	
	private static final String DEBUG_TAG = "Gestures";
    private GestureDetectorCompat mDetector; 
    private GestureDetector gestureScanner;
    private TextView mPromisseText;
    
    
	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		mPromisseText = (TextView) findViewById(R.id.promisse);
		
		String[] versus = {"E eis que venho sem demora, e comigo está o galardão que tenho para retribuir a cada um segundo as suas obras. Eu sou o Alfa e o Ômega, o Primeiro e o Último, o Princípio e o Fim.",
						   "Não temas as coisas que tens de sofrer. ... Sê fiel até à morte, e dar-te-ei a coroa da vida.",
						   "E ali nunca mais haverá maldição",
						   "Eis que estou à porta, e bato; se alguém ouvir a minha voz, e abrir a porta, entrarei em sua casa, e com ele cearei, e ele comigo.",
						   "Eis que venho sem demora; guarda o que tens, para que ninguém tome a tua coroa.",
						   "Como guardaste a palavra da minha paciência, também eu te guardarei da hora da tentação,"};

		ParseAnalytics.trackAppOpenedInBackground(getIntent());
		
//		 mDetector = new GestureDetectorCompat(this,this);
		gestureScanner = new GestureDetector(getApplicationContext(), this);
		 
		
		//Trazer todas as promessas para o banco interno do ANDROID
		
//		ParseQuery<ParseObject> query = ParseQuery.getQuery("Promisses");
//		query.getInBackground("M2st0N1V7V", new GetCallback<ParseObject>() {
//		  public void done(ParseObject object, ParseException e) {
//		    if (e == null) {
//		    	object.pinInBackground();
//		      Log.d("Parse", object.getString("text"));
//		    } else {
//		      // something went wrong
//		    }
//		  }
//		});
		

		 //		mPromisseText.setTouchDelegate(new TouchDelegate(bounds, delegateView))
//		mPromisseText.setOnTouchListener(new OnTouchListener() {
//			
//			@Override
//			public boolean onTouch(View v, MotionEvent event) {
//				// TODO Auto-generated method stub
//				if(event.getAction() == MotionEvent.ACTION_UP){
//
//					Toast.makeText(getApplicationContext(), "Para Cima", Toast.LENGTH_SHORT).show();
//		            // Do what you want
//		            return true;
//		        }
//				
//				if(event.getAction() == MotionEvent.ACTION_DOWN){
//					Toast.makeText(getApplicationContext(), "Down Event", Toast.LENGTH_SHORT).show();
//					mDetector.onTouchEvent(event);
//		            // Do what you want
//		            return true;
//		        }
//				return false;
//			}
//		});
		
	}
	
//	  @Override 
//	    public boolean onTouchEvent(MotionEvent event){ 
//	        this.mDetector.onTouchEvent(event);
//	        // Be sure to call the superclass implementation
//	        return super.onTouchEvent(event);
//	    }
//
//	    @Override
//	    public boolean onDown(MotionEvent event) { 
//	        Log.d(DEBUG_TAG,"onDown: " + event.toString()); 
//	        Toast.makeText(getApplicationContext(), "onDown:", Toast.LENGTH_SHORT).show();
//	        return true;
//	    }
//
//	    @Override
//	    public boolean onFling(MotionEvent event1, MotionEvent event2, 
//	            float velocityX, float velocityY) {
//	        Log.d(DEBUG_TAG, "onFling: " + event1.toString()+event2.toString());
//	        Toast.makeText(getApplicationContext(), "onFling", Toast.LENGTH_SHORT).show();
//	        return true;
//	    }
//
//	    @Override
//	    public void onLongPress(MotionEvent event) {
//	        Log.d(DEBUG_TAG, "onLongPress: " + event.toString()); 
//	        Toast.makeText(getApplicationContext(), "onLongPress", Toast.LENGTH_SHORT).show();
//	    }
//
//	    @Override
//	    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
//	            float distanceY) {
//	        Log.d(DEBUG_TAG, "onScroll: " + e1.toString()+e2.toString());
//	        Toast.makeText(getApplicationContext(), "onScroll", Toast.LENGTH_SHORT).show();
//	        return true;
//	    }
//
//	    @Override
//	    public void onShowPress(MotionEvent event) {
//	        Log.d(DEBUG_TAG, "onShowPress: " + event.toString());
//	        Toast.makeText(getApplicationContext(), "onShowPress", Toast.LENGTH_SHORT).show();
//	    }
//
//	    @Override
//	    public boolean onSingleTapUp(MotionEvent event) {
//	        Log.d(DEBUG_TAG, "onSingleTapUp: " + event.toString());
//	        Toast.makeText(getApplicationContext(), "onSingleTapUp", Toast.LENGTH_SHORT).show();
//	        return true;
//	    }
//
//	    @Override
//	    public boolean onDoubleTap(MotionEvent event) {
//	        Log.d(DEBUG_TAG, "onDoubleTap: " + event.toString());
//	        Toast.makeText(getApplicationContext(), "onDoubleTap" , Toast.LENGTH_SHORT).show();
//	        return true;
//	    }
//
//	    @Override
//	    public boolean onDoubleTapEvent(MotionEvent event) {
//	        Log.d(DEBUG_TAG, "onDoubleTapEvent: " + event.toString());
//	        Toast.makeText(getApplicationContext(), "onDoubleTapEvent", Toast.LENGTH_SHORT).show();
//	        return true;
//	    }
//
//	    @Override
//	    public boolean onSingleTapConfirmed(MotionEvent event) {
//	        Log.d(DEBUG_TAG, "onSingleTapConfirmed: " + event.toString());
//	        Toast.makeText(getApplicationContext(), "onSingleTapConfirmed", Toast.LENGTH_SHORT).show();
//	        return true;
//	    }
	
	@Override
    public boolean onTouchEvent(MotionEvent me) {
        return gestureScanner.onTouchEvent(me);
    }
   
    @Override
    public boolean onDown(MotionEvent e) {
    	mPromisseText.setText("-" + "DOWN" + "-");
        return true;
    }
   
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
    	mPromisseText.setText("-" + "FLING" + "-");
        return true;
    }
   
    @Override
    public void onLongPress(MotionEvent e) {
    	mPromisseText.setText("-" + "LONG PRESS" + "-");
    }
   
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
    	mPromisseText.setText("-" + "SCROLL" + "-");
        return true;
    }
   
    @Override
    public void onShowPress(MotionEvent e) {
    	mPromisseText.setText("-" + "SHOW PRESS" + "-");
    }    
   
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
    	mPromisseText.setText("-" + "SINGLE TAP UP" + "-");
        return true;
    }

	@Override
	public boolean onSingleTapConfirmed(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onDoubleTap(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onDoubleTapEvent(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}
}
