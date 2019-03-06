package com.example.snapchat;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;
import java.util.List;

public class MusicFragment extends Fragment {

    public static MusicFragment newInstance(){
        MusicFragment fragment = new MusicFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_music,container,false);
        EditText v = view.findViewById(R.id.EnterSong);
        v.setText(Html.fromHtml(v.getText().toString()));
        v.setMovementMethod(LinkMovementMethod.getInstance());

        Button mlogout = view.findViewById(R.id.logout);
        Button mFindUsers = view.findViewById(R.id.findsUsers);
//        Button mCapture= view.findViewById(R.id.capture);
        mlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logout();
            }
        });
        mFindUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FindUsers();
            }
        });
        mlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logout();
            }
        });
        return view;
    }

    private void FindUsers() {

    }


    //sig
    private void Logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getContext(),SplashScreenActivity.class);

        //clear all other activities which were on top of stack
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        return;

    }
}