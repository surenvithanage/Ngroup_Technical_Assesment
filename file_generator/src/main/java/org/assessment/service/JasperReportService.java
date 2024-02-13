package org.assessment.service;


import org.assessment.bean.Report;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

public class JasperReportService {

    public static void generateJasperReport(String reportFormat) throws JRException, FileNotFoundException {
        String saveFilePath = "/Users/surenvithanage/Projects/Interview";

        List<Report> reports = List.of(
                new Report("01-01-2024", "#12312312", 13500.00, "Active", "Remark 1"),
                new Report("01-02-2024", "#12312313", 14500.00, "Active", "Remark 2"),
                new Report("01-03-2024", "#12312314", 15500.00, "In-Active", "Remark 3"),
                new Report("01-04-2024", "#12312315", 16500.00, "Active", "Remark 4"),
                new Report("01-05-2024", "#12312316", 17500.00, "In-Active", "Remark 5"),
                new Report("01-06-2024", "#12312317", 18500.00, "Active", "Remark 6"),
                new Report("01-07-2024", "#12312318", 19500.00, "Active", "Remark 7"),
                new Report("01-08-2024", "#12312319", 23500.00, "In-Active", "Remark 8"),
                new Report("01-09-2024", "#12312311", 24500.00, "In-Active", "Remark 9"),
                new Report("01-10-2024", "#12312321", 25500.00, "Active", "Remark 10")
        );

        File file = ResourceUtils.getFile("classpath:report.jrxml");
        JasperReport jasper = JasperCompileManager.compileReport(file.getAbsolutePath());

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper, new HashMap<>(), new JRBeanCollectionDataSource(reports));

        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, saveFilePath + "/report.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, saveFilePath + "/report.pdf");
        }

    }
}
