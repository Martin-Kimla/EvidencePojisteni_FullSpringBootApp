package pojisteni.app.models.dto.mappers;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pojisteni.app.data.entities.ConnectionEntity;
import pojisteni.app.models.dto.ConnectionDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-08T11:55:32+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class ConnectionMapperImpl implements ConnectionMapper {

    @Override
    public ConnectionEntity toEntity(ConnectionDTO source) {
        if ( source == null ) {
            return null;
        }

        ConnectionEntity connectionEntity = new ConnectionEntity();

        connectionEntity.setConnectionId( source.getConnectionId() );
        connectionEntity.setInsuranceId( source.getInsuranceId() );
        connectionEntity.setInsuredId( source.getInsuredId() );

        return connectionEntity;
    }

    @Override
    public ConnectionDTO toDTO(ConnectionEntity source) {
        if ( source == null ) {
            return null;
        }

        ConnectionDTO connectionDTO = new ConnectionDTO();

        connectionDTO.setConnectionId( source.getConnectionId() );
        connectionDTO.setInsuranceId( source.getInsuranceId() );
        connectionDTO.setInsuredId( source.getInsuredId() );

        return connectionDTO;
    }
}
