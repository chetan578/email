package com.example.chetan578.email;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText userEmail,receiverEmail,body,subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userEmail= findViewById(R.id.userEmail);
        receiverEmail=findViewById(R.id.receiverEmail);
        body=findViewById(R.id.body);
        subject =findViewById(R.id.subject);

        final Button send = this.findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                new Thread(new Runnable() {

                    public void run() {
                        try {
                            GMailSender sender = new GMailSender("sobti.chetan.2009@gmail.com", "sinceiamnotwrong");
                            sender.sendMail( subject.getText().toString(),
                                    body.getText().toString(),
                                    userEmail.getText().toString(),
                                    receiverEmail.getText().toString());
                            Toast.makeText(MainActivity.this, "mail sent successfully", Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            Log.i("error", String.valueOf(e));
                        }
                    }
                }).start();
            }
        });
    }
}


