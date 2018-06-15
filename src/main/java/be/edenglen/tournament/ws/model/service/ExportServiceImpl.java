package be.edenglen.tournament.ws.model.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import be.edenglen.tournament.ws.model.service.export.ExportTypeGenerator;
import be.edenglen.tournament.ws.www.dto.in.ExportTypeDTO;

@Service
public class ExportServiceImpl implements ExportService {

	private final Map<ExportTypeDTO, ExportTypeGenerator> generators = new HashMap<>();

	@Autowired
	public ExportServiceImpl(List<ExportTypeGenerator> generators) {
		Arrays.stream(ExportTypeDTO.values()).forEach(exportType -> {
					ExportTypeGenerator exportTypeGenerator = generators.stream()
							.filter(generator -> generator.supports(exportType))
							.findFirst()
							.orElseThrow(() -> new IllegalStateException("Export Type " + exportType + " isnt supported"));
					this.generators.put(exportType, exportTypeGenerator);
		});
	}

	@Override
	public void generateAndDownloadExportFile(ExportTypeDTO exportType, OutputStream outputStream) {
		ExportTypeGenerator generator = generators.get(exportType);
		XSSFWorkbook sheets = generator.generateWorkBook();
		try {
			sheets.write(outputStream);
			sheets.close();
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}
}
