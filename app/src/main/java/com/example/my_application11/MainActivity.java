package com.example.my_application11;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
{

    TextView score;
    TextView score2;


    Button point;
    Button multi;
    Button minus;
    Button sum;
    Button division;
    Button equal;

    double number1; //=Double.parseDouble(null);
    double number2;

    String num1 ;
    String num2;




    int flag_point = 0;


    int flag_first_num =0;


    int flag_multiple_op=0;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score = findViewById(R.id.textView_score);
        score2 = findViewById(R.id.textView_score2);

        point = findViewById(R.id.button_point);

        multi = findViewById(R.id.button_multy);
        minus = findViewById(R.id.button_minus);
        sum = findViewById(R.id.button_sum);
        division = findViewById(R.id.button_division);
        equal = findViewById(R.id.button_equal);


    }


    public void button_click_function(View view) {
        if (view instanceof Button) {
            Button button = (Button) view;
            String str = button.getText() + "";

            if ((button == point) && (flag_point == 0)) {
                score.append(str);
                flag_point = 1;
            }

            if (button != point) {
                score.append(str);
            }


        }
    }


    public void onClick_button_equal(View view) {
        if (view instanceof Button) {


            Button button = (Button) view;

            if ((button == multi) && (flag_multiple_op == 0)) {
                flag_multiple_op = 1;
                flag_point = 0;

            }

            if ((button == minus) && (flag_multiple_op == 0)) {
                flag_multiple_op = 2;
                flag_point = 0;

            }
            if ((button == sum) && (flag_multiple_op == 0)) {
                flag_multiple_op = 3;
                flag_point = 0;

            }
            if ((button == division) && (flag_multiple_op == 0)) {
                flag_multiple_op = 4;
                flag_point = 0;

            }



            if (flag_first_num == 1)
            {

                if ((button == equal) && (flag_multiple_op != 0))
                {
                    num2 = score.getText().toString();
                    if (!num2.equals("")) {

                        number2 = Double.parseDouble(num2);

                        switch (flag_multiple_op) {
                            case 1:
                                number1 = number1 * number2;
                                score2.setText(String.valueOf(number1));
                                break;


                            case 2:
                                number1 = number1 - number2;
                                score2.setText(String.valueOf(number1));
                                break;


                            case 3:
                                number1 = number1 + number2;
                                score2.setText(String.valueOf(number1));
                                break;


                            case 4:
                                if (number2 != 0) {
                                    number1 = number1 / number2;
                                    score2.setText(String.valueOf(number1));

                                } else {
                                    //score.setText("can't divide by zero");
                                    score2.setText("a");


                                }
                                break;
                        }

                        score.setText("");
                        flag_multiple_op = 0;
                    }
                    score2.setText(String.valueOf(number1));

                }

            }
            else
            {
                num1 = score.getText().toString();
                if (!num1.equals("")) {

                    number1 = Double.parseDouble(num1);
                    //number1 = Double.parseDouble(score.getText().toString());
                    score.setText("");
                    flag_first_num = 1;
                    flag_point = 0;

                }


            }


            if ((button == equal) && (flag_multiple_op == 0))
            {
                score2.setText(String.valueOf(number1));

            }
        }

    }




    public void button_click_AC(View view)
    {
        if (view instanceof Button)
        {

            score.setText("");
            score2.setText("");
            flag_point = 0;
            flag_first_num = 0;


        }


    }
}


            /*




                        Button button1 = (Button) view;
            char str_op = button1.getText().toString().charAt(0);


            if (flag_first_num == 1)
            {

                if (flag_multiple_op!=0)
                {
                    num2 = score.getText().toString();
                    if (!num2.equals("")) {

                        number2 = Double.parseDouble(num2);


                        switch (flag_multiple_op) {
                            case 1:
                                sco = number1 * number2;
                                score.setText("");
                                score2.setText(String.valueOf(sco));
                                break;



                            case 2:
                                sco = number1 - number2;
                                score.setText("");
                                score2.setText(String.valueOf(sco));
                                break;




                            case 3:
                                sco = number1 + number2;
                                score.setText("");
                                score2.setText(String.valueOf(sco));
                                break;



                            case 4:
                                if (number2 == 0) {
                                    score.setText("can't divide by zero");
                                } else {
                                    sco = number1 / number2;
                                    score.setText("");
                                    score2.setText(String.valueOf(sco));

                                }
                                break;


                        }
                    }

                    flag_multiple_op = 0;
                }







                num2 = score.getText().toString();
                if (!num2.equals("")) {

                    number2 = Double.parseDouble(num2);

                    //number2 = Double.parseDouble(score.getText().toString());
                    switch (str_op) {
                        case 'x':
                            sco = number1 * number2;
                            flag_multiple_op = 1;
                            score2.setText(String.valueOf(sco));
                            break;

                        case '-':
                            sco = (number1) - (number2);
                            flag_multiple_op = 2;
                            score2.setText(String.valueOf(sco));

                            break;


                        case '+':
                            sco = number1 + number2;
                            flag_multiple_op = 3;
                            score2.setText(String.valueOf(sco));

                            break;

                        case '/':
                            sco = number1 / number2;
                            flag_multiple_op = 4;
                            score2.setText(String.valueOf(sco));

                            break;


                        case '=':

                            num2 = score.getText().toString();
                            if (!num2.equals(""))
                            {

                                number2 = Double.parseDouble(num2);

                                switch (flag_multiple_op) {
                                    case 1:
                                        sco = number1 * number2;
                                        score2.setText(String.valueOf(sco));
                                        break;


                                    case 2:
                                        sco = number1 - number2;
                                        score2.setText(String.valueOf(sco));
                                        break;


                                    case 3:
                                        sco = number1 + number2;
                                        score2.setText(String.valueOf(sco));
                                        break;


                                    case 4:
                                        if (number2 != 0) {
                                            sco = number1 / number2;
                                            score2.setText(String.valueOf(sco));

                                        } else {
                                            //score.setText("can't divide by zero");
                                            score2.setText("a");


                                        }
                                        break;


                                }
                            }
                            flag_multiple_op = 0;
                            score2.setText(String.valueOf(sco));

                            break;


                    }

                    //if(str_op!='=')
                    // {
                    //    score.setText("");
                    //}
                    score.setText("");
                }


            } else {
                num1 = score.getText().toString();
                if (!num1.equals("")) {

                    number1 = Double.parseDouble(num1);
                    //number1 = Double.parseDouble(score.getText().toString());
                    score.setText("");
                    flag_first_num = 1;
                }


            }

        //score.append(str_op);

            if (flag_multiple_op!=0)
            {
                number2 = Integer.valueOf(score.getText().toString());

                switch (flag_multiple_op)
                {
                    case 1:
                        number1 =number1*number2;
                        score.setText("");

                    case 2:
                        number1 =number1-number2;
                        score.setText("");


                    case 3:
                        number1 =number1+number2;
                        score.setText("");

                    case 4:
                        if (number2==0)
                        {
                            score.setText("can't divide by zero");
                        }
                        else
                        {
                            number1 = number1 / number2;
                        }

                }

                flag_multiple_op = 0;
            }



                    switch (str_op)
        {
            case 'x':
                flag_multiple_op = 1;
                score.setText("");
                break;

            case '-':
                flag_multiple_op = 2;
                score.setText("");
                break;


            case '+':
                flag_multiple_op = 3;
                score.setText("");
                break;


            case '/':
                flag_multiple_op = 4;
                score.setText("");
                break;


            case '=':
                number2 = Double.parseDouble(score.getText().toString());
                score.setText("can't divide by zero");



                switch (flag_multiple_op)
                {
                    case 1:
                        number1 =number1*number2;

                        score.setText(String.valueOf(number1));
                        break;


                    case 2:
                        number1 =(number1)-(number2);
                        score.setText(String.valueOf(number1));
                        break;



                    case 3:
                        number1 =number1+number2;
                        score.setText(String.valueOf(number1));
                        break;


                    case 4:
                        if (number2==0)
                        {
                            //score.setText("can't divide by zero");
                            score.setText("");
                        }
                        else
                        {

                            number1 = number1 / number2;
                            score.setText(String.valueOf(number1));

                        }
                        break;


                }

                flag_multiple_op = 0;
                break;


             */
