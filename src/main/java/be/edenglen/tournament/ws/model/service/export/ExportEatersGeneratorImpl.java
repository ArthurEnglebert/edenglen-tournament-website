package be.edenglen.tournament.ws.model.service.export;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import be.edenglen.tournament.ws.model.Eater;
import be.edenglen.tournament.ws.model.service.EaterService;
import be.edenglen.tournament.ws.www.dto.in.ExportTypeDTO;

@Component
public class ExportEatersGeneratorImpl implements ExportTypeGenerator {

	private final static String[] HEADERS = {"REF ID", "NOM", "PRENOM", "AGE", "EMAIL"};

	private final EaterService eaterService;

	@Autowired
	public ExportEatersGeneratorImpl(EaterService eaterService) {
		this.eaterService = eaterService;
	}

	@Override
	public boolean supports(ExportTypeDTO exportType) {
		return exportType == ExportTypeDTO.EATERS;
	}

	@Override
	public XSSFWorkbook generateWorkBook() {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("inscriptions");
		createHeaderRow(sheet);
		int rowNumber = 0;

		for (Eater player : eaterService.findAll()) {
			createRecordRow(sheet, ++rowNumber, player);
		}

		return workbook;
	}

	private void createHeaderRow(XSSFSheet sheet) {
		Row headerRow = sheet.createRow(0);
		int colNum = 0;
		for (String header : HEADERS) {
			Cell cell = headerRow.createCell(colNum++);
			cell.setCellValue(header);
		}
	}

	private void createRecordRow(Sheet sheet, int rowNumber, Eater eater) {
		Row row = sheet.createRow(rowNumber);
		int colNumber = 0;

		row.createCell(colNumber++).setCellValue(eater.getInscription().getId());
		row.createCell(colNumber++).setCellValue(eater.getName());
		row.createCell(colNumber++).setCellValue(eater.getFirstName());
		row.createCell(colNumber++).setCellValue(eater.getEmail());
		row.createCell(colNumber++).setCellValue(eater.getAge());
	}
}
