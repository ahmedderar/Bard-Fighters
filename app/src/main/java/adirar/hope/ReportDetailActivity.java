package adirar.hope;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;

import adirar.hope.model.AddInterface;
import adirar.hope.model.MyDataModel;
import adirar.hope.model.RetrieveInterface;
import adirar.hope.model.TransferData;
import adirar.hope.utils.HelperMethods;

public class ReportDetailActivity extends AppCompatActivity implements AddInterface,RetrieveInterface{
    MyDataModel myDataModel;
    TextView tvName;
    TextView tvDate;
    TextView tvPhone;
    TextView tvareaZone;
    TextView tvAddress;
    TextView tvNearestBranch;
    TextView tvType;
    TextView tvShelterStatus;
    Button btnRespond;

    ListView lvResponders;

    ArrayList<String> responderArrayList ;
   ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_detail);

        Log.i("ReportDetailActivity","activity created");
        myDataModel = TransferData.transModel;
        Log.i("ReportDetailActivity","dataModel");


       //Respond btn Clicked
        btnRespond = (Button) findViewById(R.id.btn_report_respond);
        btnRespond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDataModel.setResponders("ahmed");
                String id = myDataModel.getName();
                HelperMethods.pushInFireBase("reports", myDataModel, ReportDetailActivity.this, "loading", "plz wait", id);


            }
        });

       /**
        Bundle b = this.getIntent().getExtras();
        if (b != null)
            myDataModel = b.getParcelable(Keys.KEY_RESPONDERS);
       **/


        tvName = (TextView) findViewById(R.id.tv_report_name);
        tvName.setText( myDataModel.getName());

        tvDate = (TextView) findViewById(R.id.tv_report_date);
        tvDate.setText( myDataModel.getDate());

        tvPhone = (TextView) findViewById(R.id.tv_report_phone);
        tvPhone.setText( myDataModel.getPhoneNo());

        tvAddress = (TextView) findViewById(R.id.tv_report_address);
        tvAddress.setText( myDataModel.getAddress());

        tvareaZone = (TextView) findViewById(R.id.tv_report_areazone);
        tvareaZone.setText( myDataModel.getAreaZone());

        tvNearestBranch = (TextView) findViewById(R.id.tv_report_nearestbranch);
        tvNearestBranch.setText( myDataModel.getNearestBranch());

        tvShelterStatus = (TextView) findViewById(R.id.tv_report_shelterstatus);
        tvShelterStatus.setText( myDataModel.getShelterStatus());

        tvType = (TextView) findViewById(R.id.tv_report_type);
        tvType.setText( myDataModel.getType());


        // FireBase get responders
        HelperMethods.getData(this,"reports","Please Waiting","Loading");


      // responderArrayList = getSeperateRespond(myDataModel.getResponders());
        responderArrayList = getSeperateRespond(TransferData.transModel.getResponders());

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, responderArrayList);
        lvResponders = (ListView) findViewById(R.id.lv_report_responders);
        lvResponders.setAdapter(adapter);

    }

    private ArrayList<String> getSeperateRespond(String respons){
        ArrayList<String> result = new ArrayList<>();
        String[] str = respons.split(",");
        for ( String string:str){
            result.add(string);
        }
    return result;
    }


    @Override
    public void updateUI(DataSnapshot data) {
        Log.i("update ui", "updateUI: " + data.toString());
        MyDataModel currentModel =null;
        boolean isExist = false;
        for (DataSnapshot currentChild : data.getChildren()) {

           currentModel = currentChild.getValue(MyDataModel.class);
            if (currentModel.getResponders() != null) {
                isExist = true;
//              //  Constants.currentUser= currentUser;
                break;
            }
        }

        if (isExist) {
        //There is data responder in
      //  myDataModel.setResponders(currentModel.getResponders());
        TransferData.transModel.setResponders(currentModel.getResponders());
        } else {
            //No Responders
            lvResponders.setVisibility(View.INVISIBLE);
        }
    }



        @Override
       public void updateUI(DatabaseError databaseError) {
           if (databaseError != null) {
               Log.i("error", "updateUI: ");
               Log.i("error ", "updateUI: " + databaseError.toString());
               Toast.makeText(ReportDetailActivity.this, "Error in saving", Toast.LENGTH_SHORT).show();
           } else {
               Log.i("Done", "updateUI: ");
               Intent i = new Intent(ReportDetailActivity.this, ReportDetailActivity.class);
               startActivity(i);
               finish();
           }
       }




    }
