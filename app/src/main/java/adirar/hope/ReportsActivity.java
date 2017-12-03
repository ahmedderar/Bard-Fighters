package adirar.hope;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;

import adirar.hope.adapter.MyArrayAdapter;
import adirar.hope.model.MyDataModel;
import adirar.hope.model.RetrieveInterface;
import adirar.hope.model.TransferData;
import adirar.hope.util.InternetConnection;
import adirar.hope.util.Keys;
import adirar.hope.utils.HelperMethods;

public class ReportsActivity extends AppCompatActivity implements RetrieveInterface{

    private ListView listView;
    private ArrayList<MyDataModel> list;
    private MyArrayAdapter adapter;

    private MyDataModel gDataModel;

    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dialog = new ProgressDialog(ReportsActivity.this);
        //Get Data from Firebase
        HelperMethods.getData(ReportsActivity.this, "masterSheet", "Please wait", "Loading");
       showDialogBar(true);
        /**
         * Array List for Binding Data from JSON to this List
         */
        list = TransferData.reportsArray;
        /**
         * Binding that List to Adapter
         */
        adapter = new MyArrayAdapter(this, list);

        /**
         * Getting List and Setting List Adapter
         */
        adapter.notifyDataSetChanged();
        showDialogBar(false);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        // On Item Clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("ReportsActivity", "Item Just Clicked");
                Snackbar.make(findViewById(R.id.parentLayout), list.get(position).getName() + " => " + list.get(position).getDate(), Snackbar.LENGTH_LONG).show();
                //Starting the report Detail
                //  MyDataModel currentModel
                gDataModel = list.get(position);
                Log.i("ReportsActivity", "item Clicked");
                TransferData.transModel = TransferData.reportsArray.get(position);
                // FireBase get responders
               // HelperMethods.getData(ReportsActivity.this, "reports", "Please Waiting", "Loading");

                // TransferData.transModel = currentModel;
                Intent i = new Intent(ReportsActivity.this, ReportDetailActivity.class);
                /**
                 Bundle b = new Bundle();
                 b.putParcelable(Keys.KEY_RESPONDERS,currentModel);
                 i.putExtras(b);
                 //   i.setClass(ReportsActivity.this, ReportDetailActivity.class);
                 **/
                startActivity(i);
            }
        });

        /**
         * Just to know onClick and Printing Hello Toast in Center.
         */
        Toast toast = Toast.makeText(getApplicationContext(), "Click on FloatingActionButton to Load JSON", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(@NonNull View view) {

                /**
                 * Checking Internet Connection
                 */
                if (InternetConnection.checkConnection(getApplicationContext())) {
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                    //  new GetDataTask().execute();
                  //  showDialogBar(true);

                    //  adapter.notifyDataSetChanged();

                    //   showDialogBar(false);

                } else {
                    Snackbar.make(view, "Internet Connection Not Available", Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }


    @Override
    public void updateUI(DataSnapshot data) {
        Log.i("update ui", "updateUI: " + data.toString());
        ArrayList<MyDataModel> temp = new ArrayList<>();

      //  boolean isExist = false;
        for (DataSnapshot currentChild : data.getChildren()) {

           MyDataModel currentModel = convetToModel(currentChild);
         //   GSheetModel currentModel = (GSheetModel) currentChild.getValue();
                //isExist = true;
                //TransferData.transModel = currentModel;
          //  MyDataModel converter = new MyDataModel();
            //converter.setDate(currentModel.getDate());
         //   converter.setName(currentModel.getName());
            temp.add(currentModel);

        }
        TransferData.reportsArray = temp;

    }


    public MyDataModel convetToModel(DataSnapshot dataSnapshot){
        MyDataModel result = new MyDataModel();
        long count = dataSnapshot.getChildrenCount();
        Log.i("ReportsActivity","dataSnapshot Count = " + count);
        for (DataSnapshot snap : dataSnapshot.getChildren() ){
            if (snap.getKey().equals(Keys.KEY_NAME))
            result.setName((String) snap.getValue());
            if (snap.getKey().equals(Keys.KEY_DATE))
                result.setDate((String) snap.getValue());
            if (snap.getKey().equals(Keys.KEY_PHONE))
                result.setPhoneNo((String) snap.getValue());
            if (snap.getKey().equals(Keys.KEY_AREZONE))
                result.setAreaZone((String) snap.getValue());
            if (snap.getKey().equals(Keys.KEY_ADDRESS))
                result.setAddress((String) snap.getValue());
            if (snap.getKey().equals(Keys.KEY_NEARESTBRANCH))
                result.setNearestBranch((String) snap.getValue());
            if (snap.getKey().equals(Keys.KEY_TYPE))
                result.setType((String) snap.getValue());
            if (snap.getKey().equals(Keys.KEY_SHELTER_STATUS))
                result.setShelterStatus((String) snap.getValue());
        }
        return result;
    }

    public void showDialogBar(boolean showIt){
        if (dialog ==null)
    //    dialog = new ProgressDialog(ReportsActivity.this);
        dialog.setTitle("Hey Wait Please..." );
        dialog.setMessage("I am getting your JSON");
        if (showIt)
        dialog.show();
        else dialog.dismiss();
    }
}
