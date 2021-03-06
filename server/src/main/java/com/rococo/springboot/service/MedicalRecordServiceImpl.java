package com.rococo.springboot.service;

import com.rococo.springboot.model.DiseaseModel;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rococo.springboot.model.MedicalRecordModel;
import com.rococo.springboot.model.MedicineModel;
import com.rococo.springboot.model.RecordMedicineAssoc;
import com.rococo.springboot.repository.MedicalRecordRepository;
import com.rococo.springboot.repository.RecordMedicineAssocRepository;
import java.util.Iterator;

@Service
public class MedicalRecordServiceImpl {

	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private MedicalRecordRepository medRecordRepository;
        
        @Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private RecordMedicineAssocRepository recordMedicineRepository;
        

	public MedicalRecordModel getMedicalRecordInfo(int given) {
            MedicalRecordModel result = medRecordRepository.findById(given).get();
            return result;
	}
        
        public void removeMedicalRecordInfo(MedicalRecordModel medicine){
//            for (Record) {
//                RecordMedicineAssoc some = iterator.next();
//                List<DiseaseModel> disease = medicine.getDisease();
//                for (int x=0; x<disease.size(); x++) {
//                    for (MedicineModel pop : disease.get(x).getMeds()) {
//                        if (some.getMed().equals(pop) &&
//                            some.getRecord().equals(medicine)) {
//                            iterator.remove();
//                            recordMedicineRepository.delete(some);
//                        }
//                    }
//                }
//            }
            medRecordRepository.deleteById(medicine.getId());
        }
        

	public List<MedicalRecordModel> getAll() {
		List<MedicalRecordModel> list = new ArrayList<>();
		medRecordRepository.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	/* (non-Javadoc)
	 * @see com.rococo.springboot.service.PersonService#registerPerson(com.rococo.springboot.model.MedicalRecordModel)
	 */
	public void registerMedicine(MedicalRecordModel medRecordModel) {
                DiseaseModel disease = medRecordModel.getDisease();
                medRecordRepository.save(medRecordModel);
                    for (MedicineModel pop : disease.getMeds()) {                        
                        RecordMedicineAssoc give = new RecordMedicineAssoc(medRecordModel, pop);                        
                        recordMedicineRepository.save(give);
                    }		
	}
        
        public void updateMedicine(MedicalRecordModel medRecordModel) {
//                List<DiseaseModel> disease = medRecordModel.getDisease();
//                for (int x=0; x<disease.size(); x++) {
//                    for (MedicineModel pop : disease.get(x).getMeds()) {                         
////                        recordMedicineRepository.save(pop);
//                    }
//                }
//		medRecordRepository.save(medRecordModel);
	}

}
