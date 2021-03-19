package ezsx.sum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

public class MulitComp extends AppCompatActivity {

    private LinearLayout framesContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mulit_comp);
        framesContainer = (LinearLayout) findViewById(R.id.multi_comp_layout);
        for (int i = 0; i < 5; i++) {
            OneCompL frame = new OneCompL(getApplicationContext());
            frame.setNum_digit(i);
            framesContainer.addView(frame);
        }


    }
}