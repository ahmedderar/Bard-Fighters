package adirar.hope;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import adirar.hope.model.MyDataModel;
import adirar.hope.model.TransferData;

public class ReportDetailActivity extends AppCompatActivity{
    MyDataModel myDataModel;
    TextView tvName;
    TextView tvDate;
    TextView tvPhone;
    TextView tvareaZone;
    TextView tvAddress;
    TextView tvNearestBranch;
    TextView tvType;
    TextView tvShelterStatus;

    ListView lvResponders;

    ArrayList<String> responderArrayList ;
   ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_detail);

       /**
        Bundle b = this.getIntent().getExtras();
        if (b != null)
            myDataModel = b.getParcelable(Keys.KEY_RESPONDERS);
       **/
       Log.i("ReportDetailActivity","activity created");
        myDataModel = TransferData.transModel;
        Log.i("ReportDetailActivity","dataModel");

        tvName = (TextView) findViewById(R.id.tv_report_name);
        tvName.setText( myDataModel.getName());

        tvDate = (TextView) findViewById(R.id.tv_report_date);
        tvDate.setText( myDataModel.getDate());

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
    //    HelperMethods.getData(this,"reports","Please Waiting","Loading");

      /**
       responderArrayList = getSeperateRespond(myDataModel.getResponders());

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, responderArrayList);
        lvResponders = (ListView) findViewById(R.id.lv_report_responders);
        lvResponders.setAdapter(adapter);
            **/
    }

    private ArrayList<String> getSeperateRespond(String respons){
        ArrayList<String> result = new ArrayList<>();
        String[] str = respons.split(",");
        for ( String string:str){
            result.add(string);
        }
    return result;
    }

    /**
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
        myDataModel.setResponders(currentModel.getResponders());

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
            Intent i = new Intent(ReportDetailActivity.this, ReportsActivity.class);
            startActivity(i);
            finish();
        }
    }

    **/
    }
