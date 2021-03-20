package ezsx.sum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MulitComp extends AppCompatActivity {

    public static int DIGIT_COUNT = 12;

    private LinearLayout framesContainer;
    //private List<OneCompL> list =  new ArrayList<>();
    private TextView res_txt;
    private CalcDigits calc_digits;

    public class CalcDigits extends Object{

        private List<List<String>> digits;

        private List<String> ss;
        private String res_string = "";

        public CalcDigits() {
             List<String> digits1 = new ArrayList<>(DIGIT_COUNT);
             List<String> digits2 = new ArrayList<>(DIGIT_COUNT);
             String init_s = "";
             for(int i=0;i<DIGIT_COUNT;i++){
                 digits1.add("0");
                 digits2.add("0");
                 init_s = init_s + "0";
             }
            ss = new ArrayList<>(2);

             digits = new ArrayList<>(2);
             digits.add(0,digits1);
             digits.add(1,digits2);
             ss.add(init_s);
             ss.add(init_s);
        }

        public void setDigits(int digit_in,int idx,String s){
            int digit = digit_in -1;
            List<String> dig = digits.get(digit);
            dig.set(idx,s);
            Iterator<String> iter = dig.iterator();

            String s_tmp = "";
            while(iter.hasNext()){
                s_tmp = s_tmp + iter.next();
            }
            ss.set(digit,s_tmp);
            res_string = Integer.toBinaryString(Integer.parseInt(ss.get(0), 2) + Integer.parseInt(ss.get(1), 2));

            res_txt.setText("    " + ss.get(0)+" + "+ss.get(1)+" = \n    "+res_string);

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mulit_comp);
        framesContainer = (LinearLayout) findViewById(R.id.multi_comp_layout);
        res_txt = (TextView) findViewById(R.id.res_txt);
        calc_digits = new CalcDigits();
        for (int i = 0; i < DIGIT_COUNT; i++) {
            OneCompL frame = new OneCompL(getApplicationContext());
            if (i==0) {frame.setFirstComp();}
            frame.setNum_digit(DIGIT_COUNT - 1 - i);
            frame.setCalcDigits(calc_digits);
            framesContainer.addView(frame);
            //list.add(i,frame);
        }


    }
}