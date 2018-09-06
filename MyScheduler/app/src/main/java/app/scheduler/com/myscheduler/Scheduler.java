package app.scheduler.com.myscheduler;

import android.content.Context;
import android.icu.util.Calendar;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import static java.util.Calendar.DATE;

public class Scheduler extends AppCompatActivity {
    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //필드를 점유할수밖에 없는 어쩔수없는 상황 달력과 시계를 합쳐야할때
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scheduler);
        final Context this_ = Scheduler.this;
        class Mydate{
            String year,month,day,hour,minute;
        }
        final Mydate m = new Mydate();
        TextView today = findViewById(R.id.today);
        CalendarView calender = findViewById(R.id.calender);
        TimePicker time = findViewById(R.id.time);
        TextView year = findViewById(R.id.year);
        TextView month = findViewById(R.id.month);
        TextView day = findViewById(R.id.day);
        TextView hour = findViewById(R.id.hour);
        TextView minute = findViewById(R.id.minute);
        today.setText(new SimpleDateFormat("yyyy-MM-dd"+" HH:mm:ss").format(new Date()));
        //첨에는 달력만 보여
        findViewById(R.id.rdoCalendar).setOnClickListener(
                (View v)->{
               calender.setVisibility(View.VISIBLE);
               time.setVisibility(View.INVISIBLE);

                }
        );
        findViewById(R.id.rdoTime).setOnClickListener(
                (View v)->{
                    calender.setVisibility(View.INVISIBLE);
                    time.setVisibility(View.VISIBLE);
                }
        );
        findViewById(R.id.btnEnd).setOnClickListener(
                (View v)->{
                    date = year.getText().toString()+"-"+
                            month.getText().toString()+"-"
                            +day.getText().toString()
                            +" "
                            + String.valueOf(time.getHour())+":"+
                            String.valueOf(time.getMinute());
                    Toast.makeText(this_, "예약 "+date,Toast.LENGTH_LONG).show();
                }
        );
        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                //내꺼
                TextView y = findViewById(R.id.year);
                TextView mn = findViewById(R.id.month);
                TextView d = findViewById(R.id.day);
                //Toast.makeText(this_, "년도"+year,Toast.LENGTH_LONG).show();
                y.setText(String.valueOf(year));
                mn.setText(String.valueOf(month));
                d.setText(String.valueOf(dayOfMonth));
                //강사님버전 필드를안씀
                m.year = year+"";
                m.month = month+"";
                m.day = dayOfMonth+"";



            }
        });
        time.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                TextView h = findViewById(R.id.hour);
                TextView mi= findViewById(R.id.minute);
                h.setText(String.valueOf(hourOfDay));
                mi.setText(String.valueOf(minute));
                //강사님버전
                m.hour = (hourOfDay+1)+"";
                m.minute = minute+"";
            }
        });

}
}
