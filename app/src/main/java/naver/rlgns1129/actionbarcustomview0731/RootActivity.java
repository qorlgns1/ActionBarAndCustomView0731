package naver.rlgns1129.actionbarcustomview0731;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RootActivity extends AppCompatActivity {
    TextView lblroot;
    Button subcall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);

        lblroot = (TextView)findViewById(R.id.lblroot);
        subcall = (Button)findViewById(R.id.subcall);

        //이벤ㅌ 핸들러에서 사용하기 위해서 final을 추가
        final EditText inputroot = (EditText)findViewById(R.id.inputroot);
        subcall.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                //입력한 내용을 가져오기
                String content = inputroot.getText().toString();


                //SubActivity를 이용한 Intent 생성
                Intent intent = new Intent(RootActivity.this, SubActivity.class);

                //하위 Activity에게 전송할 데이터를 생성
                intent.putExtra("data", content);

                //Activity 호출
                //startActivity(intent);
                //응답을 받기 위해서 하위 액티비티를 호출할 때
                //구분하기 위한 번호와 함께 호출
                startActivityForResult(intent,10);
            }
        });
    }

//    @Override
//    public void onResume(){
//        super.onResume();
//        //공유 변수의 내용을 출력
//        lblroot.setText(ShareData.data);
//    }
    //하위 Activity가 소멸될 때 호출되는 메소드
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);
        if(requestCode == 10 && resultCode == 30 ){
            String pass = intent.getStringExtra("pass");
            lblroot.setText(pass);
        }
    }


}