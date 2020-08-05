package naver.rlgns1129.actionbarcustomview0731;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    TextView lblsub;
    Button maincall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        lblsub = (TextView)findViewById(R.id.lblsub);
        maincall = (Button)findViewById(R.id.rootcall);

        //자신을 호출한 Intent를 찾아오기
        Intent intent = getIntent();
        //데이터 찾아오기
        String data = intent.getStringExtra("data");
        //데이터 출력
        lblsub.setText(data);

        final EditText inputsub = (EditText)findViewById(R.id.inputsub);

        maincall.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                //데이터를 데이터에 삽입.
                //ShareData.data = inputsub.getText().toString();

                //호출한 곳에 데이터를 전송하기 위한 코드
                //requestCode는 10 resultCode는 30
                Intent intent = new Intent();
                intent.putExtra("pass", inputsub.getText().toString());
                setResult(30,intent);

                //자신의 Activity 종료
                finish();
            }
        });
    }
}