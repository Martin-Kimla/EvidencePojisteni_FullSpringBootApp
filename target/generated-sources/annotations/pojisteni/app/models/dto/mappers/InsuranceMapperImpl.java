package pojisteni.app.models.dto.mappers;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pojisteni.app.data.entities.InsuranceEntity;
import pojisteni.app.models.dto.InsuranceDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-07T20:15:55+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class InsuranceMapperImpl implements InsuranceMapper {

    @Override
    public InsuranceEntity toEntity(InsuranceDTO source) {
        if ( source == null ) {
            return null;
        }

        InsuranceEntity insuranceEntity = new InsuranceEntity();

        insuranceEntity.setInsuranceId( source.getInsuranceId() );
        insuranceEntity.setInsuranceTitle( source.getInsuranceTitle() );
        insuranceEntity.setInsuranceAmount( source.getInsuranceAmount() );
        insuranceEntity.setInsuranceType( source.getInsuranceType() );
        insuranceEntity.setValidFrom( source.getValidFrom() );
        insuranceEntity.setValidTo( source.getValidTo() );

        return insuranceEntity;
    }

    @Override
    public InsuranceDTO toDTO(InsuranceEntity source) {
        if ( source == null ) {
            return null;
        }

        InsuranceDTO insuranceDTO = new InsuranceDTO();

        insuranceDTO.setInsuranceTitle( source.getInsuranceTitle() );
        insuranceDTO.setInsuranceAmount( source.getInsuranceAmount() );
        insuranceDTO.setInsuranceType( source.getInsuranceType() );
        insuranceDTO.setValidFrom( source.getValidFrom() );
        insuranceDTO.setValidTo( source.getValidTo() );
        insuranceDTO.setInsuranceId( source.getInsuranceId() );

        return insuranceDTO;
    }

    @Override
    public void updateInsuranceDTO(InsuranceDTO source, InsuranceDTO target) {
        if ( source == null ) {
            return;
        }

        target.setInsuranceTitle( source.getInsuranceTitle() );
        target.setInsuranceAmount( source.getInsuranceAmount() );
        target.setInsuranceType( source.getInsuranceType() );
        target.setValidFrom( source.getValidFrom() );
        target.setValidTo( source.getValidTo() );
        target.setInsuranceId( source.getInsuranceId() );
    }

    @Override
    public void updateInsuranceEntity(InsuranceDTO source, InsuranceEntity target) {
        if ( source == null ) {
            return;
        }

        target.setInsuranceId( source.getInsuranceId() );
        target.setInsuranceTitle( source.getInsuranceTitle() );
        target.setInsuranceAmount( source.getInsuranceAmount() );
        target.setInsuranceType( source.getInsuranceType() );
        target.setValidFrom( source.getValidFrom() );
        target.setValidTo( source.getValidTo() );
    }
}
