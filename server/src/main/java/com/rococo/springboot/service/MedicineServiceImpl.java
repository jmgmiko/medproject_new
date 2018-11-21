package com.rococo.springboot.service;

import com.rococo.springboot.model.MedicalRecordModel;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rococo.springboot.model.MedicineModel;
import com.rococo.springboot.repository.MedicineRepository;

@Service
public class MedicineServiceImpl implements MedicineService {

	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private MedicineRepository patientRepository;

	@Override
	public MedicineModel getMedicineInfo(MedicineModel patientModel) {
		return patientRepository.findById(patientModel.getId()).get();
	}

	@Override
	public List<MedicineModel> getAll() {
		List<MedicineModel> list = new ArrayList<>();
		patientRepository.findAll().iterator().forEachRemaining(list::add);
		return list;
	}
        
        public void removeMedicine(MedicineModel medicine){
            patientRepository.deleteById(medicine.getId());
        }
        
        public MedicineModel getByName(String name) {
            return patientRepository.findByName(name);
        }

	/* (non-Javadoc)
	 * @see com.rococo.springboot.service.PersonService#registerPerson(com.rococo.springboot.model.MedicineModel)
	 */
	@Override
	public void registerMedicine(MedicineModel patientModel) {
		patientRepository.save(patientModel);
	}

}
