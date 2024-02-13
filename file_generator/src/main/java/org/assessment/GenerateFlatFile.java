package org.assessment;

import net.sf.jasperreports.engine.JRException;
import org.assessment.service.FlatFileService;
import org.assessment.service.JasperReportService;

import java.io.FileNotFoundException;


public class GenerateFlatFile {

    public static void main(String[] args) throws JRException, FileNotFoundException {
        JasperReportService.generateJasperReport("html");
        JasperReportService.generateJasperReport("pdf");
        FlatFileService.generateFlatFile();
    }
}