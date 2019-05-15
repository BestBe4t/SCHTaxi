package com.example.schtaxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import android.content.ContentValues;
import android.os.AsyncTask;


public class MainActivity extends AppCompatActivity {

    private dbfunc db = new dbfunc();
    private dbobject thing = new dbobject();
    private String url = "http://sch-hj.iptime.org:88/Taxi/";
    private List<dbobject> dbobjects;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutManager = new LinearLayoutManager(this);

        Button sel = findViewById(R.id.sel);
        Button del = findViewById(R.id.del);
        Button insert = findViewById(R.id.insert);
        Button update = findViewById(R.id.update);
        final TextView TeV = findViewById(R.id.Text11);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thing.setName("Test123");
                thing.setPH("TestPH");
                NetworkTask networkTask = new NetworkTask(url+db.AddUser(thing), null);
                networkTask.execute();
            }
        });

        sel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thing.setName("Test123");
                thing.setPH("TestPH");
                thing.setis_party(0);
                thing.setDest("Home");
                NetworkTask networkTask = new NetworkTask(url+db.SelUser(thing, null), null);
                networkTask.execute();
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thing.setName("Test123");
                thing.setPH("TestPH");
                thing.setis_party(0);
                thing.setDest("Home");
                NetworkTask networkTask = new NetworkTask(url+db.SelUser(thing, null), null);
                networkTask.execute();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thing.setName("Test123");
                thing.setPH("TestPH");
                thing.setis_party(0);
                thing.setDest("Home");
                NetworkTask networkTask = new NetworkTask(url+db.Update(thing, null, "Name", "Test111"), null);
                networkTask.execute();
            }
        });
    }

    public class NetworkTask extends AsyncTask<Void, Void, String>{
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

            TextView Tev = findViewById(R.id.Text11);
            Tev.setText(s);
            //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.
        }
    }
}
