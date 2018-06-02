package be.edenglen.tournament.ws.www.dto.datatable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;
import org.springframework.lang.Nullable;

import java.util.List;

@Value.Immutable
@JsonDeserialize(as = ImmutableDataTableResponseDTO.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface DataTableResponseDTO {
    Integer getDraw();
    Integer getRecordsTotal();
    Integer getRecordsFiltered();
    List<Object> getData();
    @Nullable
    String getError();
}
