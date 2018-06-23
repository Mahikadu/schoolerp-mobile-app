package com.edu.Fragment

import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.edu.DataModel.Student
import com.edu.R
import com.edu.adapter.StudentAdapter
import com.edu.net.APIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.app_bar_home.*
import kotlinx.android.synthetic.main.content_home.*
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [Attendance.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [Attendance.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class Attendance : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    private lateinit var calendar: Calendar
    private var dialog:ProgressDialog? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dialog = ProgressDialog(activity)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onResume() {
        super.onResume()
        dialog?.setMessage("Please wait")
        dialog?.setTitle("Loading")
        dialog?.setCancelable(false)
        dialog?.isIndeterminate = true
        dialog?.show()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        toolbar.setTitle("Attendance");

        // APIService.create().getEmployees().registerObserver()
        APIService.create().getEmployees().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
                .subscribe({ result ->
                    Log.d("Result", "There are ${result.get(0).firstName} Java developers in Lagos")
                    Log.d("Result", "There are ${result.count()} Java developers in Lagos")

                }, { error ->
                    error.printStackTrace()
                });

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val tv = activity.findViewById<TextView>(R.id.tv_date)


        activity.findViewById<ImageButton>(R.id.action_change_date).setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val dpd = DatePickerDialog(activity, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    // Display Selected date in textbox
//                    Toast.makeText(this@HomeActivity, "" + dayOfMonth + " " + monthOfYear + ", " + year, Toast.LENGTH_SHORT).show();
                    toolbar.setSubtitle("" + "" + dayOfMonth + " " + monthOfYear + ", " + year);
                    //lblDate.setText("" + dayOfMonth + " " + MONTHS[monthOfYear] + ", " + year)
                }, year, month, day)
                dpd.show()

                Toast.makeText(activity, "clicked: change data", Toast.LENGTH_SHORT).show();
            }
        });

        rv_students.layoutManager = LinearLayoutManager(activity);
        rv_students.hasFixedSize();

        var students :List<Student>? = null;

        APIService.create().getStudents(5, 9).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
                .subscribe({ result ->
                    dialog?.dismiss();
                    students = result;
                    if(students !=null) {
                        rv_students.adapter = StudentAdapter(result, { student: Student -> studentClicked(student) })
//                        getView()!!.findViewById<RecyclerView>(R.id.list).adapter = MyItemRecyclerViewAdapter(GenreDataFactory.makeSingleCheckGenres(std, div))
                        getView()!!.findViewById<Button>(R.id.submit).setOnClickListener(View.OnClickListener {
                            //listener?.onListFragmentInteraction()
                            Toast.makeText(activity, "Attendance submitted successfully", Toast.LENGTH_SHORT).show()

                        })
//                    } else {
//                        Log.d("Result", "There are ${div?.get(0)?.name}")
//                    }
                    }else{
                        dialog?.dismiss();
                        Toast.makeText(activity, "server is down", Toast.LENGTH_SHORT).show()
                    }
                    }, { error ->
                    dialog?.dismiss();
                    error.printStackTrace()
                });


//        var testData = createTestData();



    }

    override fun onStop() {
        super.onStop()
        dialog?.dismiss();
    }


    private fun studentClicked(student: Student) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Toast.makeText(activity, "clicked: ${student.firstName}", Toast.LENGTH_SHORT).show();
    }

//    private fun createTestData(): List<Student> {
//        var partList = ArrayList<Student>()
//        partList.add(Student(0, "Prasad", false));
//        partList.add(Student(1, "Yuvraj", false));
//        partList.add(Student(2, "Jayesh", false));
//        return partList;
//    }


    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Attendance.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                Attendance().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
