package pojisteni.app.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojisteni.app.data.entities.InsuredEntity;
import pojisteni.app.data.repositories.InsuredRepository;
import pojisteni.app.models.dto.InsuredDTO;
import pojisteni.app.models.dto.mappers.InsuredMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class InsuredServiceImpl implements InsuredService {

    @Autowired
    private InsuredRepository insuredRepository;
    @Autowired
    private InsuredMapper insuredMapper;
    @Override
    public void create(InsuredDTO insured) {
        InsuredEntity newInsured = insuredMapper.toEntitiy(insured);
        insuredRepository.save(newInsured);
    }
    @Override
    public List<InsuredDTO> getAll() {
        List<InsuredDTO> insured = new ArrayList<>();
        Iterable<InsuredEntity> fetchedArticles = insuredRepository.findAll();
        for (InsuredEntity articleEntity : fetchedArticles) {
            InsuredDTO mappedArticle = insuredMapper.toDTO(articleEntity);
            insured.add(mappedArticle);
        }
        return insured;
    }
    @Override
    public InsuredDTO getById(long insuredId) {
        InsuredEntity fedchedInsured = insuredRepository
                .findById(insuredId)
                .orElseThrow();
        return insuredMapper.toDTO(fedchedInsured);
    }
    @Override
    public void edit(InsuredDTO insured) {
        InsuredEntity fetchedInsured = getInsuredOrThrow(insured.getInsuredId());

        insuredMapper.updateInsuredEntity(insured, fetchedInsured);
        insuredRepository.save(fetchedInsured);
    }
    private InsuredEntity getInsuredOrThrow(long insuredId) {
        return insuredRepository
                .findById(insuredId)
                .orElseThrow();
    }

    @Override
    public void remove(long insuredId) {
        InsuredEntity fedchedEntity = getInsuredOrThrow(insuredId);
        insuredRepository.delete(fedchedEntity);
    }
}
