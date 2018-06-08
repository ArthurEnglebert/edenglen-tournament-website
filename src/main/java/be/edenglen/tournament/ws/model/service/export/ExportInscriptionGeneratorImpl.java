package be.edenglen.tournament.ws.model.service.export;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import be.edenglen.tournament.ws.model.Inscription;
import be.edenglen.tournament.ws.model.service.InscriptionService;
import be.edenglen.tournament.ws.www.dto.in.ExportTypeDTO;

@Component
public class ExportInscriptionGeneratorImpl implements ExportTypeGenerator {

	private static final String[] HEADERS = {"REF ID", "REF NOM", "REF PRENOM", "REF EMAIL", "REF TELEPHONE", "DONATION", "TOTAL PAYEMENT", "PAYE"};

	private final InscriptionService inscriptionService;

	@Autowired
	public ExportInscriptionGeneratorImpl(InscriptionService inscriptionService) {
		this.inscriptionService = inscriptionService;
	}

	@Override
	public boolean supports(ExportTypeDTO exportType) {
		return exportType == ExportTypeDTO.INSCRIPTIONS;
	}

	@Override
	public XSSFWorkbook generateWorkBook() {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("inscriptions");
		createHeaderRow(sheet);
		int rowNumber = 0;

		for (Inscription inscription : inscriptionService.findAll()) {
			createRecordRow(sheet, ++rowNumber, inscription);
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

	private void createRecordRow(Sheet sheet, int rowNumber, Inscription inscription) {
		Row row = sheet.createRow(rowNumber);
		int colNumber = 0;

		row.createCell(colNumber++).setCellValue(inscription.getId());
		row.createCell(colNumber++).setCellValue(inscription.getName());
		row.createCell(colNumber++).setCellValue(inscription.getFirstName());
		row.createCell(colNumber++).setCellValue(inscription.getEmail());
		row.createCell(colNumber++).setCellValue(inscription.getPhone());
		row.createCell(colNumber++).setCellValue(inscription.getDonation());
		row.createCell(colNumber++).setCellValue(inscription.getAmount());
		row.createCell(colNumber++).setCellValue(inscription.isPaid() ? "OUI" : "NON");
	}
}
