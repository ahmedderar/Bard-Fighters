package adirar.hope;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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

public class LoginActivity extends AppCompatActivity implements RetrieveInterface {

    EditText userNameEditText, passwordEditText;
    Button loginBtn, registerBtn;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userNameEditText = (EditText) findViewById(R.id.userNameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        registerBtn = (Button) findViewById(R.id.signUpBtn);

         sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(this);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelperMethods.getData(LoginActivity.this, "users", "Please wait", "Loading");
                //SharedPrefrences
                SharedPreferences.Editor editor = sharedPreferences.edit();
               // String uName = userNameEditText.getText().toString();
               // TransferData.userName = uName;
               // editor.putString("username",uName);
               // editor.commit();
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
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
                TransferData.userName=currentUser.getName();
                Log.i("LogingActivity","UserName:"+TransferData.userName);
            //   TransferData.transUser = currentUser;
                isExist = true;

//                Constants.currentUser= currentUser;

                break;
            }
        }

        if (isExist) {
            Intent i = new Intent(LoginActivity.this, ReportsActivity.class);
            TransferData.userName = userNameEditText.getText().toString();
            startActivity(i);
            finish();

        } else {
            Toast.makeText(LoginActivity.this, "Wrong username and password", Toast.LENGTH_SHORT).show();
        }
    }
}
