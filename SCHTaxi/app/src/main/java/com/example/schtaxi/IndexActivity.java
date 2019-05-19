package com.example.schtaxi;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;


public class IndexActivity extends Activity {
    private dbfunc db = new dbfunc();
    private dbobject user = new dbobject();
    private String url = "http://sch-hj.iptime.org:88/Taxi/";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        Intent intent = new Intent(this.getIntent());
        user.setName(intent.getStringExtra("Name"));
        user.setPH(intent.getStringExtra("PH"));
        user.set_IDX(intent.getIntExtra("IDX", 0));
        NetworkTask networkTask = new NetworkTask(url+db.SelIndex(null, null, user.get_IDX()), null);
        networkTask.execute();

        Button Submit = findViewById(R.id.Submit_bt);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText Chet = findViewById(R.id.Chat);
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
                JSONObject jsonObject = new JSONObject(s);                                          //이름, 번호, 목적지, 출발지, 탑승시간, 모집시간, 현재인원, 모집인원, 상태, 만든 시간, 채팅
                EditText Start = findViewById(R.id.Start);
                EditText Dest = findViewById(R.id.Dest);
                EditText Enter_T = findViewById(R.id.Enter_T);
                EditText Invi_T = findViewById(R.id.Invi_T);
                EditText Person = findViewById(R.id.Person);
                EditText State = findViewById(R.id.State);

                TextView Chet_b = findViewById(R.id.ChatBoard);
                TextView Title = findViewById(R.id.Title);

                Start.setFocusable(false);
                Start.setClickable(false);
                Dest.setFocusable(false);
                Dest.setClickable(false);
                Enter_T.setFocusable(false);
                Enter_T.setClickable(false);
                Invi_T.setFocusable(false);
                Invi_T.setClickable(false);
                Person.setFocusable(false);
                Person.setClickable(false);
                State.setFocusable(false);
                State.setClickable(false);

                Start.setText(jsonObject.getString("Start"));
                Dest.setText(jsonObject.getString("Dest"));
                Enter_T.setText(jsonObject.getString("Enter_Time"));
                Invi_T.setText(jsonObject.getString("Invi_Time"));
                Person.setText(jsonObject.getString("Now_P")+"/"+jsonObject.getString("Entire_P"));
                State.setText(jsonObject.getString("State"));
                Chet_b.setText(jsonObject.getString("Cheet"));
                Title.setText(jsonObject.getString("Name") + " " + jsonObject.getString("PH") + " " + jsonObject.getString("Create_Time"));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
