package pojisteni.app.models.dto.mappers;

import org.mapstruct.Mapper;
import pojisteni.app.data.entities.ConnectionEntity;
import pojisteni.app.data.entities.InsuredEntity;
import pojisteni.app.models.dto.ConnectionDTO;
import pojisteni.app.models.dto.InsuredDTO;

@Mapper(componentModel = "spring")
public interface ConnectionMapper {

    ConnectionEntity toEntity(ConnectionDTO source);
    ConnectionDTO toDTO(ConnectionEntity source);

}
