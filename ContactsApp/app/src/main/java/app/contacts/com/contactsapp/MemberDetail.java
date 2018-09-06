package app.contacts.com.contactsapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MemberDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_detail);
        Context _this = MemberDetail.this;
        findViewById(R.id.detailToListbtn).setOnClickListener(
                (View v)->{
                    this.startActivity(new Intent(_this, MemberList.class));
                }
        );
        findViewById(R.id.detailToUpdatebtn).setOnClickListener(
                (View v)->{
                    this.startActivity(new Intent(_this, MemberUpdate.class));
                }
        );
    }
}
