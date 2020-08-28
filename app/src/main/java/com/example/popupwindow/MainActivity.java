package com.example.popupwindow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button btnShowPopupWindow;
    private RelativeLayout relativeLayout;
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowPopupWindow=findViewById(R.id.btnShowPopupWindow);

        relativeLayout=findViewById(R.id.relativeLayout);


        btnShowPopupWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater layoutInflater=(LayoutInflater)getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                final View popupView=layoutInflater.inflate(R.layout.popup_window,null);

                popupWindow=new PopupWindow(popupView, RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT);

              popupWindow.showAtLocation(relativeLayout, Gravity.CENTER,0,0);
              btnShowPopupWindow.setVisibility(View.INVISIBLE);
              
              popupView.findViewById(R.id.btnClose).setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {

                        popupWindow.dismiss();
                        btnShowPopupWindow.setVisibility(View.VISIBLE);
                  }
              });


            }
        });
    }
}