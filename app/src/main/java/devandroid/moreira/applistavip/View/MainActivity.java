package devandroid.moreira.applistavip.View;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import devandroid.moreira.applistavip.Model.Pessoa;
import devandroid.moreira.applistavip.R;

public class MainActivity extends AppCompatActivity {

     Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();




    }
}