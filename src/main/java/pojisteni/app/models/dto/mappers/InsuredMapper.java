package pojisteni.app.models.dto.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import pojisteni.app.data.entities.InsuredEntity;
import pojisteni.app.models.dto.InsuredDTO;

@Mapper(componentModel = "spring")
public interface InsuredMapper {
    InsuredEntity toEntitiy(InsuredDTO source);
    InsuredDTO toDTO(InsuredEntity source);
    void updateInsuredDTO(InsuredDTO source, @MappingTarget InsuredDTO target);
    void updateInsuredEntity(InsuredDTO source, @MappingTarget InsuredEntity target);
}
