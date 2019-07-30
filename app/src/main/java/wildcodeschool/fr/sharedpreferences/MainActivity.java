package wildcodeschool.fr.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText inputText;

    private static final String SHARED_PREF = "input_result";
    private static final String KEY = "backup";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.input_text);
        Button saveButton = findViewById(R.id.save_button);
        TextView backup = findViewById(R.id.backup);

        final SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        String value = sharedPreferences.getString(KEY, null);

        if (value != null) {
            backup.setText(value);
        }

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputValue = inputText.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY, inputValue);
                editor.apply();
                inputText.setText("");
            }
        });
    }
}
