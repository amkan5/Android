package app.bit.com.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SwitchCalc extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.switch_calc);
        final EditText num = findViewById(R.id.num);
        final TextView result = findViewById(R.id.result);
        Button addbtn = findViewById(R.id.addbtn);
        Button minusbtn = findViewById(R.id.minusbtn);
        Button divbtn = findViewById(R.id.divbtn);
        Button mulbtn = findViewById(R.id.mulbtn);
        Button equal = findViewById(R.id.equal);
        addbtn.setOnClickListener(this);
        minusbtn.setOnClickListener(this);
        divbtn.setOnClickListener(this);
        mulbtn.setOnClickListener(this);
        equal.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch(v.getId()) {
            case R.id.addbtn: break;
            case R.id.minusbtn: break;
            case R.id.divbtn: break;
            case R.id.mulbtn : break;
            case R.id.equal : break;
        }
    }

}
