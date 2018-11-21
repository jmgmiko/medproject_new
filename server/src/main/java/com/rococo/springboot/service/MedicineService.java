package com.rococo.springboot.service;

import java.util.List;

import com.rococo.springboot.model.MedicineModel;

public interface MedicineService {
	
	public MedicineModel getMedicineInfo(MedicineModel patientModel);	
	public List<MedicineModel> getAll();
	public void registerMedicine(MedicineModel patientModel);
}
