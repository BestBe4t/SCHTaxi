package com.example.schtaxi;

import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private dbfunc db = new dbfunc();
    private dbobject user = new dbobject();
    private String url = "http://sch-hj.iptime.org:88/Taxi/";

    private List<dbobject> dbobjects;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(this.getIntent().getStringExtra("Name")==null) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(this.getIntent());
            user.setName(intent.getStringExtra("Name"));
            user.setPH(intent.getStringExtra("PH"));
            NetworkTask networkTask = new NetworkTask(url+db.SelUser(user), null);
            networkTask.execute();
        }
        layoutManager = new LinearLayoutManager(this);

        Button Station = findViewById(R.id.Station);
        Button School = findViewById(R.id.School);
        Button ETC = findViewById(R.id.ETC);
        Button info= findViewById(R.id.Info);

        Station.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StationActivity.class);
                intent.putExtra("Name", user.getName());
                intent.putExtra("PH", user.getPH());
                startActivity(intent);
            }
        });

        School.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SchoolActivity.class);
                intent.putExtra("Name", user.getName());
                intent.putExtra("PH", user.getPH());
                startActivity(intent);
            }
        });

        ETC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ETCActivity.class);
                intent.putExtra("Name", user.getName());
                intent.putExtra("PH", user.getPH());
                startActivity(intent);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                intent.putExtra("Name", user.getName());
                intent.putExtra("PH", user.getPH());
                startActivity(intent);
            }
        });
    }
    public class NetworkTask extends AsyncTask<Void, Void, String> {
        private String url;
        private ContentValues values;

        public NetworkTask(String url, ContentValues values) {

            this.url = url;
            this.values = values;
        }

        @Override
        protected String doInBackground(Void... params) {

            String result; // 요청 결과를 저장할 변수.
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject jsonObject = new JSONObject(s);
                if (Integer.parseInt(jsonObject.getString("is_party"))!=0){
                    TextView textView = findViewById(R.id.Is_party);
                    textView.setText("Joined party: "+jsonObject.getString("is_party"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.
        }
    }
}
