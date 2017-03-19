package com.example.johncarter.thelon.home_details;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.admin_side.Name;
import com.example.johncarter.thelon.models.Users;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Acer on 04/12/2016.
 */

public class AttendanceSuccess extends AppCompatActivity{

    Firebase tempTable;
    Firebase buddyTable;
    Firebase afterTable;
    FirebaseAuth auth;
    ArrayList<String> retrieved;
    ArrayList<Name>nameList;
    ArrayList<String> names;
    TextView evaluateBtn;
    CircleImageView image;
    String keyForPersonToEvaluate;
    ArrayList<String>keyList;
    ArrayList<NamePhoto>namePhotoList;
    String PersonToEvaluate;
    String actKey;
    Firebase dummy;
    Firebase root;

    Query usersFromAftertable;
    Query usersInTempTable;
    FirebaseUser User;
    Firebase UserF;
    TextView nameLabel;
    Firebase UserRoot;
    String keyToEvaluate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.attendance_success_layout);

        nameLabel = (TextView)findViewById(R.id.label3);
        image = (CircleImageView)findViewById(R.id.charles);


        namePhotoList = new ArrayList<>();
        keyList = new ArrayList<>();
        nameList = new ArrayList<>();
         User = FirebaseAuth.getInstance().getCurrentUser();
        names = new ArrayList<>();
        retrieved = new ArrayList<>();
        //dummy = new Firebase("https://ethelon-33583.firebaseio.com/ActivityAttendeesDummy");
        UserRoot = new Firebase("https://ethelon-33583.firebaseio.com/Users");
        UserF = new Firebase("https://ethelon-33583.firebaseio.com/Users");
        afterTable = new Firebase("https://ethelon-33583.firebaseio.com/ActivityAttendeesAfter");
        tempTable = new Firebase("https://ethelon-33583.firebaseio.com/TemporaryBuddyTable");
        buddyTable = new Firebase("https://ethelon-33583.firebaseio.com/ActivityBuddies");

        actKey = getIntent().getStringExtra("key");

        usersFromAftertable = afterTable.child(actKey);
        Log.e("charles","key "+actKey);


        //dummy = afterTable.child(actKey);

     /*   dummy.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String user = dataSnapshot.getKey();
                String name = dataSnapshot.getValue().toString();
                // Uri photo = User.getPhotoUrl();
                names.add(name);
                retrieved.add(user);

                if(retrieved.size()==2)

                if(retrieved.size()%2==0){

                    root = buddyTable.child(actKey).push();

                    root.child(retrieved.get(retrieved.size()-1)).child("name").setValue(names.get(names.size()-1));
                    root.child(retrieved.get(retrieved.size()-2)).child("name").setValue(names.get(names.size()-2));

                    dummy.child(retrieved.get(retrieved.size()-1)).removeValue();
                    dummy.child(retrieved.get(retrieved.size()-2)).removeValue();

                    set();
                    Toast.makeText(AttendanceSuccess.this, retrieved.get(retrieved.size()-1)+" = "
                            +retrieved.get(retrieved.size()-2), Toast.LENGTH_SHORT).show();

                }

                //usersInTempTable = tempTable.child(user);
                Log.e("charles"," Charles "+dataSnapshot.getKey());

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });*/

        usersFromAftertable.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String user = dataSnapshot.getKey();
                String name = dataSnapshot.getValue().toString();
               // Uri photo = User.getPhotoUrl();
                names.add(name);
                retrieved.add(user);

                if(retrieved.size()%2==0){

                    root = buddyTable.child(actKey).push();

                    root.child(retrieved.get(retrieved.size()-1)).child("name").setValue(names.get(names.size()-1));
                    root.child(retrieved.get(retrieved.size()-2)).child("name").setValue(names.get(names.size()-2));
                    set();
                    Toast.makeText(AttendanceSuccess.this, retrieved.get(retrieved.size()-1)+" = "
                            +retrieved.get(retrieved.size()-2), Toast.LENGTH_SHORT).show();

                }

                //usersInTempTable = tempTable.child(user);
                Log.e("charles"," Charles "+dataSnapshot.getKey());

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



         evaluateBtn = (TextView) findViewById(R.id.evaluateBtn);
        evaluateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AttendanceSuccess.this,EvaluationActivity.class).putExtra("id",keyToEvaluate));
            }
        });
    }

    private void set(){

        final ArrayList<String> namez = new ArrayList<>();
        Query query = buddyTable.child(actKey).child(root.getKey()).orderByChild("name");

        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Name name = dataSnapshot.getValue(Name.class);
                String key = dataSnapshot.getKey();

                Log.d("kobe"," key = "+key+"name "+name.getName());
                //Log.d("kobe","name "+name);
                nameList.add(name);
                keyList.add(key);
                int a = 0;
                if(nameList.size()==2){
                    for(Name n : nameList ){
                        if(n.getName().equals(User.getDisplayName())){
                            a++;

                        }else{
                           /* Query getUser = UserRoot.orderByChild("name").equalTo(n.getName());
                            Log.d("kobe","fb = "+getUser.toString());
                            getUser.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    Users user = dataSnapshot.getValue(Users.class);
                                    //Log.d("kobe","kaata "+user.getDisplayName());
                                    Log.d("kobe",user+"");
                                    Glide.with(getApplicationContext()).load((Uri.parse(user.getUri()))).into(image);

                                }

                                @Override
                                public void onCancelled(FirebaseError firebaseError) {


                                }
                            });*/
                            PersonToEvaluate = n.getName();
                            key = keyList.get(a);
                            keyToEvaluate = keyList.get(a);
                            String UniqueID = key;
                            Log.d("kobe","ang i query "+key);
                            nameLabel.setText(PersonToEvaluate);
                            Firebase query = UserF.child(key);
                            query.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    Users user = dataSnapshot.getValue(Users.class);
                                    //Log.d("kobe","kaata "+user.getUri());
                                    Glide.with(getApplicationContext()).load((Uri.parse(user.getUri()))).into(image);
                                }

                                @Override
                                public void onCancelled(FirebaseError firebaseError) {

                                }
                            });

                            Log.d("kobe",n.getName());

                        }
                    }
                }
                Log.d("kobe",name.getName());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {


            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {


            }
        });
    }
}
