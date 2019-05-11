package com.example.android.eduease;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class newactivity extends AppCompatActivity {
    CheckBox sjava,sc,scpp,sds,sdaa,semfw,seem,sact,saec,sdec,cse,etc ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newactivity);

        sjava= findViewById(R.id.checkbox_JAVA);
        sc= findViewById(R.id.checkbox_C);
        scpp= findViewById(R.id.checkbox_CPP);
        sds= findViewById(R.id.checkbox_DS);
        sdaa= findViewById(R.id.checkbox_DAA);
        semfw= findViewById(R.id.checkbox_EMFW);
        seem= findViewById(R.id.checkbox_EEM);
        saec= findViewById(R.id.checkbox_AEC);
        sact= findViewById(R.id.checkbox_ACT);
        sdec= findViewById(R.id.checkbox_DEC);


    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId())
        {
            case R.id.checkbox_CSE:
            if (checked)
            {
                sdaa.setVisibility(View.VISIBLE);
                scpp.setVisibility(View.VISIBLE);
                sc.setVisibility(View.VISIBLE);
                sds.setVisibility(View.VISIBLE);
                sjava.setVisibility(View.VISIBLE);
                // Put some meat on the sandwich
            }
            if (!checked){
                // Do your coding
                sdaa.setVisibility(View.GONE);
                scpp.setVisibility(View.GONE);
                sc.setVisibility(View.GONE);
                sds.setVisibility(View.GONE);
                sjava.setVisibility(View.GONE);


            }
            case R.id.checkbox_ETC:
                if (checked)
                {
                    semfw.setVisibility(View.VISIBLE);
                    sact.setVisibility(View.VISIBLE);
                    sdec.setVisibility(View.VISIBLE);
                    saec.setVisibility(View.VISIBLE);
                    seem.setVisibility(View.VISIBLE);
                    // Put some meat on the sandwich
                }
                if (!checked){
                    // Do your coding
                    semfw.setVisibility(View.GONE);
                    sact.setVisibility(View.GONE);
                    sdec.setVisibility(View.GONE);
                    saec.setVisibility(View.GONE);
                    seem.setVisibility(View.GONE);


                }
                break;

        }
    }
}
