package com.example.mototest.View.Admin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mototest.Api.Alltest;
import com.example.mototest.Api.ApiService;
import com.example.mototest.Api.Status;
import com.example.mototest.Model.Test;
import com.example.mototest.R;
import com.example.mototest.View.Test.TestAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link testmanager#newInstance} factory method to
 * create an instance of this fragment.
 */
public class testmanager extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ArrayList<String> testArrayList = new ArrayList<String>();
    TestAdapter testAdapter;
    private ImageView img_delTest;
    // TODO: Rename and change types of parameters
    private String mParam1;



    private String mParam2;
    private Button btn_addtest;
    public testmanager() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static testmanager newInstance(String param1, String param2) {
        testmanager fragment = new testmanager();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_testmanager, container, false);
        btn_addtest = (Button) v.findViewById(R.id.btn_addtest);
        btn_addtest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                createTest();
//                NavController navController = Navigation.findNavController(v);
//                navController.navigate(R.id.action_testmanager_to_infotest);

            }
        });

        ListView lv_test = v.findViewById(R.id.lv_testmanager);
        ApiService.apiservice.getAllTest("getAllTest").enqueue(new Callback<Alltest>() {
            @Override
            public void onResponse(Call<Alltest> call, Response<Alltest> response) {
//                lv_test=(ListView)getActivity().findViewById(R.id.lv_test);
//                Toast.makeText(getContext(), "Call API SUCCESS", Toast.LENGTH_SHORT).show();
                Alltest alltest=response.body();
                ArrayList<Test> allidTest=alltest.getAllTest();
//                Log.e("testid 1:",Integer.toString(alltest.getAllTest().get(0).getIdtest()));
                for(Test t : allidTest)
                {
                    testArrayList.add(Integer.toString(t.getIdtest()));
                }
                testAdapter=new TestAdapter(getActivity(),testArrayList);
                lv_test.setAdapter(testAdapter);
                lv_test.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if(!testAdapter.isdel){
                            Toast.makeText(getContext(), "Chuyen huong sang detail", Toast.LENGTH_SHORT).show();
                            NavDirections action = testmanagerDirections.actionTestmanagerToQuestionmanager(testArrayList.get(position));
                            NavController navController = Navigation.findNavController(v);
                            navController.navigate(action);
                        }
                    }
                });


                Toast.makeText(getContext(), "Call API get test 1 lan", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<Alltest> call, Throwable t) {
                Toast.makeText(getContext(), "Call API FAIL", Toast.LENGTH_SHORT).show();
            }

    });
        return v;
    }

    private void createTest(){
        ApiService.apiservice.querryTest("createTest","-1","0").enqueue(new Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {
                Toast.makeText(getContext(),"Tao thanh cong",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {
                Toast.makeText(getContext(),"Tao that bai",Toast.LENGTH_SHORT).show();
            }
        });
    }


}