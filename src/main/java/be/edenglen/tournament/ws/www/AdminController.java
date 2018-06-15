package be.edenglen.tournament.ws.www;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import be.edenglen.tournament.ws.model.Inscription;
import be.edenglen.tournament.ws.model.service.ClientConverter;
import be.edenglen.tournament.ws.model.service.ExportService;
import be.edenglen.tournament.ws.model.service.InscriptionService;
import be.edenglen.tournament.ws.model.service.StatsService;
import be.edenglen.tournament.ws.www.dto.in.ExportTypeDTO;
import be.edenglen.tournament.ws.www.dto.datatable.DataTableOrderDTO;
import be.edenglen.tournament.ws.www.dto.datatable.DataTableRequestDTO;
import be.edenglen.tournament.ws.www.dto.datatable.DataTableResponseDTO;
import be.edenglen.tournament.ws.www.dto.datatable.ImmutableDataTableResponseDTO;

@Controller
@RequestMapping("admin")
public class AdminController {

    public static final String ADMIN_FOLDER = "admin/";

    @Autowired
    private InscriptionService inscriptionService;
    @Autowired
    private StatsService statsService;
    @Autowired
    private ExportService exportService;
    @Autowired
    private ClientConverter clientConverter;

    @RequestMapping
    public String admin(Model model) {
        model.addAttribute("stats", statsService.getStats());
        return ADMIN_FOLDER + "admin";
    }

    @RequestMapping(value = "inscriptions", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public DataTableResponseDTO getInscriptions(@RequestBody DataTableRequestDTO request) {
        List<Inscription> inscriptions = inscriptionService.findAll();
        if (request.getOrder().size() > 0) {
            DataTableOrderDTO order = request.getOrder().get(0);
            inscriptions.sort((o1, o2) -> {
                int result;
                switch (order.getColumn()) {
                    case 0:
                        result = o1.getId().compareTo(o2.getId());
                        break;
                    case 1:
                        result = o1.getFirstName().compareTo(o2.getFirstName());
                        break;
                    case 2:
                        result = o1.getName().compareTo(o2.getName());
                        break;
                    case 3:
                        result = o1.getEmail().compareTo(o2.getEmail());
                        break;
                    case 4:
                        result = o1.getPhone().compareTo(o2.getPhone());
                        break;
                    case 5:
                        result = o1.getAmount().compareTo(o2.getAmount());
                        break;
                    case 6:
                        result = Boolean.compare(o1.isPaid(), o2.isPaid());
                        break;
                    default:
                        result = 0;
                        break;
                }

                if (order.getDir().equals("asc")) {
                    return result;
                } else {
                    return 0 - result;
                }
            });
        }
        return ImmutableDataTableResponseDTO.builder()
                .draw(request.getDraw())
                .recordsTotal(inscriptions.size())
                .recordsFiltered(inscriptions.size())
                .addAllData(inscriptions.stream().map(clientConverter::toDTO).collect(Collectors.toList()))
                .build();
    }

    @RequestMapping(value = "export")
    @ResponseStatus(HttpStatus.OK)
    public void downloadExportFile(@RequestParam(value = "type") ExportTypeDTO exportType,
                                   HttpServletResponse response) throws IOException {
        Cookie fileDownload = new Cookie("fileDownload", "true");
        fileDownload.setPath("/");
        response.addCookie(fileDownload);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + exportType + System.currentTimeMillis() + ".xlsx" + "\"");
        exportService.generateAndDownloadExportFile(exportType, response.getOutputStream());
    }
}
