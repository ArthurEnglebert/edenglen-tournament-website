package be.edenglen.tournament.ws.model.service;

import java.io.OutputStream;
import be.edenglen.tournament.ws.www.dto.in.ExportTypeDTO;

public interface ExportService {
	void generateAndDownloadExportFile(ExportTypeDTO exportType, OutputStream outputStream);
}
