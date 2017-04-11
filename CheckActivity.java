package com.tyustwys.logindemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.tyustwys.logindemo.R;
import com.tyustwys.logindemo.beans.SignInfo;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class CheckActivity extends AppCompatActivity {

    private Button btn_query;
    private RadioGroup rgp_user,rgp_loc;
    private TextView txt_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        initViews();

    }

    private void initViews() {
        btn_query = (Button) findViewById(R.id.btn_query_check);
        rgp_loc = (RadioGroup) findViewById(R.id.rgp_loc_check);
        rgp_user = (RadioGroup) findViewById(R.id.rgp_user_check);
        txt_info = (TextView) findViewById(R.id.info_check);
        btn_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BmobQuery<SignInfo> query1 = new BmobQuery<SignInfo>();
                query1.addWhereEqualTo("location","火星");
                BmobQuery<SignInfo> query2 = new BmobQuery<SignInfo>();
                query2.addWhereEqualTo("username","laoshi");
                List<BmobQuery<SignInfo>> andquery = new ArrayList<BmobQuery<SignInfo>>();
                andquery.add(query1);
                andquery.add(query2);
                BmobQuery<SignInfo> query = new BmobQuery<SignInfo>();
                query.or(andquery);
                query.findObjects(new FindListener<SignInfo>() {
                    @Override
                    public void done(List<SignInfo> list, BmobException e) {

                    }
                });

            }
        });
    }

}
