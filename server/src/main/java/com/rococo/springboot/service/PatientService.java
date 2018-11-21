package com.rococo.springboot.service;

import java.util.List;

import com.rococo.springboot.model.PatientModel;

public interface PatientService {
	
	public PatientModel getPatientInfo(PatientModel patientModel);	
	public List<PatientModel> getAll();
	public void registerPatient(PatientModel patientModel);
}
