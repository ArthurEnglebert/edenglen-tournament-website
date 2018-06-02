package be.edenglen.tournament.ws.www.dto.stats;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableStatsDTOOut.class)
public interface StatsDTOOut {
    AwaitedAmountDTOOut getAwaitedTotal();
    AwaitedAmountDTOOut getValidatedTotal();
    AwaitedAmountDTOOut getWaitingTotal();

    DisparityStatDTOOut getDisparity1012();
    DisparityStatDTOOut getDisparity1316();
    DisparityStatDTOOut getDisparity1725();
    DisparityStatDTOOut getDisparity26Onwards();
}
