package be.edenglen.tournament.ws.model.service.export;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import be.edenglen.tournament.ws.model.Player;
import be.edenglen.tournament.ws.model.service.PlayerService;
import be.edenglen.tournament.ws.www.dto.in.ExportTypeDTO;

@Component
public class ExportPlayersGeneratorImpl implements ExportTypeGenerator {

	private static final String[] HEADERS = {"REF ID", "NOM", "PRENOM", "EMAIL", "AGE", "SEXE", "TELEPHONE", "NIVEAU NATIONAL", "CATEGORIE", "DINER ?"};

	private final PlayerService playerService;

	@Autowired
	public ExportPlayersGeneratorImpl(PlayerService playerService) {
		this.playerService = playerService;
	}

	@Override
	public boolean supports(ExportTypeDTO exportType) {
		return exportType == ExportTypeDTO.PLAYERS;
	}

	@Override
	public XSSFWorkbook generateWorkBook() {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("inscriptions");
		createHeaderRow(sheet);
		int rowNumber = 0;

		for (Player player : playerService.findAll()) {
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

	private void createRecordRow(Sheet sheet, int rowNumber, Player player) {
		Row row = sheet.createRow(rowNumber);
		int colNumber = 0;

		row.createCell(colNumber++).setCellValue(player.getInscription().getId());
		row.createCell(colNumber++).setCellValue(player.getName());
		row.createCell(colNumber++).setCellValue(player.getFirstName());
		row.createCell(colNumber++).setCellValue(player.getEmail());
		row.createCell(colNumber++).setCellValue(player.getAge());
		row.createCell(colNumber++).setCellValue(player.getSex().toString());
		row.createCell(colNumber++).setCellValue(player.getPhone());
		row.createCell(colNumber++).setCellValue(player.getSkillLevel().toString());
		row.createCell(colNumber++).setCellValue(player.getChampionshipLevel().toString());
		row.createCell(colNumber++).setCellValue(player.isDining() ? "OUI" : "NON");
	}
}
