package com.hyperdev.androidme.activities.fragments;

/**
 * Created by Jef on 9/8/2017.
 */

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.hyperdev.androidme.R;
import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {

    private List<Integer> mPartNumber;
    private int mListPosition;
    private static final String PARTS_LIST = "parts_list";
    private static final String PARTS_NUMBER = "parts_number";
    public BodyPartFragment(){}


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        if(savedInstanceState != null){
            mPartNumber = savedInstanceState.getIntegerArrayList(PARTS_LIST);
            mListPosition = savedInstanceState.getInt(PARTS_NUMBER);
        }
        View rootView = inflater.inflate(R.layout.fragmentbodypart, container, false);

        final ImageView imageView = (ImageView) rootView.findViewById(R.id.imageFrag);
        if(mPartNumber !=null){
            imageView.setImageResource(mPartNumber.get(mListPosition));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mListPosition < mPartNumber.size()-1){
                        mListPosition++;
                    }else {
                        mListPosition = 0;
                    }
                    imageView.setImageResource(mPartNumber.get(mListPosition));
                }
            });
        }
        return rootView;
    }

    public void setPartList(List<Integer> partList) {

        this.mPartNumber = partList;
    }

    public void setListPosition(int mListPosition) {

        this.mListPosition = mListPosition;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList(PARTS_LIST, (ArrayList<Integer>) mPartNumber);
        outState.putInt(PARTS_NUMBER,mListPosition);
    }
}

