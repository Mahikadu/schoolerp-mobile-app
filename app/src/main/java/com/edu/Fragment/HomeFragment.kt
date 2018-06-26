package com.edu.Fragment;

import android.content.Context;
import android.os.Bundle
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView
import android.widget.Toast

import com.edu.DataModel.EduCategories;
import com.edu.R;
import kotlinx.android.synthetic.main.edu_categories.view.*

import java.util.ArrayList;

class HomeFragment : Fragment() {

    var adapter: FoodAdapter? = null
    var foodsList = ArrayList<EduCategories>()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_home, container, false)
        foodsList.add(EduCategories("Attendance", R.drawable.abc_ab_share_pack_mtrl_alpha));
        foodsList.add(EduCategories("Holidays", R.drawable.abc_cab_background_top_mtrl_alpha));
        foodsList.add(EduCategories("Registration", R.drawable.abc_ab_share_pack_mtrl_alpha));
        foodsList.add(EduCategories("Communication", R.drawable.abc_cab_background_top_mtrl_alpha));

        adapter = FoodAdapter(context, foodsList)

        view?.findViewById<GridView>(R.id.grid_view)?.adapter = adapter

        return view
    }

//    public HomeFragment() {
//        // Required empty public constructor
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
//
//        foodsList.add(EduCategories("Attendance", R.drawable.abc_ab_share_pack_mtrl_alpha));
//        foodsList.add(EduCategories("Holidays", R.drawable.abc_cab_background_top_mtrl_alpha));
//        foodsList.add(EduCategories("Registration", R.drawable.abc_ab_share_pack_mtrl_alpha));
//        foodsList.add(EduCategories("Communication", R.drawable.abc_cab_background_top_mtrl_alpha));
//
//        adapter = FoodAdapter(this, foodsList)
//
//        findViewById<GridView>(R.id.grid_view).adapter = adapter
//
//
//        // Inflate the layout for this fragment
//        return rootView;
//    }

//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//            }
//
//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//    }

//    @Override
//    public void onDetach() {
//        super.onDetach();
//    }

    class FoodAdapter : BaseAdapter
    {
        var foodsList = ArrayList<EduCategories>()
        var context: Context? = null

        constructor(context: Context, foodsList:ArrayList<EduCategories>) : super() {
        this.context = context
        this.foodsList = foodsList
    }

        override fun getCount(): Int {
        return foodsList.size
    }

        override fun getItem(position: Int): Any {
        return foodsList[position]
    }

        override fun getItemId(position: Int): Long {
        return position.toLong()
    }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val food = this.foodsList[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var foodView = inflator.inflate(R.layout.edu_categories, null)
        foodView.imgFood.setImageResource(food.image!!)
        foodView.tvName.text = food.name!!
        foodView.setOnClickListener(View.OnClickListener {
            when (position) {
                0 ->             Toast.makeText(context, "1", Toast.LENGTH_SHORT).show();
                1 ->            Toast.makeText(context, "2", Toast.LENGTH_SHORT).show();
                2 ->             Toast.makeText(context, "3", Toast.LENGTH_SHORT).show();
                3 ->             Toast.makeText(context, "4", Toast.LENGTH_SHORT).show();
            }
        })
        return foodView
    }
    }
}

//fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int) {
//    supportFragmentManager.beginTransaction().add(frameId, fragment).commit()
//}
//
//fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
//    supportFragmentManager.beginTransaction().replace(frameId, fragment).addToBackStack(fragment.toString()).commit();
//}
