package be.edenglen.tournament.ws.www.dto.datatable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
@JsonDeserialize(as = ImmutableDataTableRequestDTO.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface DataTableRequestDTO {
    Integer getDraw();
    Integer getStart();
    Integer getLength();
    List<DataTableOrderDTO> getOrder();
}
