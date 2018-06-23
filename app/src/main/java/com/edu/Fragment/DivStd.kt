package com.edu.Fragment

import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.edu.AttendanceData.GenreDataFactory
import com.edu.DataModel.Divisions
import com.edu.DataModel.Standards
import com.edu.R
import com.edu.net.APIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.app_bar_home.*
import java.util.*

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [DivStd.OnListFragmentInteractionListener] interface.
 */
class DivStd : Fragment() {

    private var columnCount = 1
    private var listener: OnListFragmentInteractionListener? = null
    private var dialog: ProgressDialog? = null;
    private lateinit var calendar: Calendar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dialog = ProgressDialog(activity)
        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
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
        return inflater.inflate(R.layout.fragment_div_std, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        toolbar.setSubtitle("" + "" + day + " " + month + ", " + year);

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

                // Toast.makeText(activity, "clicked: change data", Toast.LENGTH_SHORT).show();
            }
        });

        getView()!!.findViewById<android.support.v7.widget.Toolbar>(R.id.toolbar).setTitle("Select Division/Standard");

        val layoutManager = LinearLayoutManager(activity)
        getView()!!.findViewById<RecyclerView>(R.id.list).layoutManager = layoutManager;

        var div: List<Divisions>? = null;
        var std: List<Standards>? = null;

        APIService.create().getDivisions().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
                .subscribe({ result ->
                    div = result;

                    if (div != null) {
                        APIService.create().getStandards().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
                                .subscribe({ result ->
                                    dialog?.dismiss();
                                    std = result;
                                    if (div?.size!! > 0 && std?.size!! > 0) {
                                        getView()!!.findViewById<RecyclerView>(R.id.list).adapter = MyItemRecyclerViewAdapter(GenreDataFactory.makeSingleCheckGenres(std, div))
                                        getView()!!.findViewById<Button>(R.id.next).setOnClickListener(View.OnClickListener {
                                            listener?.onListFragmentInteraction()
                                        })
                                    } else {
                                        Log.d("Result", "There are ${div?.get(0)?.name}")
                                    }
                                }, { error ->
                                    dialog?.dismiss();
                                    error.printStackTrace()
                                });
                    }else{
                        dialog?.dismiss();
                        Toast.makeText(activity, "server is down", Toast.LENGTH_SHORT).show()
                    }
                }, { error ->
                    Log.d("ERROR", "error");
                    error.printStackTrace()
                });

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onStop() {
        super.onStop()
        dialog?.dismiss();
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
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction();
    }

    companion object {
        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
                DivStd().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_COLUMN_COUNT, columnCount)
                    }
                }
    }
}
