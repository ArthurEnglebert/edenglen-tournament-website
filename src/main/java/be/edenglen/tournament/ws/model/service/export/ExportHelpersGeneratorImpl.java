package be.edenglen.tournament.ws.model.service.export;

import java.util.Optional;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import be.edenglen.tournament.ws.model.Helper;
import be.edenglen.tournament.ws.model.service.HelperService;
import be.edenglen.tournament.ws.www.dto.in.ExportTypeDTO;

@Component
public class ExportHelpersGeneratorImpl implements ExportTypeGenerator {

	private static final String[] HEADERS = {"id",
			"name", "firstName", "phone",
			"numberComing",
			"bringingFood",
			"is building", "build start hour", "build end hour",
			"is decorating", "decorate start hour", "decorate end hour",
			"comingToUnBuild", "comingToUnBuildStart", "comingToUnBuildEnd"
	};

	private final HelperService helperService;

	@Autowired
	public ExportHelpersGeneratorImpl(HelperService helperService) {
		this.helperService = helperService;
	}

	@Override
	public boolean supports(ExportTypeDTO exportType) {
		return exportType == ExportTypeDTO.HELPERS;
	}

	@Override
	public XSSFWorkbook generateWorkBook() {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("helpers");
		createHeaderRow(sheet);
		int rowNumber = 0;

		for (Helper helper : helperService.findAll()) {
			createRecordRow(sheet, ++rowNumber, helper);
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

	private void createRecordRow(Sheet sheet, int rowNumber, Helper helper) {
		Row row = sheet.createRow(rowNumber);
		int colNumber = 0;

		row.createCell(colNumber++).setCellValue(helper.getId());
		row.createCell(colNumber++).setCellValue(helper.getName());
		row.createCell(colNumber++).setCellValue(helper.getFirstName());
		row.createCell(colNumber++).setCellValue(helper.getPhone());
		row.createCell(colNumber++).setCellValue(helper.getNumberComing());
		row.createCell(colNumber++).setCellValue(helper.isBringingFood());
		row.createCell(colNumber++).setCellValue(helper.isComingToBuild());
		row.createCell(colNumber++).setCellValue(Optional.ofNullable(helper.getComingToBuildStart()).map(val -> val.toString()).orElse("/"));
		row.createCell(colNumber++).setCellValue(Optional.ofNullable(helper.getComingToBuildEnd()).map(val -> val.toString()).orElse("/"));
		row.createCell(colNumber++).setCellValue(helper.isComingToDecorate());
		row.createCell(colNumber++).setCellValue(Optional.ofNullable(helper.getComingToDecorateStart()).map(val -> val.toString()).orElse("/"));
		row.createCell(colNumber++).setCellValue(Optional.ofNullable(helper.getComingToDecorateEnd()).map(val -> val.toString()).orElse("/"));
		row.createCell(colNumber++).setCellValue(helper.isComingToUnBuild());
		row.createCell(colNumber++).setCellValue(Optional.ofNullable(helper.getComingToUnBuildStart()).map(val -> val.toString()).orElse("/"));
		row.createCell(colNumber++).setCellValue(Optional.ofNullable(helper.getComingToUnBuildEnd()).map(val -> val.toString()).orElse("/"));
	}
}
