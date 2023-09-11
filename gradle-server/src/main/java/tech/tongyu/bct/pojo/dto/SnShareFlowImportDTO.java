package tech.tongyu.bct.pojo.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;


/**
 * 投资份额流水 Excel 导入模板
 */
@Data
public class SnShareFlowImportDTO implements Serializable {
    /**
     * 产品名称
     */
    @ExcelProperty(value = "产品名称")
    private String productName;

    /**
     * 交易类型
     */
    @ExcelProperty(value = "交易类型")
    private String transType;

    /**
     * 交易方向
     * <p>默认可为空, 当【交易类型】为【其他】时通过该字段补充对应的交易方向</p>
     */
    @ExcelProperty(value = "交易方向")
    private String transDirection;

    /**
     * 交易份额
     */
    @ExcelProperty(value = "交易份额")
    private BigDecimal transShare;

    /**
     * 交易金额
     */
    @ExcelProperty(value = "交易金额")
    private BigDecimal transAmount;

    /**
     * 份额登记日期
     */
    @ExcelProperty(value = "份额登记日期")
    private LocalDate regDate;

    /**
     * 投资者名称
     */
    @ExcelProperty(value = "投资者名称")
    private String investorName;

    /**
     * 投资者证件号码
     * <p>默认可为空, 当存在重复的【投资者名称】时通过该字段来进行唯一性标识</p>
     */
    @ExcelProperty(value = "投资者证件号码")
    private String investorNo;

    /**
     * 转让对手方名称
     */
    @ExcelProperty(value = "转让对手方名称")
    private String transferorName;

    /**
     * 转让对手方证件号码
     * <p>默认可为空, 当存在重复的【转让对手方名称】时通过该字段来进行唯一性标识</p>
     */
    @ExcelProperty(value = "转让对手方证件号码")
    private String transferorNo;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remarks;
}
