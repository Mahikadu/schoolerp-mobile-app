package com.edu.Fragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.edu.R;

public class ContactInfoFragment extends Fragment implements View.OnClickListener{

    EditText edt_paddress,edt_corsaddress,edt_country,edt_state,edt_city,edt_pincode,edt_doctername,edt_docterno;

    Button previous,next;

    public ContactInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_contact_info, container, false);

        initResource(rootView);

        // Inflate the layout for this fragment
        return rootView;
    }

    public void initResource(View v){

        edt_paddress = (EditText) v.findViewById(R.id.edt_paddress);
        edt_corsaddress = (EditText) v.findViewById(R.id.edt_corsaddress);
        edt_country = (EditText) v.findViewById(R.id.edt_country);
        edt_state = (EditText) v.findViewById(R.id.edt_state);
        edt_city = (EditText) v.findViewById(R.id.edt_city);
        edt_pincode = (EditText) v.findViewById(R.id.edt_pincode);
        edt_doctername = (EditText) v.findViewById(R.id.edt_doctername);
        edt_docterno = (EditText) v.findViewById(R.id.edt_docterno);

        next = (Button) v.findViewById(R.id.btn_cnext);
        previous = (Button) v.findViewById(R.id.btn_cprevious);

        next.setOnClickListener(this);
        previous.setOnClickListener(this);

        edt_paddress.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {edt_paddress.setFocusableInTouchMode(true);
                return false;
            }
        });

        edt_corsaddress.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {edt_corsaddress.setFocusableInTouchMode(true);
                return false;
            }
        });

        edt_city.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {edt_city.setFocusableInTouchMode(true);
                return false;
            }
        });

        edt_pincode.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {edt_pincode.setFocusableInTouchMode(true);
                return false;
            }
        });

        edt_doctername.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {edt_doctername.setFocusableInTouchMode(true);
                return false;
            }
        });

        edt_docterno.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {edt_docterno.setFocusableInTouchMode(true);
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

            case R.id.btn_cnext:
                break;

            case R.id.btn_cprevious:
                break;

        }
    }
}
