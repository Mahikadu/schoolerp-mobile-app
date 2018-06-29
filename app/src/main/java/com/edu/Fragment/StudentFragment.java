package com.edu.Fragment;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.edu.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class StudentFragment extends Fragment implements View.OnClickListener{

    AutoCompleteTextView spin_acdyear,spin_blood,spin_category,spin_std,spin_div;

    EditText edt_rollno,edt_fname,edt_mname,edt_lname,edt_dob,edt_religion,edt_cast,edt_nationality;

    RadioGroup radio_gr;
    RadioButton rb_male, rb_female;
    boolean male = false, female = false;

    Button next;
    DatePickerDialog datePickerDialog;

    String[] strAcedamicYear = null;
    String[] strBloodGroup = null;
    String[] strCategory = null;
    String[] strStandard = null;
    String[] strDivision = null;

    public StudentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_student, container, false);

        initResource(rootView);

        // Inflate the layout for this fragment
        return rootView;
    }

    public void initResource(View v){

        edt_rollno = (EditText) v.findViewById(R.id.edt_rollno);
        edt_fname = (EditText) v.findViewById(R.id.edt_fname);
        edt_mname = (EditText) v.findViewById(R.id.edt_mname);
        edt_lname = (EditText) v.findViewById(R.id.edt_lname);
        edt_dob = (EditText) v.findViewById(R.id.edt_dob);
        edt_religion = (EditText) v.findViewById(R.id.edt_religion);
        edt_cast = (EditText) v.findViewById(R.id.edt_cast);
        edt_nationality = (EditText) v.findViewById(R.id.edt_nationality);

        spin_acdyear = (AutoCompleteTextView) v.findViewById(R.id.spin_acdyear);
        spin_blood = (AutoCompleteTextView) v.findViewById(R.id.spin_blood);
        spin_category = (AutoCompleteTextView) v.findViewById(R.id.spin_category);
        spin_std = (AutoCompleteTextView) v.findViewById(R.id.spin_std);
        spin_div = (AutoCompleteTextView) v.findViewById(R.id.spin_div);

        radio_gr = (RadioGroup) v.findViewById(R.id.radio_gr);
        rb_male = (RadioButton) v.findViewById(R.id.rb_male);
        rb_female = (RadioButton) v.findViewById(R.id.rb_female);

        next = (Button) v.findViewById(R.id.btn_next);

        next.setOnClickListener(this);
        edt_dob.setOnClickListener(this);


        edt_rollno.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {edt_rollno.setFocusableInTouchMode(true);
                return false;
            }
        });

        edt_fname.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {edt_fname.setFocusableInTouchMode(true);
                return false;
            }
        });

        edt_mname.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {edt_mname.setFocusableInTouchMode(true);
                return false;
            }
        });

        edt_lname.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {edt_lname.setFocusableInTouchMode(true);
                return false;
            }
        });

        edt_religion.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {edt_religion.setFocusableInTouchMode(true);
                return false;
            }
        });

        edt_cast.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {edt_cast.setFocusableInTouchMode(true);
                return false;
            }
        });


        radio_gr.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_male:
                        male = true;
                        female = false;
                        break;

                    case R.id.rb_female:
                        female = true;
                        male = false;
                        break;
                }
            }
        });

        spin_acdyear.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (spin_acdyear.length() > 0) {
                    spin_acdyear.setError(null);
                }

            }
        });

        strAcedamicYear = getResources().getStringArray(R.array.acadamicyear);

        if (strAcedamicYear != null && strAcedamicYear.length > 0) {
            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, strAcedamicYear) {
                @Override
                public View getDropDownView(int position, View convertView, ViewGroup parent) {
                    View v = null;
                    // If this is the initial dummy entry, make it hidden
                    if (position == 0) {
                        TextView tv = new TextView(getContext());
                        tv.setHeight(0);
                        tv.setVisibility(View.GONE);
                        v = tv;
                    } else {
                        // Pass convertView as null to prevent reuse of special case views
                        v = super.getDropDownView(position, null, parent);
                    }
                    // Hide scroll bar because it appears sometimes unnecessarily, this does not prevent scrolling
                    parent.setVerticalScrollBarEnabled(false);
                    return v;
                }
            };

            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spin_acdyear.setAdapter(adapter1);
        }

        spin_acdyear.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                spin_acdyear.showDropDown();
                return false;
            }
        });

        spin_acdyear.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (strAcedamicYear != null && strAcedamicYear.length > 0) {

                    String selected_acadyear = parent.getItemAtPosition(position).toString();

                }
            }
        });

        spin_blood.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (spin_blood.length() > 0) {
                    spin_blood.setError(null);
                }

            }
        });

        strBloodGroup = getResources().getStringArray(R.array.bloodgroup);

        if (strBloodGroup != null && strBloodGroup.length > 0) {
            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, strBloodGroup) {
                @Override
                public View getDropDownView(int position, View convertView, ViewGroup parent) {
                    View v = null;
                    // If this is the initial dummy entry, make it hidden
                    if (position == 0) {
                        TextView tv = new TextView(getContext());
                        tv.setHeight(0);
                        tv.setVisibility(View.GONE);
                        v = tv;
                    } else {
                        // Pass convertView as null to prevent reuse of special case views
                        v = super.getDropDownView(position, null, parent);
                    }
                    // Hide scroll bar because it appears sometimes unnecessarily, this does not prevent scrolling
                    parent.setVerticalScrollBarEnabled(false);
                    return v;
                }
            };

            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spin_blood.setAdapter(adapter1);
        }

        spin_blood.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                spin_blood.showDropDown();
                return false;
            }
        });

        spin_blood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (strBloodGroup != null && strBloodGroup.length > 0) {

                     String selected_bloodgrp = parent.getItemAtPosition(position).toString();

                }
            }
        });

        spin_category.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (spin_category.length() > 0) {
                    spin_category.setError(null);
                }

            }
        });

        strCategory = getResources().getStringArray(R.array.category);

        if (strCategory != null && strCategory.length > 0) {
            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, strCategory) {
                @Override
                public View getDropDownView(int position, View convertView, ViewGroup parent) {
                    View v = null;
                    // If this is the initial dummy entry, make it hidden
                    if (position == 0) {
                        TextView tv = new TextView(getContext());
                        tv.setHeight(0);
                        tv.setVisibility(View.GONE);
                        v = tv;
                    } else {
                        // Pass convertView as null to prevent reuse of special case views
                        v = super.getDropDownView(position, null, parent);
                    }
                    // Hide scroll bar because it appears sometimes unnecessarily, this does not prevent scrolling
                    parent.setVerticalScrollBarEnabled(false);
                    return v;
                }
            };

            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spin_category.setAdapter(adapter1);
        }

        spin_category.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                spin_category.showDropDown();
                return false;
            }
        });

        spin_category.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (strCategory != null && strCategory.length > 0) {

                    String selected_category = parent.getItemAtPosition(position).toString();

                }
            }
        });

        spin_std.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (spin_std.length() > 0) {
                    spin_std.setError(null);
                }

            }
        });


        strStandard = getResources().getStringArray(R.array.standard);

        if (strStandard != null && strStandard.length > 0) {
            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, strStandard) {
                @Override
                public View getDropDownView(int position, View convertView, ViewGroup parent) {
                    View v = null;
                    // If this is the initial dummy entry, make it hidden
                    if (position == 0) {
                        TextView tv = new TextView(getContext());
                        tv.setHeight(0);
                        tv.setVisibility(View.GONE);
                        v = tv;
                    } else {
                        // Pass convertView as null to prevent reuse of special case views
                        v = super.getDropDownView(position, null, parent);
                    }
                    // Hide scroll bar because it appears sometimes unnecessarily, this does not prevent scrolling
                    parent.setVerticalScrollBarEnabled(false);
                    return v;
                }
            };

            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spin_std.setAdapter(adapter1);
        }

        spin_std.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                spin_std.showDropDown();
                return false;
            }
        });

        spin_std.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (strStandard != null && strStandard.length > 0) {

                    String selected_standard = parent.getItemAtPosition(position).toString();

                }
            }
        });


        spin_div.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (spin_div.length() > 0) {
                    spin_div.setError(null);
                }

            }
        });

        strDivision = getResources().getStringArray(R.array.division);

        if (strDivision != null && strDivision.length > 0) {
            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, strDivision) {
                @Override
                public View getDropDownView(int position, View convertView, ViewGroup parent) {
                    View v = null;
                    // If this is the initial dummy entry, make it hidden
                    if (position == 0) {
                        TextView tv = new TextView(getContext());
                        tv.setHeight(0);
                        tv.setVisibility(View.GONE);
                        v = tv;
                    } else {
                        // Pass convertView as null to prevent reuse of special case views
                        v = super.getDropDownView(position, null, parent);
                    }
                    // Hide scroll bar because it appears sometimes unnecessarily, this does not prevent scrolling
                    parent.setVerticalScrollBarEnabled(false);
                    return v;
                }
            };

            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spin_div.setAdapter(adapter1);
        }

        spin_div.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                spin_div.showDropDown();
                return false;
            }
        });

        spin_div.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (strDivision != null && strDivision.length > 0) {

                    String selected_division = parent.getItemAtPosition(position).toString();

                }
            }
        });

        final Calendar newCalendar = Calendar.getInstance();
        final DateFormat dateFormatter = new SimpleDateFormat("MM-dd-yyyy");
        datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int monthOfYear, int dayOfMonth, int year) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(monthOfYear, dayOfMonth, year);
                edt_dob.setText(dateFormatter.format(newDate.getTime()));

            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setCalendarViewShown(false);

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

            case R.id.btn_next:

                Fragment contactinfo = new ContactInfoFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container_body, contactinfo);
                ft.commit();
                /*Intent i = new Intent(getActivity(),ContactInfoFragment.class);
                getActivity().startActivity(i);
                getActivity().finish();*/
                break;

            case R.id.edt_dob:
                datePickerDialog.show();
                break;

        }

    }
}