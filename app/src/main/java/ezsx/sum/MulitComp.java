package ezsx.sum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MulitComp extends AppCompatActivity {

    private LinearLayout framesContainer;
    private List<OneCompL> list =  new ArrayList<>();
    private TextView res_txt;
    private CalcDigits calc_digits;

    public class CalcDigits extends Object{
        private String[] digits = { "0","0","0","0","0","0","0","0","0","0","0","0", };
        private String[] digits1= { "0","0","0","0","0","0","0","0","0","0","0","0", };
        private String s1;
        private String s2;
        private String s3;

        public void setDigits(int digit,int idx,String s){
            if (digit==1)
                digits[idx] = s;
            else
                digits1[idx] = s;

            s1 = digits[0] + digits[1] + digits[2] + digits[3] + digits[4] + digits[5] + digits[6] + digits[7] + digits[8] + digits[9] + digits[10] + digits[11];
            s2 = digits1[0] + digits1[1] + digits1[2] + digits1[3] + digits1[4] + digits1[5] + digits1[6] + digits1[7] + digits1[8] + digits1[9] + digits1[10] + digits1[11];
            s3 = Integer.toBinaryString(Integer.parseInt(s1, 2) + Integer.parseInt(s2, 2));

            res_txt.setText(s1+"  "+s2+"  "+s3);

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mulit_comp);
        framesContainer = (LinearLayout) findViewById(R.id.multi_comp_layout);
        res_txt = (TextView) findViewById(R.id.res_txt);
        calc_digits = new CalcDigits();
        for (int i = 0; i < 12; i++) {
            OneCompL frame = new OneCompL(getApplicationContext());
            if (i==0) {frame.setFirstComp();}
            frame.setNum_digit(11 - i);
            frame.setCalcDigits(calc_digits);
            framesContainer.addView(frame);
            list.add(i,frame);
        }


    }
}