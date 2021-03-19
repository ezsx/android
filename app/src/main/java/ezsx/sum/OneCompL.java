package ezsx.sum;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

public class OneCompL   extends ConstraintLayout{

        private String digit1 = "1";
        private String digit2 = "1";
        private int num_digit = 0;



    public OneCompL(@NonNull Context context) {
        super(context);
        initComponent();
    }

    private void initComponent() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.one_comp_layout, this);
    }

    public void setDigit1(String digit1) {
        this.digit1 = digit1;
    }

    public void setDigit2(String digit2) {
        this.digit2 = digit2;
    }

    public void setNum_digit(int num_digit) {
        this.num_digit = num_digit;
    }
}
