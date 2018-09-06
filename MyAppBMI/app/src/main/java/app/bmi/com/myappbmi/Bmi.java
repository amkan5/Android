package app.bmi.com.myappbmi;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

public class Bmi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);
        final Context this__ = Bmi.this;
        class Calc{

            int height,weight;
            String result;
            double bmi; /*weight/((hight*0.01)*(hight*0.01))*/
            //계산해서 SWITCH에 넣기
/*
            public void setHeight(int height){this.height=height};
            public void setWeight(int weight){this.weight=weight};
            public void setBmi(){this.weight/((this.height*0.01)*(this.height*0.01))};*/
        }
        final EditText hig = findViewById(R.id.hig);
        final EditText weg = findViewById(R.id.weg);
        findViewById(R.id.btn).setOnClickListener(
                (View v)->{
                    double hei = Double.parseDouble(hig.getText().toString());
                    //Calc c = new Calc();

                    Toast.makeText(this__,"입력한 숫자값:"+"AAA",Toast.LENGTH_LONG).show();
                }
        );
    }
}
