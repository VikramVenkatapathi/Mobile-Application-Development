package com.example.keyboard_2;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.LinearLayout;

public class CustomKeyboard extends LinearLayout implements View.OnClickListener {


    private Button button1, button2, button3, button4,
            button5, button6, button7, button8,
            button9, button0, buttonDelete, buttonEnter;

    private Button buttona,buttonb,buttonc,buttond,buttone,buttonf,buttong,buttonh,buttoni,
            buttonj,buttonk,buttonl,buttonm,buttonn,buttono,buttonp,buttonq,buttonr,
            buttons,buttont,buttonu,buttonv,buttonw,buttonx,buttony,buttonz;

    private SparseArray<String> keyValues = new SparseArray<>();
    private InputConnection inputConnection;

    public CustomKeyboard(Context context) {
        this(context, null, 0);
    }

    public CustomKeyboard(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomKeyboard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.keyboard, this, true);
        button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(this);
        button4 = (Button) findViewById(R.id.button_4);
        button4.setOnClickListener(this);
        button5 = (Button) findViewById(R.id.button_5);
        button5.setOnClickListener(this);
        button6 = (Button) findViewById(R.id.button_6);
        button6.setOnClickListener(this);
        button7 = (Button) findViewById(R.id.button_7);
        button7.setOnClickListener(this);
        button8 = (Button) findViewById(R.id.button_8);
        button8.setOnClickListener(this);
        button9 = (Button) findViewById(R.id.button_9);
        button9.setOnClickListener(this);
        button0 = (Button) findViewById(R.id.button_0);
        button0.setOnClickListener(this);
        buttonDelete = (Button) findViewById(R.id.button_delete);
        buttonDelete.setOnClickListener(this);
        buttonEnter = (Button) findViewById(R.id.button_enter);
        buttonEnter.setOnClickListener(this);

        buttona = (Button) findViewById(R.id.button_a);buttonb = (Button) findViewById(R.id.button_b);
        buttona.setOnClickListener(this);buttonb.setOnClickListener(this);
        buttonc = (Button) findViewById(R.id.button_c);buttond = (Button) findViewById(R.id.button_d);
        buttonc.setOnClickListener(this);buttond.setOnClickListener(this);
        buttone = (Button) findViewById(R.id.button_e);buttonf = (Button) findViewById(R.id.button_f);
        buttone.setOnClickListener(this);buttonf.setOnClickListener(this);
        buttong = (Button) findViewById(R.id.button_g);buttonh = (Button) findViewById(R.id.button_h);
        buttong.setOnClickListener(this);buttonh.setOnClickListener(this);
        buttoni = (Button) findViewById(R.id.button_i);buttonj = (Button) findViewById(R.id.button_j);
        buttoni.setOnClickListener(this);buttonj.setOnClickListener(this);
        buttonk = (Button) findViewById(R.id.button_k);buttonl = (Button) findViewById(R.id.button_l);
        buttonk.setOnClickListener(this);buttonl.setOnClickListener(this);
        buttonm = (Button) findViewById(R.id.button_m);buttonn = (Button) findViewById(R.id.button_n);
        buttonm.setOnClickListener(this);buttonn.setOnClickListener(this);
        buttono = (Button) findViewById(R.id.button_o);buttonp = (Button) findViewById(R.id.button_p);
        buttono.setOnClickListener(this);buttonp.setOnClickListener(this);
        buttonq = (Button) findViewById(R.id.button_q);buttonr = (Button) findViewById(R.id.button_r);
        buttonq.setOnClickListener(this);buttonr.setOnClickListener(this);
        buttons = (Button) findViewById(R.id.button_s);buttont = (Button) findViewById(R.id.button_t);
        buttons.setOnClickListener(this);buttont.setOnClickListener(this);
        buttonu = (Button) findViewById(R.id.button_u);buttonv = (Button) findViewById(R.id.button_v);
        buttonu.setOnClickListener(this);buttonv.setOnClickListener(this);
        buttonw = (Button) findViewById(R.id.button_w);buttonx = (Button) findViewById(R.id.button_x);
        buttonw.setOnClickListener(this);buttonx.setOnClickListener(this);
        buttony = (Button) findViewById(R.id.button_y);buttonz = (Button) findViewById(R.id.button_z);
        buttony.setOnClickListener(this);buttonz.setOnClickListener(this);

        keyValues.put(R.id.button_1, "1");
        keyValues.put(R.id.button_2, "2");
        keyValues.put(R.id.button_3, "3");
        keyValues.put(R.id.button_4, "4");
        keyValues.put(R.id.button_5, "5");
        keyValues.put(R.id.button_6, "6");
        keyValues.put(R.id.button_7, "7");
        keyValues.put(R.id.button_8, "8");
        keyValues.put(R.id.button_9, "9");
        keyValues.put(R.id.button_0, "0");
        keyValues.put(R.id.button_enter, "\n");

        keyValues.put(R.id.button_a, "a");keyValues.put(R.id.button_b, "b");
        keyValues.put(R.id.button_c, "c");keyValues.put(R.id.button_d, "d");
        keyValues.put(R.id.button_e, "e");keyValues.put(R.id.button_f, "f");
        keyValues.put(R.id.button_g, "g");keyValues.put(R.id.button_h, "h");
        keyValues.put(R.id.button_i, "i");keyValues.put(R.id.button_j, "j");
        keyValues.put(R.id.button_k, "k");keyValues.put(R.id.button_l, "l");
        keyValues.put(R.id.button_m, "m");keyValues.put(R.id.button_n, "n");
        keyValues.put(R.id.button_o, "o");keyValues.put(R.id.button_p, "p");
        keyValues.put(R.id.button_q, "q");keyValues.put(R.id.button_r, "r");
        keyValues.put(R.id.button_s, "s");keyValues.put(R.id.button_t, "t");
        keyValues.put(R.id.button_u, "u");keyValues.put(R.id.button_v, "v");
        keyValues.put(R.id.button_w, "w");keyValues.put(R.id.button_x, "x");
        keyValues.put(R.id.button_y, "y");keyValues.put(R.id.button_z, "z");
    }

    @Override
    public void onClick(View view) {
        if (inputConnection == null)
            return;

        if (view.getId() == R.id.button_delete) {
            CharSequence selectedText = inputConnection.getSelectedText(0);

            if (TextUtils.isEmpty(selectedText)) {
                inputConnection.deleteSurroundingText(1, 0);
            } else {
                inputConnection.commitText("", 1);
            }
        } else {
            String value = keyValues.get(view.getId());
            inputConnection.commitText(value, 1);
        }
    }

    public void setInputConnection(InputConnection ic) {
        inputConnection = ic;
    }
}