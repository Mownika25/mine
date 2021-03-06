package com.example.android.eduease;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class STUDENT_DASHBOARD extends AppCompatActivity {
    String TAG = "STUDENT_DASHBOARD";
    FirebaseDatabase database;
    DatabaseReference myRef;
    ArrayList<TeacherDataRetrieve> obj;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__dashboard);

        Log.v("mow","error nhi hai");
        Intent intent = getIntent();
        String subj = intent.getStringExtra("subject");

        database= FirebaseDatabase.getInstance();//dbpath
        myRef = database.getReference(subj);//subject

        listView = (ListView) findViewById(R.id.list);
        Log.v("mow","error nhi hai2");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Log.v("mow","error nhi hai3");

                //collectNames((Map<String,TeacherDataUpload>) dataSnapshot.getValue());



                obj= new ArrayList<>();
                Log.v("mow","error nhi hai600000");

                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    TeacherDataUpload value = postSnapshot.getValue(TeacherDataUpload.class);
                    Log.v("nhhu","nhi ho rha thisssss");
                    obj.add(new TeacherDataRetrieve(value.getName(),value.getTimeTo(),value.getTimeFRom(),value.getCllg()));
                    // Log.e("Get Data", post.<YourMethod>());
                }
             //   TeacherDataRetrieve value = dataSnapshot.getValue(TeacherDataRetrieve.class);
             /*   obj.add( new TeacherDataRetrieve( singleUser.get("name").toString(),
                        singleUser.get("timeTo").toString(),
                        singleUser.get("timeFRom").toString(),
                        singleUser.get("cllg").toString()));
*/                Log.v("mow","error nhi hai000");

                objAdapter adapter = new objAdapter(getApplicationContext(), obj);
                Log.v("mow","error nhi hai6");

                listView.setAdapter(adapter);

                Log.i("onDisabled","info");
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getApplicationContext(),"error in retrieving",Toast.LENGTH_SHORT).show();

                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TeacherDataRetrieve data = obj.get(i);

                Intent intent= new Intent(STUDENT_DASHBOARD.this,TeacherDetail.class);

                intent.putExtra("name",data.getName());
                intent.putExtra("cllg",data.getCllg());
                intent.putExtra("toTime",data.getTimeTo());
                intent.putExtra("frmTime",data.getTimeFrom());
                //name or key or all data of the teacher selected
                startActivity(intent);
            }
        });

    }


    private void collectNames(Map<String,TeacherDataUpload> users) {
        Log.v("mow","error nhi hai4");

        obj= new ArrayList<>();

        //iterate through each user, ignoring their UID
        for (Map.Entry<String, TeacherDataUpload> entry : users.entrySet()){
            Log.v("mow","error nhi hai5");

            //Get user map
            Map singleUser = (Map) entry.getValue();
            //Get phone field and append to list
            obj.add( new TeacherDataRetrieve( singleUser.get("name").toString(),
                    singleUser.get("timeTo").toString(),
                    singleUser.get("timeFRom").toString(),
                    singleUser.get("cllg").toString()));


        }
        objAdapter adapter = new objAdapter(getApplicationContext(), obj);
        Log.v("mow","error nhi hai6");

        listView.setAdapter(adapter);

        Log.i("onDisabled","info");

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id)
        {


            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(STUDENT_DASHBOARD.this,MainActivity.class));
                finish();
                break;
        }
        return true;
    }

    @Override//just a comment for git

    public void onBackPressed() {
        //sign out from app even if back is preāssed
        FirebaseAuth.getInstance().signOut();


        super.onBackPressed();

    }
}