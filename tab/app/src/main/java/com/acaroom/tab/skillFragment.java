package com.acaroom.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class skillFragment extends Fragment {

    public skillFragment() {
        // Required empty public constructor
    }
    private ArrayList<String> mList;
    private ListView mListView;;
    private ArrayAdapter mAdapter;
    Button btn_ok;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_skill, container,false);

        mList = new ArrayList<String>();
        mListView= (ListView) view.findViewById(R.id.list_item);
        mAdapter =  new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_single_choice, mList);
        mListView.setAdapter(mAdapter);
        mList.add("서울대FC");
        mList.add("연세대FC");
        mList.add("고려대FC");

        btn_ok= (Button) view.findViewById(R.id.btn_ok);

        btn_ok.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                int count, checked ;
                count = mAdapter.getCount() ;

                if (count > 0) {
                    // 현재 선택된 아이템의 position 획득.
                    checked = mListView.getCheckedItemPosition();
                    if (checked > -1 && checked < count) {
                        // 아이템 수정
                        String str = mList.get(checked);
                        mList.set(checked, str + "     - 수락된 메시지") ;

                        // listview 갱신
                        mAdapter.notifyDataSetChanged();
                    }
                    else {
                        Toast.makeText(getContext(), "수락/삭제할 메시지를 선택해주십시오.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        return view;
    }
}
