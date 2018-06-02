package be.edenglen.tournament.ws.www.dto.datatable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableDataTableOrderDTO.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface DataTableOrderDTO {
    Integer getColumn();
    String getDir();
}
