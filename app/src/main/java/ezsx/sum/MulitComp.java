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
import java.util.ListIterator;
import java.util.Map;

public class MulitComp extends AppCompatActivity {

    public static int DIGIT_COUNT = 32;

    private LinearLayout framesContainer;
    private List<OneCompL> compL_list =  new ArrayList<>();
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

        private String toStringDec(String binary_string){
            if (binary_string.charAt(0)=='1') {
                // отрицательное
                //инвертируем все
                String res = binary_string.replace("1","b");
                res = res.replace("0","1");
                res = res.replace("b","0");
                return "-"+Integer.toString(Integer.parseInt(res,2)+1);
            } else {
                return Integer.toString(Integer.parseInt(binary_string,2));
            }
        }

        public void setDigits(int digit_in,int idx,String s){
            int digit = digit_in -1;
            List<String> dig = digits.get(digit);
            dig.set(idx,s);
            ListIterator<String> iter = dig.listIterator(dig.size());

            String s_tmp = "";
            while(iter.hasPrevious()){
                s_tmp = s_tmp + iter.previous();
            }

            ss.set(digit,s_tmp);
            res_string = Integer.toBinaryString(Integer.parseInt(ss.get(0), 2) + Integer.parseInt(ss.get(1), 2));
            if (res_string.length() > DIGIT_COUNT)
                res_string=res_string.substring(1,DIGIT_COUNT+1);
            else
                res_string = "00000000000000000000000000000".substring(0,DIGIT_COUNT-res_string.length())+res_string;
            String res_stringDec = toStringDec(res_string);
            if (!((res_string.charAt(0) == ss.get(0).charAt(0)) || (res_string.charAt(0) == ss.get(1).charAt(0)))) res_stringDec = getResources().getString(R.string.overflow);
            res_txt.setText(" " + toStringDec(ss.get(0)) + " + " + toStringDec(ss.get(1)) + " =  " + res_stringDec+ "\n"+
                " " + ss.get(0) + " + " + ss.get(1) + " =  " + res_string);
            reCalcCompL();
        }

        public void reCalcCompL(){
            ListIterator<OneCompL> iter = compL_list.listIterator(0);

            int dig = 0;
            int shift_in =0;
            while(iter.hasNext()){
                OneCompL cmpl = iter.next();
                // проставить состояние компонентам
                int su_m = Integer.parseInt(digits.get(0).get(dig)) + Integer.parseInt(digits.get(1).get(dig));
                su_m=su_m+shift_in;
                int shift_out = (su_m>1)?1:0;
                cmpl.setShift_out(shift_out);
                cmpl.setShift_in(shift_in);
                cmpl.setIs_on(su_m%2);
                shift_in = shift_out;
                dig++;
            }

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
            if (i==0) {frame.setFirstComp();} if (i==DIGIT_COUNT-1) {frame.setLastComp();}
            frame.setNum_digit(i);
            frame.setCalcDigits(calc_digits);
            framesContainer.addView(frame);
            compL_list.add(i,frame);
        }



    }
}