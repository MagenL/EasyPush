package amagen.magen.easypushnotificartion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.magen.EasyPush.EasyMessage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EasyMessage message = new EasyMessage();
    }
}