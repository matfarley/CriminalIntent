package com.bignerdranch.android.criminalintent;

import java.util.UUID;

import android.support.v4.app.Fragment;

//Need to extend fragment activity to allow for compatibility with Froyo.
public class CrimeActivity extends SingleFragmentActivity { 

    @Override
    protected Fragment createFragment(){
    	UUID crimeId = (UUID)getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
    	
    	return CrimeFragment.newInstance(crimeId);
	
    }


}
