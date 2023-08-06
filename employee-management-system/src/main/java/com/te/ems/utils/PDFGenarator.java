package com.te.ems.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.te.ems.entity.Employee;
import com.te.ems.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("pdfGenarator")
public class PDFGenarator {

	@Value("${pdfDir}")
	private String pdfDir;

	@Value("${reportFileName}")
	private String reportFileName;

	@Value("${reportFileNameDateFormat}")
	private String reportFileNameDateFormat;

	@Value("${localDateFormat}")
	private String localDateFormat;

	@Value("${table_noOfColumns}")
	private int noOfColumns;

	@Value("${table.columnNames}")
	private List<String> columnNames;

	@Autowired
	EmployeeRepository employeeRepository;

	private static Font COURIER = new Font(Font.FontFamily.COURIER, 20, Font.BOLD);
	private static Font COURIER_SMALL = new Font(Font.FontFamily.COURIER, 16, Font.BOLD);

	public void generatePDFReport() {
		Document document = new Document();

		try {
			PdfWriter.getInstance(document, new FileOutputStream(getPdfNameWithDate()));
			document.open();
			addDocTitle(document);
			createTable(document, noOfColumns);
			document.close();
			log.info("pdf report is ready");
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}

	private String getPdfNameWithDate() {
		// String format =
		// LocalDateTime.now().format(DateTimeFormatter.ofPattern(localDateFormat));

		System.out.println("getPdfNameWithDate() entered");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(reportFileNameDateFormat);
		String formattedDate = LocalDateTime.now().format(formatter);
		System.out.println(pdfDir + reportFileName + "-" + formattedDate + ".pdf");
		return pdfDir + reportFileName + "-" + formattedDate + ".pdf";

	}

	private void addDocTitle(Document document) throws DocumentException {

		String dateString = LocalDateTime.now().format(DateTimeFormatter.ofPattern(localDateFormat));
		Paragraph p1 = new Paragraph();
		leaveEmptyLine(p1, 1);
		p1.add(new Paragraph(reportFileName, COURIER));
		p1.setAlignment(Element.ALIGN_CENTER);
		leaveEmptyLine(p1, 1);
		p1.add(new Paragraph("Report generated on " + dateString, COURIER_SMALL));

		document.add(p1);
	}

	private static void leaveEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

	private void createTable(Document document, int noOfColumns) throws DocumentException {
		Paragraph paragraph = new Paragraph();
		leaveEmptyLine(paragraph, 3);
		document.add(paragraph);

		PdfPTable table = new PdfPTable(noOfColumns);

		for (int i = 0; i < noOfColumns; i++) {
			PdfPCell cell = new PdfPCell(new Phrase(columnNames.get(i)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
		}

		table.setHeaderRows(1);
		getDbData(table);
		document.add(table);
	}

	private void getDbData(PdfPTable table) {

		List<Employee> list = employeeRepository.fetchEmployees();
		for (Employee employee : list) {

			table.setWidthPercentage(100);
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
			table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);

			table.addCell(employee.getEmployeeId().toString());
			table.addCell(employee.getFirstName());
			table.addCell(employee.getGender().toString());
			table.addCell(employee.getEmail());

			System.out.println(employee.getFirstName());
		}

	}
}
