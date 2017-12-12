package br.com.zeden.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import br.com.zeden.model.TestCase;

public class TestReport {

	public static void main(String[] args) throws IOException {
		TestCase test = new TestCase();
		test.setStatus("true");
		test.setDate("17/10/2017");
		test.setName("teste");
		printReport(test);
	}

	public static void printReport(TestCase testObject) throws IOException {

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("Relatorio de Execução Testes Regressivo");
		Row row = sheet.createRow((short) 0);
		row.createCell(0).setCellValue("Data Execucao");
		row.createCell(1).setCellValue("Test Case");
		row.createCell(2).setCellValue("Status");

		List<TestCase> tobject = new ArrayList();
		tobject.add(testObject);
		int rowlength = 1;
		for (TestCase test : tobject) {

			row = sheet.createRow(rowlength++);
			int cellnum = 0;
			Cell cellDataExecucao = row.createCell(cellnum++);
			cellDataExecucao.setCellValue(test.getDate());

			Cell cellTestCase = row.createCell(cellnum++);
			cellTestCase.setCellValue(test.getName());

			Cell cellStatus = row.createCell(cellnum++);
			cellStatus.setCellValue(test.getStatus());

		}
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		Date date = new Date();
		try {
			FileOutputStream out = new FileOutputStream(
					new File("/Users/yamanuser/Documents/Teste/relatorioexecucao" + dateFormat.format(date) + ".xls"));
			wb.write(out);
			out.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
