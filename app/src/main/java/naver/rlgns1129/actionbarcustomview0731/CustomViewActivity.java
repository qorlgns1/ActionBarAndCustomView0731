package naver.rlgns1129.actionbarcustomview0731;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class CustomViewActivity extends AppCompatActivity {
    //터치 정보를 저장할 클래스
    class Vertex{
        //점의 좌표를 저장
        float x;
        float y;
        //그리기 여부를 저장
        boolean isDraw;

        //3개의 매개변수를 받아서 초기화하는 생성자
        //하나하나 다하면 힘들 수 있어서 생성자를 만들어서 처리를 합니다.
        public Vertex(float x, float y, boolean isDraw){
            this.x = x;
            this.y = y;
            this.isDraw = isDraw;
        }
    }

    //터치 정보를 저장할 List 변수 선언
    ArrayList<Vertex> arVertex;






    //View 클래스로부터 상속받는 CustomView
    class MyView extends View {
        Paint paint;
        //기본 생성자가 없으므로 생성자를 만들어서
        //상위 클래스의 생성자를 호출
        //생성자의 목적 : 초기화가 목적
        //자신의 인스턴스 변수들을 초기화 - 외부로 주입받기도 합니다.
        public MyView(Context context){
            //지금처럼 context context가 들어간것을 주입이라고 합니다.
            super(context);
            //paint를 생성
            paint = new Paint();
            //색상 설정과 선 두께 설정
            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(3);
            paint.setAntiAlias(true);



        }
        //View가 화면에 표시될 때 호출되는 메소드
        @Override
        public void onDraw(Canvas canvas){
            //arVertext의 내용을 가지고 선을 그리기
            for(int i=0; i<arVertex.size(); i=i+1){
                //isDraw가 true인 경우 이전 점에서부터
                //현재 점까지 그리기
                if(arVertex.get(i).isDraw == true){
                    canvas.drawLine(arVertex.get(i-1).x , arVertex.get(i-1).y , arVertex.get(i).x, arVertex.get(i).y, paint);
                }
            }
        }

        //터치 이벤트 처리를 위한 메소드
        @Override
        public boolean onTouchEvent(MotionEvent event){
            //터치가 처음 시작되는 경우에는 선을 그릴 필요가 없고 좌표만 저장
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                arVertex.add(new Vertex(event.getX(), event.getY(), false));
                return true;
            }
            //터치가 움직일 때 onDraw를 호출해서 현재위치까지 선을 그림
            if(event.getAction() == MotionEvent.ACTION_MOVE) {
                arVertex.add(new Vertex(event.getX(), event.getY(), true));
                //전체 화면을 전부 삭제하고 다시 그려달라고 요청
                invalidate();
                return true;
            }

            //기본적으로 제공되는 기능을 사용하지 않음
            return false;
        }
    }


//        @Override
//        public void onDraw(Canvas canvas){
//            //그리기 정보를 저장할 객체를 생성
//            Paint paint = new Paint();
//            paint.setColor(Color.BLUE);
//            canvas.drawColor(Color.TRANSPARENT);
//            canvas.drawCircle(100,100,100,paint);
//
//        }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //새로운 뷰를 화면 전체로 설정
        //setContentView(R.layout.activity_custom_view);
        setContentView(new MyView(this));
        arVertex = new ArrayList<>();


        //새로운 뷰를 현재 화면에 추가
        //setContentView(new MyView(this),new LinearLayout.LayoutParams(500,500));



    }
}