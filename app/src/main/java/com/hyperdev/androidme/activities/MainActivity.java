package com.hyperdev.androidme.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.hyperdev.androidme.R;
import com.hyperdev.androidme.data.AndroidImageAssets;
import com.hyperdev.androidme.activities.fragments.BodyPartFragment;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {

            BodyPartFragment headPartFragment = new BodyPartFragment();
            headPartFragment.setPartList(AndroidImageAssets.getHeads());
            int headPosition = getIntent().getIntExtra("headPosition", 0);
            headPartFragment.setListPosition(headPosition);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.head_part, headPartFragment)
                    .commit();



            BodyPartFragment bodyPartFragment = new BodyPartFragment();
            bodyPartFragment.setPartList(AndroidImageAssets.getBodies());
            int bodyPosition = getIntent().getIntExtra("bodyPosition", 0);
            bodyPartFragment.setListPosition(bodyPosition);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.body_part, bodyPartFragment)
                    .commit();



            BodyPartFragment legPartFragment = new BodyPartFragment();
            legPartFragment.setPartList(AndroidImageAssets.getLegs());
            int legPosition = getIntent().getIntExtra("legsPosition", 0);
            legPartFragment.setListPosition(legPosition);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.legs_part, legPartFragment)
                    .commit();


        }
    }
}
