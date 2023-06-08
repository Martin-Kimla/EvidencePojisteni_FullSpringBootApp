package pojisteni.app.models.services;

import pojisteni.app.models.dto.ConnectionDTO;
import pojisteni.app.models.dto.InsuranceDTO;

import java.util.List;

public interface InsuranceService {

    void create(InsuranceDTO insuranceDTO);
    List<InsuranceDTO> getAll();
    List<InsuranceDTO> getFilter(List<ConnectionDTO> connections, List<InsuranceDTO> insurances, long insuredId);
    InsuranceDTO getById(long insuranceId);
    void edit(InsuranceDTO insurance);
    void remove(long insuranceId);

}
