package com.rococo.springboot.service;

import java.util.List;

import com.rococo.springboot.model.PatientModel;

public interface PatientService {
	
	public PatientModel getPersonInfo(PatientModel patientModel);	
	public List<PatientModel> getAll();
	public void registerPerson(PatientModel patientModel);
}
