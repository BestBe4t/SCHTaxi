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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SchoolActivity extends Activity {
    private dbfunc db = new dbfunc();
    private dbobject user = new dbobject();
    private static String url = "http://sch-hj.iptime.org:88/Taxi/";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);

        final Intent intent = new Intent(this.getIntent());
        user.setName(intent.getStringExtra("Name"));
        user.setPH(intent.getStringExtra("PH"));
        if(intent.getStringExtra("Search")!="o") {
            NetworkTask networkTask = new NetworkTask(url + db.SelIndex("Station", null, 0), null);
            networkTask.execute();
        }

        Button Create = findViewById(R.id.Insert_P);
        Button Search_bt = findViewById(R.id.Search_bt);
        final EditText Search = findViewById(R.id.Search_Text);

        Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(SchoolActivity.this, CreateActivity.class);
                intent1.putExtra("Name", user.getName());
                intent1.putExtra("PH", user.getPH());
                intent1.putExtra("Table_name", "Station");
                startActivity(intent1);
            }
        });
        Search_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Dest= Search.getText().toString();
                Intent intent1 = new Intent(SchoolActivity.this, SchoolActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra("Search", "o");
                NetworkTask networkTask = new NetworkTask(url+db.SelIndex("Station", Dest, 0), null);
                networkTask.execute();
                startActivity(intent);
            }
        });
        TextView index1 = findViewById(R.id.Board_1_Title);
        TextView index2 = findViewById(R.id.Board_2_Title);
        TextView index3 = findViewById(R.id.Board_3_Title);
        TextView index4 = findViewById(R.id.Board_4_Title);
        TextView index5 = findViewById(R.id.Board_5_Title);
        TextView index6 = findViewById(R.id.Board_6_Title);
        TextView index7 = findViewById(R.id.Board_7_Title);
        TextView index8 = findViewById(R.id.Board_8_Title);
        TextView index9 = findViewById(R.id.Board_9_Title);

        index1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.set_IDX(1);
                Intent intent1 = new Intent(SchoolActivity.this, IndexActivity.class);
                intent1.putExtra("Name", user.getName());
                intent1.putExtra("PH", user.getPH());
                intent1.putExtra("is_party", user.getis_party());
                intent1.putExtra("IDX", user.get_IDX());
                startActivity(intent1);
            }
        });
        index2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.set_IDX(1);
                Intent intent1 = new Intent(SchoolActivity.this, IndexActivity.class);
                intent1.putExtra("Name", user.getName());
                intent1.putExtra("PH", user.getPH());
                intent1.putExtra("is_party", user.getis_party());
                intent1.putExtra("IDX", user.get_IDX());
                startActivity(intent1);
            }
        });
        index3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.set_IDX(1);
                Intent intent1 = new Intent(SchoolActivity.this, IndexActivity.class);
                intent1.putExtra("Name", user.getName());
                intent1.putExtra("PH", user.getPH());
                intent1.putExtra("is_party", user.getis_party());
                intent1.putExtra("IDX", user.get_IDX());
                startActivity(intent1);
            }
        });
        index4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.set_IDX(1);
                Intent intent1 = new Intent(SchoolActivity.this, IndexActivity.class);
                intent1.putExtra("Name", user.getName());
                intent1.putExtra("PH", user.getPH());
                intent1.putExtra("is_party", user.getis_party());
                intent1.putExtra("IDX", user.get_IDX());
                startActivity(intent1);
            }
        });
        index5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.set_IDX(1);
                Intent intent1 = new Intent(SchoolActivity.this, IndexActivity.class);
                intent1.putExtra("Name", user.getName());
                intent1.putExtra("PH", user.getPH());
                intent1.putExtra("is_party", user.getis_party());
                intent1.putExtra("IDX", user.get_IDX());
                startActivity(intent1);
            }
        });
        index6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.set_IDX(1);
                Intent intent1 = new Intent(SchoolActivity.this, IndexActivity.class);
                intent1.putExtra("Name", user.getName());
                intent1.putExtra("PH", user.getPH());
                intent1.putExtra("is_party", user.getis_party());
                intent1.putExtra("IDX", user.get_IDX());
                startActivity(intent1);
            }
        });
        index7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.set_IDX(1);
                Intent intent1 = new Intent(SchoolActivity.this, IndexActivity.class);
                intent1.putExtra("Name", user.getName());
                intent1.putExtra("PH", user.getPH());
                intent1.putExtra("is_party", user.getis_party());
                intent1.putExtra("IDX", user.get_IDX());
                startActivity(intent1);
            }
        });
        index8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.set_IDX(1);
                Intent intent1 = new Intent(SchoolActivity.this, IndexActivity.class);
                intent1.putExtra("Name", user.getName());
                intent1.putExtra("PH", user.getPH());
                intent1.putExtra("is_party", user.getis_party());
                intent1.putExtra("IDX", user.get_IDX());
                startActivity(intent1);
            }
        });
        index9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.set_IDX(1);
                Intent intent1 = new Intent(SchoolActivity.this, IndexActivity.class);
                intent1.putExtra("Name", user.getName());
                intent1.putExtra("PH", user.getPH());
                intent1.putExtra("is_party", user.getis_party());
                intent1.putExtra("IDX", user.get_IDX());
                startActivity(intent1);
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
                JSONArray arr = new JSONArray(s);
                TextView textView1;
                TextView textView2;
                for(int i=0;i<arr.length();i++){
                    JSONObject json = arr.getJSONObject(i);
                    switch (i+1){
                        case 1:
                            textView1 = findViewById(R.id.Board_1_Title);
                            textView2 = findViewById(R.id.Board_1_NB);
                            break;
                        case 2:
                            textView1 = findViewById(R.id.Board_2_Title);
                            textView2 = findViewById(R.id.Board_2_NB);
                            break;
                        case 3:
                            textView1 = findViewById(R.id.Board_3_Title);
                            textView2 = findViewById(R.id.Board_3_NB);
                            break;
                        case 4:
                            textView1 = findViewById(R.id.Board_4_Title);
                            textView2 = findViewById(R.id.Board_4_NB);
                            break;
                        case 5:
                            textView1 = findViewById(R.id.Board_5_Title);
                            textView2 = findViewById(R.id.Board_5_NB);
                            break;
                        case 6:
                            textView1 = findViewById(R.id.Board_6_Title);
                            textView2 = findViewById(R.id.Board_6_NB);
                            break;
                        case 7:
                            textView1 = findViewById(R.id.Board_7_Title);
                            textView2 = findViewById(R.id.Board_7_NB);
                            break;
                        case 8:
                            textView1 = findViewById(R.id.Board_8_Title);
                            textView2 = findViewById(R.id.Board_8_NB);
                            break;
                        case 9:
                            textView1 = findViewById(R.id.Board_9_Title);
                            textView2 = findViewById(R.id.Board_9_NB);
                            break;
                        default:
                            textView1 = findViewById(R.id.Board_1_Title);
                            textView2 = findViewById(R.id.Board_1_NB);
                    }
                    String res = json.getString("Start")+" "+json.getString("Dest")+" "+json.getString("Enter_Time")+" "+json.getString("Invi_Time")+" "+json.getString("Now_P")+"/"+json.getString("Entire_P")+" "+json.getString("State")+" "+json.getString("Create_Time");
                    textView1.setText(res);
                    textView1.setVisibility(View.VISIBLE);
                    textView2.setVisibility(View.VISIBLE);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
