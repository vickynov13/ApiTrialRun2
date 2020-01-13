package my.app.apitrialrun2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    TextView resultview;
    Button submit;
    ProgressBar spinner;
    StringBuilder sb = new StringBuilder();
    InputStream caInput;
    String endpoint = "https://gulunodejs.myvnc.com:4050/api/user1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=(ProgressBar)findViewById(R.id.progressBar);
        resultview=(TextView)findViewById(R.id.textView2);
        submit=(Button)findViewById(R.id.button);
        spinner.setVisibility(View.GONE);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new getdetails().execute("");
            }
        });
    }
    private class getdetails extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            sb=CustomFunc1.getresponsebody(caInput,endpoint);
            return null;
        }
        @Override
        protected void onPostExecute(String result) {

            resultview.setText(sb);
            spinner.setVisibility(View.GONE);
        }
        @Override
        protected void onPreExecute() {
            try {
                caInput = getAssets().open("server.cert");
            } catch (IOException e) {
                e.printStackTrace();
            }
            spinner.setVisibility(View.VISIBLE);
        }
        @Override
        protected void onProgressUpdate(Void... values) {
        }
    }
}
