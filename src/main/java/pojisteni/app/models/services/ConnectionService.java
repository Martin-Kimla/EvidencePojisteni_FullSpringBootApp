package pojisteni.app.models.services;

import pojisteni.app.models.dto.ConnectionDTO;

import java.util.List;

public interface ConnectionService {

    void create(ConnectionDTO connection);
    List<ConnectionDTO> getAllFromInsured();

    void remove(long connectionId);

}
