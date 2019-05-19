package com.example.schtaxi;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LoginActivity extends Activity {

    private dbfunc db = new dbfunc();
    private dbobject user = new dbobject();
    private String url = "http://sch-hj.iptime.org:88/Taxi/";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText Name = findViewById(R.id.Name);
        final EditText PH = findViewById(R.id.PH);
        TextView textView = findViewById(R.id.Res);

        Button submit = findViewById(R.id.Submit_bt);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setName(Name.getText().toString());
                user.setPH(PH.getText().toString());
                NetworkTask networkTask = new NetworkTask(url+db.LoginUser(user), null);
                networkTask.execute();
            }
        });

        textView.addTextChangedListener(watcher);
        Button back = findViewById(R.id.Back_bt);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            TextView textView1 = findViewById(R.id.Res);
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("Name", user.getName());
            intent.putExtra("PH", user.getPH());
            intent.putExtra("Res", textView1.getText());
            startActivity(intent);
        }
    };
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
            TextView textView = findViewById(R.id.Res);
            textView.setText(s);
            //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.
        }
    }
}
