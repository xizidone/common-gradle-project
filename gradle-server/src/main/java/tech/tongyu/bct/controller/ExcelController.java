package tech.tongyu.bct.controller;


import com.alibaba.excel.EasyExcel;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.tongyu.bct.pojo.dto.SnShareFlowImportDTO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

@RestController
@RequestMapping("/excel")
@Slf4j
public class ExcelController {

    @GetMapping("/downShareFlowTemplate")
    @Operation(summary = "份额流水-下载份额流水导入模板")
    public void downInvestorShareFlowTemplate(HttpServletResponse response) {
        try {
            String fileName = "投资者份额流水模板.xlsx";
            String encodedFileName = URLEncoder.encode(fileName, "UTF-8");

            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename*=UTF-8''" + encodedFileName);

            EasyExcel.write(response.getOutputStream(), SnShareFlowImportDTO.class)
                    .sheet("投资者份额流水明细")
                    .doWrite(new ArrayList<>());
        } catch (IOException e) {
            log.error("获取输出流失败: {}", e.getMessage(), e);
            throw new RuntimeException("文件导出失败");
        }
    }
}
