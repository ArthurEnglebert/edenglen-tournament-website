package be.edenglen.tournament.ws.model.service.export;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import be.edenglen.tournament.ws.www.dto.in.ExportTypeDTO;

public interface ExportTypeGenerator {
	boolean supports(ExportTypeDTO exportType);
	XSSFWorkbook generateWorkBook();
}
