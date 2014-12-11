package cn.edu.gdmec.s07131040.demo_asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {
	private ImageView imageView;
	private ProgressBar bar;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        bar = (ProgressBar) findViewById(R.id.progressBar);
    }
    
    public void doClick(View v){
    	MyAsyncTask asyncTask=new MyAsyncTask();
    	asyncTask.execute("http://www.kaikeba.com");
    }
    
    private class MyAsyncTask extends AsyncTask<String, Integer, Integer>{

		@Override
		protected Integer doInBackground(String... params) {
			// ��������Ŵ� 
			for(int i=0;i<100;i+=10){
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				publishProgress(i);
				
			}
			
			return R.drawable.ic_launcher;
		}
		
		@Override
		protected void onPostExecute(Integer result) {
			// �������֮����ʲô
			super.onPostExecute(result);
			imageView.setImageResource(result);
			
		}
		
		@Override
		protected void onPreExecute() {
			// ����֮ǰ
			Toast.makeText(MainActivity.this, "��ʼ���ء�����������", Toast.LENGTH_SHORT).show();
			
			super.onPreExecute();
		}
		
		@Override
		protected void onCancelled() {
			// ����ȡ��ʱ
			
			super.onCancelled();
			Log.i("INFO","onCancelled");
		}
		
		@Override
		protected void onProgressUpdate(Integer... values) {
			// ���ȸ���ʱ��ʲô,0ָ��i
			super.onProgressUpdate(values);
			bar.setProgress(values[0]);
		}
    	
    }

	
   
    
}
