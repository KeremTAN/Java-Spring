package gov.tubitak.keremt.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.tubitak.keremt.dto.StockDto;
import lombok.Data;
import java.util.HashMap;

@Data
public class TimeSeriesQueryResult {
    @JsonProperty("Meta Data")
    HashMap<String, String> metaData;

    @JsonProperty("Time Series (Daily)")
    HashMap<String, StockDto> timeSeries;
}
