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

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateActivity extends Activity {
    private dbfunc db = new dbfunc();
    private dbobject user = new dbobject();
    private String url = "http://sch-hj.iptime.org:88/Taxi/";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        Intent intent = new Intent(this.getIntent());

        user.setName(intent.getStringExtra("Name"));
        user.setPH(intent.getStringExtra("PH"));
        final String Table_Name=intent.getStringExtra("Table_name");

        Button Submit = findViewById(R.id.Submit_bt);
        Button Back = findViewById(R.id.Back_bt);
        TextView Name = findViewById(R.id.Name);
        TextView PH = findViewById(R.id.PH);
        final EditText Start = findViewById(R.id.Start);
        final EditText Dest = findViewById(R.id.Dest);
        final EditText Enter_T = findViewById(R.id.Enter_T);
        final EditText Invi_T = findViewById(R.id.Invi_T);
        final EditText Entire_P = findViewById(R.id.Entire_P);

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-ddHH:mm");

        Start.setText(Table_Name);
        Enter_T.setText(simpleDateFormat.format(date));
        Invi_T.setText(simpleDateFormat.format(date));

        Name.setText(intent.getStringExtra("Name"));
        PH.setText(intent.getStringExtra("PH"));

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user.setStart(Start.getText().toString());
                user.setDest(Dest.getText().toString());
                user.setEnter_Time(Enter_T.getText().toString());
                user.setInvi_Time(Invi_T.getText().toString());
                user.setEntire_P(Integer.parseInt(Entire_P.getText().toString()));

                Toast.makeText(getApplicationContext(), url+db.CreateIndex(user, Table_Name), Toast.LENGTH_LONG).show();

                NetworkTask networkTask = new NetworkTask(url+db.CreateIndex(user, Table_Name), null);
                networkTask.execute();

                Intent intent1 = new Intent(CreateActivity.this, MainActivity.class);
                intent1.putExtra("Name", user.getName());
                intent1.putExtra("PH", user.getPH());
                intent1.putExtra("is_Party", user.getis_party());
                startActivity(intent1);
            }
        });
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
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
            if(s!="success"){
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            }
            user.setis_party(1);
            //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.
        }
    }
}
