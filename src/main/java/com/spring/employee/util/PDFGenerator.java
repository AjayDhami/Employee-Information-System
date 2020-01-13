package com.spring.employee.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.spring.employee.model.Employee;

@Component
public class PDFGenerator {

	private static final Logger LOGGER = LoggerFactory.getLogger(PDFGenerator.class);

	public void generateItinerary(Employee employee, String filepath) {
		LOGGER.info("Inside generateItinerary()");
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filepath));
			document.open();
			document.add(generateTable(employee));
			document.close();
		} catch (FileNotFoundException | com.itextpdf.text.DocumentException e) {
			LOGGER.error("Exception inside generateItinerary() and the exception is: " + e);
		}
	}

	private PdfPTable generateTable(Employee employee) {
		PdfPTable table = new PdfPTable(2);

		PdfPCell cell;

		cell = new PdfPCell(new Phrase("Employee Details:"));
		cell.setColspan(2);
		table.addCell(cell);

		table.addCell("Employee ID");
		table.addCell(String.valueOf(employee.getId()));

		table.addCell("Employee Name");
		table.addCell(employee.getName());

		table.addCell("Employee Email");
		table.addCell(employee.getEmail());

		table.addCell("Employee Address");
		table.addCell(employee.getAddress());

		table.addCell("Employee Salary");
		table.addCell(String.valueOf(employee.getSalary()));

		return table;
	}

}
