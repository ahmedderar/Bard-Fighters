package adirar.hope;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;

import adirar.hope.model.RetrieveInterface;
import adirar.hope.model.TransferData;
import adirar.hope.model.Users;
import adirar.hope.utils.HelperMethods;

public class VLoginActivity extends AppCompatActivity implements RetrieveInterface{

    EditText userNameEditText, passwordEditText;
    Button loginBtn, registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vlogin);userNameEditText = (EditText) findViewById(R.id.userNameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        registerBtn = (Button) findViewById(R.id.signUpBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelperMethods.getData(VLoginActivity.this, "users", "Please wait", "Loading");
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VLoginActivity.this, RegisterActivity.class);
                startActivity(i);

            }
        });


    }

    @Override
    public void updateUI(DataSnapshot data) {
        Log.i("update ui", "updateUI: " + data.toString());
        boolean isExist = false;
        for (DataSnapshot currentChild : data.getChildren()) {

            Users currentUser = currentChild.getValue(Users.class);
            if (currentUser.getName().equalsIgnoreCase(userNameEditText.getText().toString())
                    && currentUser.getPassword().equalsIgnoreCase(passwordEditText.getText().toString())) {
           TransferData.userName = currentUser.getName();
                isExist = true;
//                Constants.currentUser= currentUser;
                break;
            }
        }

        if (isExist) {
            Intent i = new Intent(VLoginActivity.this, ReportsActivity.class);
            startActivity(i);
            finish();

        } else {
            Toast.makeText(VLoginActivity.this, "Wrong username and password", Toast.LENGTH_SHORT).show();
        }
    }
}
