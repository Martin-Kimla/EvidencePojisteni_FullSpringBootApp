package pojisteni.app.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojisteni.app.data.entities.ConnectionEntity;
import pojisteni.app.data.entities.InsuranceEntity;
import pojisteni.app.data.entities.InsuredEntity;
import pojisteni.app.data.repositories.ConnectionRepository;
import pojisteni.app.data.repositories.InsuredRepository;
import pojisteni.app.models.dto.ConnectionDTO;
import pojisteni.app.models.dto.mappers.ConnectionMapper;
import pojisteni.app.models.dto.mappers.InsuredMapper;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ConnectionServiceImpl implements ConnectionService {

    @Autowired
    private ConnectionMapper connectionMapper;
    @Autowired
    private ConnectionRepository connectionRepository;

    @Override
    public void create(ConnectionDTO connection) {

        ConnectionEntity newConnection = connectionMapper.toEntity(connection);
        connectionRepository.save(newConnection);
    }

    @Override
    public List<ConnectionDTO> getAllFromInsured() {
        return StreamSupport.stream(connectionRepository.findAll().spliterator(), false)
                .map(i -> connectionMapper.toDTO(i))
                .toList();
    }

    private ConnectionEntity getConnectionOrThrow(long connectionId) {
        return connectionRepository
                .findById(connectionId)
                .orElseThrow();
    }

    @Override
    public void remove(long connectionId) {
        ConnectionEntity fetchedEntity = getConnectionOrThrow(connectionId);
        connectionRepository.delete(fetchedEntity);
    }
}
