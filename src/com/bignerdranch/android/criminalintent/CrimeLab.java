package com.bignerdranch.android.criminalintent;

import java.util.ArrayList;
import java.util.UUID;

import android.content.Context;

public class CrimeLab {
	private static CrimeLab sCrimeLab;
	private Context mAppContext;
	private ArrayList<Crime> mCrimes;
	
	private CrimeLab(Context appContext){ //Private constructor for the singleton - only accessible from this class
		mAppContext = appContext;
		mCrimes = new ArrayList<Crime>();
		
	}
	
	public static CrimeLab get(Context c){ //Only way to instantiate the singleton from outside. Can only ever be one instance.
		if(sCrimeLab == null){
			sCrimeLab = new CrimeLab(c.getApplicationContext());
		}
		return sCrimeLab;
	}
	
	public void addCrime(Crime c){
		mCrimes.add(c);
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
