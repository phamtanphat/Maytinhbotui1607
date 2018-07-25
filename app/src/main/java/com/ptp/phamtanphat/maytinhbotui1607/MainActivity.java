package com.ptp.phamtanphat.maytinhbotui1607;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtSothu1,edtSothu2;
    Button btnCong,btnTru,btnNhan,btnChia;
    TextView txtKetqua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtSothu1 = findViewById(R.id.edittextSothu1);
        edtSothu2 = findViewById(R.id.edittextSothu2);
        btnCong = findViewById(R.id.buttonCong);
        btnTru = findViewById(R.id.buttonTru);
        btnNhan = findViewById(R.id.buttonNhan);
        btnChia = findViewById(R.id.buttonChia);
        txtKetqua = findViewById(R.id.textviewKetqua);


        //Sự kiện click của button
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Lấy dữ liệu từ edittext
                setTinhoan("+");
            }
        });
        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTinhoan("/");
            }
        });
        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTinhoan("*");
            }
        });
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTinhoan("-");
            }
        });
    }
    //Hàm : function : Phương thức
//    +Access Modifier : private  public protected
//    private : Tạo ra ở đâu thì thằng đó gọi được (visa nội địa)
//    public : Tạo ra ở đâu cũng được và ai cũng gọi được (visa quốc tế)
//    protected : Sẽ gọi được khi bạn sử dụng đồ của ngta (Giấy tạm trú tạm vắng);
      //Pham vi truy cập
      private void setTinhoan(String toantu){
          String sothu1 = edtSothu1.getText().toString();
          String sothu2 = edtSothu2.getText().toString();
          int ketqua = 0;

          if (!sothu1.equals("") && !sothu2.equals("")){
              int sth1 = Integer.parseInt(sothu1);
              int sth2 = Integer.parseInt(sothu2);

              //Convert dữ liệu
              switch (toantu){
                  case "+" : ketqua = sth1 + sth2;
                        break;
                  case "-" : ketqua = sth1 - sth2;
                      break;
                  case "*" : ketqua = sth1 * sth2;
                      break;
                  case "/" : ketqua = sth1 / sth2;
                      break;
              }
              // Covert từ Integer về String
//                String giatri = String.valueOf(ketqua);
              txtKetqua.setText(ketqua + "");
          }else{
              Toast.makeText(MainActivity.this, "Bạn cần nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
          }
      }

}
