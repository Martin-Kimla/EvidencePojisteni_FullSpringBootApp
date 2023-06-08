package pojisteni.app.models.dto.mappers;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pojisteni.app.data.entities.InsuredEntity;
import pojisteni.app.models.dto.InsuredDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-07T11:36:28+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class InsuredMapperImpl implements InsuredMapper {

    @Override
    public InsuredEntity toEntitiy(InsuredDTO source) {
        if ( source == null ) {
            return null;
        }

        InsuredEntity insuredEntity = new InsuredEntity();

        insuredEntity.setInsuredId( source.getInsuredId() );
        insuredEntity.setJmeno( source.getJmeno() );
        insuredEntity.setPrijmeni( source.getPrijmeni() );
        insuredEntity.setEmail( source.getEmail() );
        insuredEntity.setTelefon( source.getTelefon() );
        insuredEntity.setUlice( source.getUlice() );
        insuredEntity.setMesto( source.getMesto() );
        insuredEntity.setPsc( source.getPsc() );

        return insuredEntity;
    }

    @Override
    public InsuredDTO toDTO(InsuredEntity source) {
        if ( source == null ) {
            return null;
        }

        InsuredDTO insuredDTO = new InsuredDTO();

        insuredDTO.setInsuredId( source.getInsuredId() );
        insuredDTO.setJmeno( source.getJmeno() );
        insuredDTO.setPrijmeni( source.getPrijmeni() );
        insuredDTO.setEmail( source.getEmail() );
        insuredDTO.setTelefon( source.getTelefon() );
        insuredDTO.setUlice( source.getUlice() );
        insuredDTO.setMesto( source.getMesto() );
        insuredDTO.setPsc( source.getPsc() );

        return insuredDTO;
    }

    @Override
    public void updateInsuredDTO(InsuredDTO source, InsuredDTO target) {
        if ( source == null ) {
            return;
        }

        target.setInsuredId( source.getInsuredId() );
        target.setJmeno( source.getJmeno() );
        target.setPrijmeni( source.getPrijmeni() );
        target.setEmail( source.getEmail() );
        target.setTelefon( source.getTelefon() );
        target.setUlice( source.getUlice() );
        target.setMesto( source.getMesto() );
        target.setPsc( source.getPsc() );
    }

    @Override
    public void updateInsuredEntity(InsuredDTO source, InsuredEntity target) {
        if ( source == null ) {
            return;
        }

        target.setInsuredId( source.getInsuredId() );
        target.setJmeno( source.getJmeno() );
        target.setPrijmeni( source.getPrijmeni() );
        target.setEmail( source.getEmail() );
        target.setTelefon( source.getTelefon() );
        target.setUlice( source.getUlice() );
        target.setMesto( source.getMesto() );
        target.setPsc( source.getPsc() );
    }
}
