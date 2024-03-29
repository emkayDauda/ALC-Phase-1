package ng.com.pluralsightchallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view){
        switch (view.getId()){
            case R.id.about : {
                startActivity(new Intent(MainActivity.this, AboutAlc.class));
                break;
            }

            case R.id.profile: {
                startActivity(new Intent(MainActivity.this, Profile.class));
                break;
            }
        }
    }
}
