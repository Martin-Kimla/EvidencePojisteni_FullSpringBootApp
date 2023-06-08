package pojisteni.app.models.dto.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import pojisteni.app.data.entities.InsuranceEntity;
import pojisteni.app.models.dto.InsuranceDTO;

@Mapper(componentModel = "spring")
public interface InsuranceMapper {

    InsuranceEntity toEntity(InsuranceDTO source);
    InsuranceDTO toDTO(InsuranceEntity source);
    void updateInsuranceDTO(InsuranceDTO source, @MappingTarget InsuranceDTO target);

    void updateInsuranceEntity(InsuranceDTO source, @MappingTarget InsuranceEntity target);
}
