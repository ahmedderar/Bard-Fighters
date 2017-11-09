package adirar.hope;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;

import adirar.hope.model.AddInterface;
import adirar.hope.model.Volunteer;
import adirar.hope.utils.HelperMethods;

public class RegisterActivity extends AppCompatActivity implements AddInterface {
    //

   private EditText userNameEditText,passwordEditText,emailEditText,addressEditText,phoneEditText;
   private Button signUpBtn;
   private Volunteer currentUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userNameEditText = (EditText) findViewById(R.id.input_name);
        passwordEditText = (EditText) findViewById(R.id.input_password);
        emailEditText = (EditText) findViewById(R.id.input_email);
        addressEditText = (EditText) findViewById(R.id.input_address);
        phoneEditText = (EditText) findViewById(R.id.input_phone);
        signUpBtn = (Button) findViewById(R.id.signUpBtn);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String mandatoryFieldsStringResponse=checkIfAllMandatoryFieldsEntered();
//                if (!mandatoryFieldsStringResponse.equalsIgnoreCase("please enter the following\n")) {
//                    Toast.makeText(RegistrationActivity.this, mandatoryFieldsStringResponse, Toast.LENGTH_LONG).show();
//
//                } else {
//                    signUpTask();
//                }
                currentUser = new Volunteer();

                currentUser.setPhone(phoneEditText.getText().toString());
                currentUser.setAddress(addressEditText.getText().toString());
                currentUser.setEmail(emailEditText.getText().toString());
                currentUser.setName(userNameEditText.getText().toString());
                String id = currentUser.getName();

                currentUser.setPassword(passwordEditText.getText().toString());
                HelperMethods.pushInFireBase("users", currentUser, RegisterActivity.this, "loading", "plz wait", id);
            }
        });
    }

    @Override
    public void updateUI(DatabaseError databaseError) {
        if (databaseError != null) {
            Log.i("error", "updateUI: ");
            Log.i("error ", "updateUI: " + databaseError.toString());
            Toast.makeText(RegisterActivity.this, "Error in saving", Toast.LENGTH_SHORT).show();
        } else {
            Log.i("Done", "updateUI: ");
            Intent i = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }
    }
}
