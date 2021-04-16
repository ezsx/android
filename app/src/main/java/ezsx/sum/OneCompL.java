package ezsx.sum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

public class OneCompL   extends ConstraintLayout{


        private int num_digit = 0;
        private int shift_in =0;
        private int shift_out=0;
        private int is_on =0  ;
        private View top_line1;
        private View top_line2;
        private View bot_line1;
        private View bot_line2;
        private View bot_line3;
        private View button_1_line;
        private View button_2_line;
        private View button_3_line;
        private View button_4_line;
        private View button_2_l;
        private View lamp_line;
        private ToggleButton lamp;
        private ToggleButton bt1;
        private ToggleButton bt2;
        private MulitComp.CalcDigits calcDigits;



    public OneCompL(@NonNull Context context) {
        super(context);
        initComponent();
    }

    public void setColorComp_button(int btn,int clr){
        if (btn==1) { // first lamp
            button_1_line = (View) findViewById(R.id.button_1_line);
            button_2_line = (View) findViewById(R.id.button_2_line);
            button_3_line = (View) findViewById(R.id.button_3_line);
            button_4_line = (View) findViewById(R.id.button_4_line);
            if (clr == 1) { // state of first lamp off/on
                button_1_line.setBackgroundColor(0xFFEC1717);
                button_2_line.setBackgroundColor(0xFFEC1717);
                button_3_line.setBackgroundColor(0xFFEC1717);
                button_4_line.setBackgroundColor(0xFFEC1717);
            } else {
                button_1_line.setBackgroundColor(0xFF000000);
                button_2_line.setBackgroundColor(0xFF000000);
                button_3_line.setBackgroundColor(0xFF000000);
                button_4_line.setBackgroundColor(0xFF000000);
            }
        }
        else{
            if (btn==2){
            button_2_l = (View) findViewById(R.id.button_2_l);}
                if (clr==1){button_2_l.setBackgroundColor(0xFFEC1717);}
                else {button_2_l.setBackgroundColor(0xFF000000);}

        }
    }
    private void initComponent() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE); //habr 2011
        inflater.inflate(R.layout.one_comp_layout, this);
        top_line1 = (View) findViewById(R.id.top_line1);
        top_line2 = (View) findViewById(R.id.top_line2);
        bot_line1 = (View) findViewById(R.id.bot_line1);
        bot_line2 = (View) findViewById(R.id.bot_line2);
        bot_line3 = (View) findViewById(R.id.bot_line3);
        bt1 = (ToggleButton)findViewById(R.id.toggle1);
        bt2 = (ToggleButton)findViewById(R.id.toggle2);
        OnClickListener btn_click_proc = (new OnClickListener() {
            public void onClick(View view) {
                ToggleButton bt =  ((ToggleButton) view);
                calcDigits.setDigits(bt==bt1?1:2,num_digit,bt.isChecked()?"1":"0");
                setColorComp_button(bt==bt1?1:2,bt.isChecked()?1:2);
            }
        });
        bt2.setOnClickListener(btn_click_proc);
        bt1.setOnClickListener(btn_click_proc);
    }


    public void setNum_digit(int num_digit) {
        this.num_digit = num_digit;
    }

    public void setFirstComp(){
        top_line1.setVisibility(INVISIBLE);
        top_line2.setVisibility(INVISIBLE);
    }
    public void setLastComp(){
        bot_line1.setVisibility(INVISIBLE);
        bot_line2.setVisibility(INVISIBLE);
        bot_line3.setVisibility(INVISIBLE);
        bt1.setTextOff("0");
        bt1.setTextOn("1");
        bt1.setBackgroundResource(R.drawable.last_buttons);
        bt2.setTextOff("0");
        bt2.setTextOn("1");
        bt2.setBackgroundResource(R.drawable.last_buttons);
    }

    public void setCalcDigits(MulitComp.CalcDigits p){
        calcDigits = p;
    }
    public int get_sum(){
        int c= 0;
        if (bt1.isChecked()) c++;
        if (bt2.isChecked()) c++;
        return c;
    }
    private void setShift_in_color(int color_on){
        top_line1 = (View) findViewById(R.id.top_line1);
        top_line2 = (View) findViewById(R.id.top_line2);
        top_line1.setBackgroundColor(color_on);
        top_line2.setBackgroundColor(color_on);
    }
    private void setShift_out_color(int color_on){
        bot_line1 = (View) findViewById(R.id.bot_line1);
        bot_line2 = (View) findViewById(R.id.bot_line2);
        bot_line3 = (View) findViewById(R.id.bot_line3);
        bot_line1.setBackgroundColor(color_on);
        bot_line2.setBackgroundColor(color_on);
        bot_line3.setBackgroundColor(color_on);
    }
    private void setIs_on_color (int color_on){
        lamp_line = (View) findViewById(R.id.lamp_line);
        lamp_line.setBackgroundColor(color_on);
    }


    public void setShift_in(int shift_in) {
        if (this.shift_in == shift_in) {return;}
        this.shift_in = shift_in;
        if (shift_in==1) {
            setShift_in_color(0xFFEC1717);
        } else{
            setShift_in_color(0xFF000000);
        }
    }

    public void setShift_out(int shift_out) {
        if (this.shift_out == shift_out) {return;}
        this.shift_out = shift_out;
        if (shift_out==1) {
            setShift_out_color(0xFFEC1717);
        } else{
            setShift_out_color(0xFF000000);
        }
    }

    public void setIs_on(int is_on) {
        if (this.is_on == is_on) {return;}
        this.is_on = is_on;
        if (is_on==1){
            setIs_on_color(0xFFEC1717);
            lamp = (ToggleButton)findViewById(R.id.lamp);
            lamp.setChecked(true);
        } else{
            setIs_on_color(0xFF000000);
            lamp = (ToggleButton)findViewById(R.id.lamp);
            lamp.setChecked(false);
        }
    }
}
