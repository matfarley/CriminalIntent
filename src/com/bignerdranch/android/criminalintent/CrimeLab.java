package com.bignerdranch.android.criminalintent;

import java.util.ArrayList;
import java.util.UUID;

import android.content.Context;

public class CrimeLab {
	private static CrimeLab sCrimeLab;
	private Context mAppContext;
	private ArrayList<Crime> mCrimes;
	
	private CrimeLab(Context appContext){ //Private constructor for the singleton - only accessble from this class
		mAppContext = appContext;
		mCrimes = new ArrayList<Crime>();
		//Initial Crimes for Testing
		for(int i = 0; i < 100; i++){
			Crime c = new Crime();
			c.setTitle("Crime #" + i);
			c.setSolved(i % 2 == 0); //the result will be a boolean. Every 2nd iteration will evenly divide by 2
			mCrimes.add(c);
		}
	}
	
	public static CrimeLab get(Context c){ //Only way to instantiate the singleton from outside. Can only ever be one instance.
		if(sCrimeLab == null){
			sCrimeLab = new CrimeLab(c.getApplicationContext());
		}
		return sCrimeLab;
	}
	
	public ArrayList<Crime> getCrimes(){
		return mCrimes;
	}
	
	public Crime getCrime(UUID id){
		for(Crime c : mCrimes){
			if(c.getId().equals(id))
				return c;
		}
				return null;
	}

}
