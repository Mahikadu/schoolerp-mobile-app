package com.edu.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.edu.R;

public class ParentsInfoFragment extends Fragment implements View.OnClickListener {

    //father info resource
    EditText edt_fathername,edt_femail,edt_fqualification,edt_foccupation,edt_fphoneno;

    //Mother info resource
    EditText edt_mothername,edt_memail,edt_mqualification,edt_moccupation,edt_mphoneno;

    //Guardians info resource
    EditText edt_guardname,edt_gemail,edt_gqualification,edt_goccupation,edt_gphoneno;

    Button previous,next;

    public ParentsInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_parent_info, container, false);

        initResource(rootView);

        // Inflate the layout for this fragment
        return rootView;
    }

    public void initResource(View v){

        //father info resource
        edt_fathername = (EditText) v.findViewById(R.id.edt_fathername);
        edt_femail = (EditText) v.findViewById(R.id.edt_femail);
        edt_fqualification = (EditText) v.findViewById(R.id.edt_fqualification);
        edt_foccupation = (EditText) v.findViewById(R.id.edt_foccupation);
        edt_fphoneno = (EditText) v.findViewById(R.id.edt_fphoneno);

        //Mother info resource
        edt_mothername = (EditText) v.findViewById(R.id.edt_mothername);
        edt_memail = (EditText) v.findViewById(R.id.edt_memail);
        edt_mqualification = (EditText) v.findViewById(R.id.edt_mqualification);
        edt_moccupation = (EditText) v.findViewById(R.id.edt_moccupation);
        edt_mphoneno = (EditText) v.findViewById(R.id.edt_mphoneno);

        //Guardians info resource
        edt_guardname = (EditText) v.findViewById(R.id.edt_guardname);
        edt_gemail = (EditText) v.findViewById(R.id.edt_gemail);
        edt_gqualification = (EditText) v.findViewById(R.id.edt_gqualification);
        edt_goccupation = (EditText) v.findViewById(R.id.edt_goccupation);
        edt_gphoneno = (EditText) v.findViewById(R.id.edt_gphoneno);

        next = (Button) v.findViewById(R.id.btn_pnext);
        previous = (Button) v.findViewById(R.id.btn_pprevious);

        next.setOnClickListener(this);
        previous.setOnClickListener(this);

        //father info resource
        edt_fathername.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {edt_fathername.setFocusableInTouchMode(true);
                return false;
            }
        });

        edt_femail.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {edt_femail.setFocusableInTouchMode(true);
                return false;
            }
        });

        edt_fqualification.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {edt_fqualification.setFocusableInTouchMode(true);
                return false;
            }
        });

        edt_foccupation.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {edt_foccupation.setFocusableInTouchMode(true);
                return false;
            }
        });

        edt_fphoneno.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {edt_fphoneno.setFocusableInTouchMode(true);
                return false;
            }
        });

        //Mother info resource
        edt_mothername.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {edt_mothername.setFocusableInTouchMode(true);
                return false;
            }
        });

        edt_memail.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {edt_memail.setFocusableInTouchMode(true);
                return false;
            }
        });

        edt_mqualification.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {edt_mqualification.setFocusableInTouchMode(true);
                return false;
            }
        });

        edt_moccupation.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {edt_moccupation.setFocusableInTouchMode(true);
                return false;
            }
        });

        edt_mphoneno.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {edt_mphoneno.setFocusableInTouchMode(true);
                return false;
            }
        });

        //Guardians info resource
        edt_guardname.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {edt_guardname.setFocusableInTouchMode(true);
                return false;
            }
        });

        edt_gemail.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {edt_gemail.setFocusableInTouchMode(true);
                return false;
            }
        });

        edt_gqualification.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {edt_gqualification.setFocusableInTouchMode(true);
                return false;
            }
        });

        edt_goccupation.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {edt_goccupation.setFocusableInTouchMode(true);
                return false;
            }
        });

        edt_gphoneno.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {edt_gphoneno.setFocusableInTouchMode(true);
                return false;
            }
        });

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();
        switch (id) {

            case R.id.btn_pnext:

                break;

            case R.id.btn_pprevious:
                Fragment contactinfo = new ContactInfoFragment();
                FragmentManager fmp = getFragmentManager();
                FragmentTransaction ftp = fmp.beginTransaction();
                ftp.replace(R.id.container_body, contactinfo);
                ftp.commit();
                break;

        }

    }


}