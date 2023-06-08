package pojisteni.app.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojisteni.app.data.entities.InsuranceEntity;
import pojisteni.app.data.repositories.InsuranceRepository;
import pojisteni.app.models.dto.ConnectionDTO;
import pojisteni.app.models.dto.InsuranceDTO;
import pojisteni.app.models.dto.mappers.InsuranceMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Autowired
    private InsuranceMapper insuranceMapper;

    @Override
    public void create(InsuranceDTO insurance) {
        InsuranceEntity newInsurance = insuranceMapper.toEntity(insurance);
        insuranceRepository.save(newInsurance);
    }

    @Override
    public List<InsuranceDTO> getAll() {
        return StreamSupport.stream(insuranceRepository.findAll().spliterator(), false)
                .map(i -> insuranceMapper.toDTO(i))
                .toList();
    }

    @Override
    public List<InsuranceDTO> getFilter(List<ConnectionDTO> connections, List<InsuranceDTO> insurances, long insuredId) {
        long insuranceId = 0;
        List<InsuranceDTO> insurancesFilter = new ArrayList<>();

        for(ConnectionDTO c : connections) {
            if(c.getInsuredId() == insuredId) {
                insuranceId = c.getInsuranceId();
                for(InsuranceDTO i : insurances) {
                    if(i.getInsuranceId() == insuranceId) {
                        insurancesFilter.add(i);
                    }
                }
            }
        }
        return insurancesFilter;
    }

    @Override
    public InsuranceDTO getById(long insuranceId) {
        InsuranceEntity fetchedInsurance = insuranceRepository
                .findById(insuranceId)
                .orElseThrow();
        return insuranceMapper.toDTO(fetchedInsurance);
    }

    @Override
    public void edit(InsuranceDTO insurance) {
        InsuranceEntity fetchedInsurance = getInsuranceOrThrow(insurance.getInsuranceId());

        insuranceMapper.updateInsuranceEntity(insurance, fetchedInsurance);
        insuranceRepository.save(fetchedInsurance);
    }

    private InsuranceEntity getInsuranceOrThrow(long insuranceId) {
        return insuranceRepository
                .findById(insuranceId)
                .orElseThrow();
    }

    @Override
    public void remove(long insuranceId) {
        InsuranceEntity fetchedEntity = getInsuranceOrThrow(insuranceId);
        insuranceRepository.delete(fetchedEntity);
    }
}
