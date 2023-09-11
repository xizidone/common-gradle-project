package tech.tongyu.bct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
public class TradeTemplateContentDTO {
    private List<TableData> tableData;
    private TradeBaseData tradeBaseData;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class TableData {
    private String id;
    private String $legType;
    private String $legName;
    private String $legEnv;
    private Map<String, Object> calcTradeFlag;
    private Map<String, Object> participation;
    private Map<String, Object> instrumentId;
    private Map<String, Object> initialPrice;
    private Map<String, Object> payoffAlgo;
    private Map<String, Object> dueDate;
    private Map<String, Object> lastObservationDate;
    private Map<String, Object> dividendMethod;
    private Map<String, Object> settlementDate;
    private Map<String, Object> callOrPut;
    private Map<String, Object> initialDate;
    private Map<String, Object> underlyingSecurityQuantityType;
    private Map<String, Object> instrumentName;
    private List<String> underlyingSecurities;
    private double minimumCouponRate;
    private double strikePriceRatio;
    private double strikePrice;
    private Map<String, Object> productType;
    private int valuePrecision;
    private int pricePrecision;
    private int percentagePrecision;
    private Map<String, Object> calcDaysType;
    private Map<String, Object> displayNotionalCurrency;
    private List<String> calendarNames;
    private Map<String, Object> calcDaysDeadlineType;
    private int annualizedDays;
    private Map<String, Object> tradeBookingCategory;
    private Map<String, Object> premiumRateUnit;
    private Map<String, Object> tradeVolumeType;
    private int countedDays;
    private Map<String, Object> notionalType;
}

@Data
class TradeBaseData {
}
