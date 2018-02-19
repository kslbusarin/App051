package com.busarin.app051;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    private TextSwitcher simpleTextSwitcher;
    Button btnNext;


    // Array of String to Show In TextSwitcher
    String strings[] = {"Hello","สูตรคณิตศาสตร์", "ผลต่างกำลังสอง \nน2 - ล2= (น– ล)(น+ ล)", "กำลังสองสมบูรณ์ \n(น + ล)2 = น2 + 2นล +ล2\n(น - ล)2 = น2 - 2นล + ล2", "สูตรการหาพื้นที่",
            "พื้นที่รูปสี่เหลี่ยมจัตุรัส = ด้าน × ด้าน\n",
            "นที่รูปสี่เหลี่ยมผืนผ้า = กว้าง × ยาว","พื้นที่สี่เหลี่ยมคางหมู =   ½ x สูง x ผลบวกด้านคู่ขนาน","พื้นที่สี่เหลี่ยมใด ๆ =   ½  x เส้นทแยงมุม x ผลบวกเส้นกิ่ง","END"};
    int messageCount = strings.length;
    // to keep current Index of textID array
    int currentIndex = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // get The references if Button and TextSwitcher
        btnNext = (Button) findViewById(R.id.buttonNext);
        simpleTextSwitcher = (TextSwitcher) findViewById(R.id.simpleTextSwitcher);
        // Set the ViewFactory of the TextSwitcher that will create TextView object when asked
        simpleTextSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                // TODO Auto-generated method stub
                // create a TextView
                TextView t = new TextView(MainActivity.this);
                // set the gravity of text to top and center horizontal
                t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
                // set displayed text size
                t.setTextSize(36);
                return t;
            }
        });

        // Declare in and out animations and load them using AnimationUtils class
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        // set the animation type to TextSwitcher
        simpleTextSwitcher.setInAnimation(in);
        simpleTextSwitcher.setOutAnimation(out);

        //text appear on start
        simpleTextSwitcher.setCurrentText("click on next button to switch text");
        // ClickListener for NEXT button
        // When clicked on Button TextSwitcher will switch between labels
        // The current label will go out and next label will come in with specified animation
        btnNext.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                currentIndex++;
                // If index reaches maximum then reset it
                if (currentIndex == messageCount)
                    currentIndex = 0;
                simpleTextSwitcher.setText(strings[currentIndex]); // set Text in TextSwitcher
            }
        });

    }

}

