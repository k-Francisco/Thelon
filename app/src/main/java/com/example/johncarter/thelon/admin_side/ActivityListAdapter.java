package com.example.johncarter.thelon.admin_side;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.johncarter.thelon.R;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.StorageReference;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static com.example.johncarter.thelon.R.drawable.a;

/**
 * Created by asus on 03/12/2016.
 */

public class ActivityListAdapter extends RecyclerView.Adapter<ActivityListAdapter.ViewHolder> {
    Context context;
    int positionClicked;
    ArrayList<String> acts = new ArrayList<>();
    ArrayList<String> dates = new ArrayList<>();
    ArrayList<com.example.johncarter.thelon.models.Activity> activityList = new ArrayList<>();
    ArrayList<StorageReference>photoRef= new ArrayList<>();
    ArrayList<StorageReference> qrCode = new ArrayList<>();
    int a;

    public ActivityListAdapter(Context context, ArrayList<String> acts, ArrayList<String>dates, ArrayList<StorageReference>photoRef, ArrayList<StorageReference> qrCode,
                               ArrayList<com.example.johncarter.thelon.models.Activity> activity_list){
        this.context = context;
        this.acts = acts;
        this.dates = dates;
        this.photoRef = photoRef;
        this.qrCode = qrCode;
        this.activityList = activity_list;
        Log.e("kf","acts ="+acts.size());
        Log.e("kf","Photo Array="+photoRef.size());
        Log.e("kf","QR CODE size: " + qrCode.size());
    }



    private int[] images = {R.drawable.feed1,
            R.drawable.dental_mission};

  /*  private String[] acts = {
            "kobe"
            };

    private String[] dates = {
            "charles"
            };*/

/*
    ArrayList<String>acts = new ArrayList<String>();
    ArrayList<String>dates = new ArrayList<String>();*/

    @Override
    public ActivityListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
      //  Log.d("kobe","SDASd"+dates.size());
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final ActivityListAdapter.ViewHolder holder, int position) {
       // Glide.with(context).using(new FirebaseImageLoader()).load(photoRef.get(position)).into(holder.activityDp);

        /*int temp = position - 1;

        Uri uri = Uri.parse(photoRef.get(position));
        Log.e("key","Adapter Array Photo Size = "+uri);*/
    //    Glide.with(context).load("5457").into(holder.activityDp);
        Glide.with(context).using(new FirebaseImageLoader()).load(photoRef.get(position)).into(holder.activityDp);
        Log.d("charles","In View Holder: " + photoRef.get(position).toString());
        holder.actDate.setText(dates.get(position));
        holder.actName.setText(acts.get(position));
        positionClicked = position;


    }

    @Override
    public int getItemCount() {
     //   Firebase mroot = new Firebase("https://ethelon-33583.firebaseio.com/Activity");

        return acts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView activityDp;
        TextView actName,actDate;
        TextView editBtn, deleteBtn;
        Firebase mroot;
        public ViewHolder(final View itemView) {
            super(itemView);

/*
            mroot = new Firebase("\"https://ethelon-33583.firebaseio.com/Activity\"");
            mroot.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    if(dataSnapshot.exists()) {
                        com.example.johncarter.thelon.models.Activity activity = dataSnapshot.getValue(com.example.johncarter.thelon.models.Activity.class);
                        acts.add(activity.getN);
                    }
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
            FragmentManager fm = ((Activity)context).getFragmentManager();
            fm.beginTransaction().add(new ActivitiesFragment(),"act_frag").commit();
            fm.beginTransaction().add(new CreateActivityFragment(),"create_act_frag").commit();
            activityDp = (ImageView) itemView.findViewById(R.id.activityDp);
            actName = (TextView)itemView.findViewById(R.id.actName);
            actDate = (TextView)itemView.findViewById(R.id.actDate);
            editBtn = (TextView)itemView.findViewById(R.id.editBtn);
            deleteBtn = (TextView)itemView.findViewById(R.id.deleteBtn);

            editBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    CreateActivityFragment frag = new CreateActivityFragment();
                    FragmentManager fm = ((Activity)context).getFragmentManager();
                    Bundle args = new Bundle();
                    args.putString("editName",activityList.get(getAdapterPosition()).getActname());
                    args.putString("editDate",activityList.get(getAdapterPosition()).getActDate());
                    args.putString("editStreet",activityList.get(getAdapterPosition()).getActStreet());
                    args.putString("editCity",activityList.get(getAdapterPosition()).getActCity());
                    args.putString("editAddress",activityList.get(getAdapterPosition()).getActAddress());
                    args.putString("editTime",activityList.get(getAdapterPosition()).getActTime());
                    args.putString("ActivityKeyIfEdit",activityList.get(getAdapterPosition()).getKey());

                    args.putString("ilhanan","edit");

                    //step2
                    args.putString("editLocation",activityList.get(getAdapterPosition()).getvLocation());
                    args.putString("editGender",activityList.get(getAdapterPosition()).getvGender());
                    args.putString("editAge",activityList.get(getAdapterPosition()).getvAge());
                    args.putString("editOccupation",activityList.get(getAdapterPosition()).getvOccupation());


                  //  args.putString("pic",photoRef.get(getAdapterPosition()).getDownloadUrl().toString());


                    //step3
                    args.putString("editPersonInCharge",activityList.get(getAdapterPosition()).getPpersonInCharge());
                    args.putString("editPersonContactNumber",activityList.get(getAdapterPosition()).getPcontactNumber());
                    args.putString("editEmail",activityList.get(getAdapterPosition()).getPemailAddress());

                    frag.setArguments(args);
                    fm.beginTransaction().replace(R.id.fram2,frag).addToBackStack("act_frag").commit();

                }
            });

            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ((ViewGroup)v.getParent()).removeAllViews();
                    String activityIDtoDelete = activityList.get(getAdapterPosition()).getKey();
                    Firebase activityFirebase = new Firebase("https://ethelon-33583.firebaseio.com/Activity");
                    Firebase activityPhotosFirebase = new Firebase("https://ethelon-33583.firebaseio.com/ActivityPhotos");
                    Firebase activityQRFirebase = new Firebase("https://ethelon-33583.firebaseio.com/ActivityQR");
                    Firebase activityAttendeesBefore = new Firebase("https://ethelon-33583.firebaseio.com/ActivityAttendeesBefore");

                    activityFirebase.child(activityIDtoDelete).removeValue();
                    activityPhotosFirebase.child(activityIDtoDelete).removeValue();
                    activityQRFirebase.child(activityIDtoDelete).removeValue();
                    activityAttendeesBefore.child(activityIDtoDelete).removeValue();

                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    QrCode qr = new QrCode(qrCode.get(getAdapterPosition()));
                    FragmentManager fm = ((Activity)context).getFragmentManager();
                    AdminActivityDetails adminActivityDetails = new AdminActivityDetails();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("qrcode",qr);
                    adminActivityDetails.setArguments(bundle);
                    fm.beginTransaction().replace(R.id.fram2, adminActivityDetails).addToBackStack("act_frag").commit();
                    //adminActivityDetails.setQrCode(qrCode.get(getAdapterPosition()),context);
                    //Glide.with(context).using(new FirebaseImageLoader()).load(qrCode.get(getAdapterPosition())).into(adminActivityDetails.getQrCodeImg());
                    //adminActivityDetails.getQrCodeImg();
                    //Log.d("charles",qrCode.size() + "");
//                    Bundle bundle = new Bundle();
//                    bundle.putString("qr", qrCode.get(getAdapterPosition()).getDownloadUrl().toString());
//
//                    adminActivityDetails.setArguments(bundle);
                    //adminActivityDetails.setQrCodeImg(qrCode.get(getAdapterPosition()),context);
                }
            });
        }
    }
}
