package app.bit.com.myapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
      /*  class Cal{
            public int exe(String a){
                return Integer.parseInt(a.substring(1,a.indexOf("+")-1))+
                        Integer.parseInt(a.substring(a.indexOf("+")+1,a.length()));
            }
        }*/
        final Context ctx = MainActivity.this;
        class Cal{
            int num,res;
            String op;
            public int exe(String a, int b){
                op = a.substring(a.length()-1);
                res = Integer.parseInt(a.substring(0,a.length()-1));
                num = b;
                Toast.makeText(ctx,"계산식:"+res+" op "+op+" num "+num,Toast.LENGTH_LONG).show();
                switch (op){
                    case "+" : res+=num;
                    case "-" : res-=num;
                    case "*" : res*=num;
                    case "%" : res%=num;
                }
                return res;
            }
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //이것도 set임. 메소드
         //위에 MainActivity
       // final EditText num2 = findViewById(R.id.num2);
        final TextView total = findViewById(R.id.total);
        Button addbtn = findViewById(R.id.addbtn);
        Button minusbtn = findViewById(R.id.minusbtn);
        Button divbtn = findViewById(R.id.divbtn);
        Button mulbtn = findViewById(R.id.mulbtn);
        Button equal = findViewById(R.id.equal);
    /*    addbtn.setOnClickListener(this);
        minusbtn.setOnClickListener(this);
        divbtn.setOnClickListener(this);
        mulbtn.setOnClickListener(this);
        equal.setOnClickListener(this);*/
        Cal c = new Cal();
        findViewById(R.id.addbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 //xml
                //EditText num1 = findViewById(R.id.num1);
                //TextView result = findViewById(R.id.result);
                EditText num1 = findViewById(R.id.num1);
                //c.set("")
                total.setText(num1.getText().toString()+"+");
                num1.setText("");
                //String sNum1 = num1.getText().toString();
                /*result.setText(String.valueOf(Integer.parseInt(num1.getText().toString())+
                        Integer.parseInt(num2.getText().toString())));
                Toast.makeText(ctx,"입력한 숫자값:"+sNum1,Toast.LENGTH_LONG).show();*/ //length_long얼마만큼 띄워줄꺼냐
            }
    }); //elementgetbyid랑 같은애. 이때 R은 res
        /*findViewById(R.id.minusbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
        findViewById(R.id.minusbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText num1 = findViewById(R.id.num1); //xml
                String sNum1 = num1.getText().toString();
                /*EditText num2 = findViewById(R.id.num2);
                TextView result = findViewById(R.id.result);
                result.setText(String.valueOf(Integer.parseInt(num1.getText().toString())-
                        Integer.parseInt(num2.getText().toString())));*/
                Toast.makeText(ctx,"입력한 숫자값:"+sNum1,Toast.LENGTH_LONG).show(); //length_long얼마만큼 띄워줄꺼냐
            }
        });
        findViewById(R.id.mulbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText num1 = findViewById(R.id.num1); //xml
                String sNum1 = num1.getText().toString();
                /*EditText num2 = findViewById(R.id.num2);
                TextView result = findViewById(R.id.result);
                result.setText(String.valueOf(Integer.parseInt(num1.getText().toString())*
                        Integer.parseInt(num2.getText().toString())));*/
                Toast.makeText(ctx,"입력한 숫자값:"+sNum1,Toast.LENGTH_LONG).show(); //length_long얼마만큼 띄워줄꺼냐
            }
        });
        findViewById(R.id.divbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TextView result = findViewById(R.id.result);
                /*result.setText("계산결과:" + String.valueOf(Integer.parseInt(num1.getText().toString())/
                        Integer.parseInt(num2.getText().toString())));*/
                //length_long얼마만큼 띄워줄꺼냐
            }
        });
        findViewById(R.id.equal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText num2 = findViewById(R.id.num1);
               //int result = c.exe(total.getText().toString(), Integer.parseInt(num2.getText().toString()));
               //num2.setText(String.valueOf(result));
              // Toast.makeText(ctx,"계산식:"+result,Toast.LENGTH_LONG).show();

            }
        });
    }
}
