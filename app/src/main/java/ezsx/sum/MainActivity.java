package ezsx.sum;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private String[] digits = { "0","0","0","0","0","0","0","0","0","0","0","0", };
    private String[] digits1= { "0","0","0","0","0","0","0","0","0","0","0","0", };
    private String s1;
    private String s2;
    private String s3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button_all(View view) {
        ToggleButton bt =  ((ToggleButton) view);
        Object t = bt.getTag();
        String s = String.valueOf(t);
        if (s==null) return;
        int i = Integer.valueOf(s);
        // включена ли кнопка
        boolean on = bt.isChecked();
        if (on) {
            if (i <12)
                digits[i] = "1";
            else
                digits1[i-12] = "1";
        } else {
            if (i <12)
                digits[i] = "0";
            else
                digits1[i-12] = "0";
        }
        calc_digits();
    }

    private void calc_digits() {
        s1 = digits[0] + digits[1] + digits[2] + digits[3] + digits[4] + digits[5] + digits[6] + digits[7] + digits[8] + digits[9] + digits[10] + digits[11];
        s2 = digits1[0] + digits1[1] + digits1[2] + digits1[3] + digits1[4] + digits1[5] + digits1[6] + digits1[7] + digits1[8] + digits1[9] + digits1[10] + digits1[11];
        s3 = Integer.toBinaryString(Integer.parseInt(s1, 2) + Integer.parseInt(s2, 2));
        TextView txtv_s1 = (TextView) findViewById(R.id.s1);
        TextView txtv_s2 = (TextView) findViewById(R.id.s2);
        TextView txtv_s3 = (TextView) findViewById(R.id.s3);
        txtv_s1.setText(s1);
        txtv_s2.setText(s2);
        txtv_s3.setText(s3);
    }
}