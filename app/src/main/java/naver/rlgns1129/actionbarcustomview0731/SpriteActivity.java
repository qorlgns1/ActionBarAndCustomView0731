package naver.rlgns1129.actionbarcustomview0731;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class SpriteActivity extends AppCompatActivity {

    class MyView extends View {
        public MyView(Context context){
            super(context);
        }

        public void onDraw(Canvas canvas){
            Paint paint = new Paint();
            //리소스로부터 Bitmap을 생성
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img);
            //bitmap에서 앞의 Rect 만큼 가져와서 뒤의 Rect 만큼으로 그리기
            canvas.drawBitmap(bitmap, new Rect(0,0,350,350), new Rect(0,0,700,700), paint);

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sprite);
        //setContentView(new MyView(this));
        setContentView(R.layout.activity_sprite);
        setContentView(new MyView(this), new LinearLayout.LayoutParams(700,700));
    }




}