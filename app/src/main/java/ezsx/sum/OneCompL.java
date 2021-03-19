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

        private String digit1 = "0";
        private String digit2 = "0";
        private int num_digit = 0;
        private View top_line1;
        private View top_line2;
        private ToggleButton bt1;
        private ToggleButton bt2;
        private MulitComp.CalcDigits calcDigits;



    public OneCompL(@NonNull Context context) {
        super(context);
        initComponent();
    }

    private void initComponent() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.one_comp_layout, this);
        top_line1 = (View) findViewById(R.id.top_line1);
        top_line2 = (View) findViewById(R.id.top_line2);
        bt1 = (ToggleButton)findViewById(R.id.toggle1);
        bt2 = (ToggleButton)findViewById(R.id.toggle2);
        OnClickListener btn_click_proc = (new OnClickListener() {
            public void onClick(View view) {
                ToggleButton bt =  ((ToggleButton) view);
                if (bt==bt1){
                    setDigit1(bt.isChecked());
                    calcDigits.setDigits(1,num_digit,digit1);
                } else {
                    setDigit2(bt.isChecked());
                    calcDigits.setDigits(2, num_digit,digit2);
                }

            }
        });
        bt2.setOnClickListener(btn_click_proc);
        bt1.setOnClickListener(btn_click_proc);
    }

    public void setDigit1(boolean isOn) {
        if (isOn) this.digit1 = "1"; else this.digit1 = "0";
    }

    public void setDigit2(boolean isOn) {
        if (isOn) this.digit2 = "1"; else this.digit2 = "0";
    }

    public void setNum_digit(int num_digit) {
        this.num_digit = num_digit;
    }

    public void setFirstComp(){
        top_line1.setVisibility(INVISIBLE);
        top_line2.setVisibility(INVISIBLE);
    }
    public void setCalcDigits(MulitComp.CalcDigits p){
        calcDigits = p;
    }
}
