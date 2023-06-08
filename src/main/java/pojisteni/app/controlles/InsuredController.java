package pojisteni.app.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pojisteni.app.models.dto.ConnectionDTO;
import pojisteni.app.models.dto.InsuranceDTO;
import pojisteni.app.models.dto.InsuredDTO;
import pojisteni.app.models.dto.mappers.InsuredMapper;
import pojisteni.app.models.services.ConnectionService;
import pojisteni.app.models.services.InsuranceService;
import pojisteni.app.models.services.InsuredService;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/insured")
public class InsuredController {

    @Autowired
    private InsuredService insuredService;

    @Autowired
    private ConnectionService connectionService;

    @Autowired
    private InsuredMapper insuredMapper;

    @Autowired
    private InsuranceService insuranceService;

    @GetMapping
    public String renderIndex(Model model) {
        List<InsuredDTO> insured = insuredService.getAll();
        model.addAttribute("insured", insured);
        return "pages/insured/index";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("create")
    public String renderNewInsured(@ModelAttribute InsuredDTO insuredDTO) {
        return "pages/insured/create";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("create")
    public String createNewInsured(
            @Valid @ModelAttribute InsuredDTO insuredDTO,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors())
            return renderNewInsured(insuredDTO);
        insuredService.create(insuredDTO);
        redirectAttributes.addFlashAttribute("success", "Pojištěnec byl uložen.");
        return "redirect:/insured";
    }

    @GetMapping("{insuredId}")
    public String renderDetail(
            @PathVariable long insuredId,
            Model model
    ) {
        InsuredDTO insured = insuredService.getById(insuredId);
        model.addAttribute("insured", insured);

        List<ConnectionDTO> connections = connectionService.getAllFromInsured();
        List<InsuranceDTO> insurancesAll = insuranceService.getAll();
        List<InsuranceDTO> insurancesFilter = insuranceService.getFilter(connections, insurancesAll, insuredId);

        model.addAttribute("insurancesFilter", insurancesFilter);
        return "pages/insured/detail";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("edit/{insuredId}")
    public String renderEditForm(@PathVariable Long insuredId, InsuredDTO insured) {
        InsuredDTO fetchedInsured = insuredService.getById(insuredId);
        insuredMapper.updateInsuredDTO(fetchedInsured, insured);
        return "pages/insured/edit";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("edit/{insuredId}")
    public String editInsured(@PathVariable long insuredId, InsuredDTO insured, RedirectAttributes redirectAttributes) {
        insured.setInsuredId(insuredId);
        insuredService.edit(insured);
        redirectAttributes.addFlashAttribute("success", "Editace pojištěnce byla uložena.");
        return "redirect:/insured";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("delete/{insuredId}")
    public String deleteInsured(@PathVariable long insuredId, RedirectAttributes redirectAttributes) {
        insuredService.remove(insuredId);

        long connectionId;
        List<ConnectionDTO> connections = connectionService.getAllFromInsured();
        for(ConnectionDTO c : connections) {
            if(c.getInsuredId() == insuredId) {
                connectionId = c.getConnectionId();
                connectionService.remove(connectionId);
            }
        }

        redirectAttributes.addFlashAttribute("success", "Pojištěnec byl smazán.");
        return "redirect:/insured";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("connection/{insuredId}")
    public String renderEditForm(
            @PathVariable long insuredId,
            Model model,
            @ModelAttribute ConnectionDTO connectionDTO
    ) {
        //* Získání dat konkrétního pojištěného
        InsuredDTO insured = insuredService.getById(insuredId);
        model.addAttribute("insured", insured);

        //* Získání seznamu všech dostupných pojištění
        List<InsuranceDTO> insurances = insuranceService.getAll();
        model.addAttribute("insurances", insurances);
        return "pages/connection/create";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("connection/{insuredId}")
    public String addConnection(
            @ModelAttribute ConnectionDTO connectionDTO,
            RedirectAttributes redirectAttributes
    ) {
        connectionService.create(connectionDTO);
        redirectAttributes.addFlashAttribute("success", "Pojištění bylo přiřazeno k pojistníkovi.");
        return "redirect:/insured/{insuredId}";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("delete/{insuredId}/{insuranceId}")
    public String deleteInsuranceConnection(
            @PathVariable long insuredId,
            @PathVariable long insuranceId,
            RedirectAttributes redirectAttributes
    ) {
        List<ConnectionDTO> connections = connectionService.getAllFromInsured();
        long connectionId;

        for(ConnectionDTO c : connections) {
            if ((c.getInsuredId() == insuredId) && (c.getInsuranceId() == insuranceId)) {
                connectionId = c.getConnectionId();
                connectionService.remove(connectionId);
                break;
            }
        }
        redirectAttributes.addFlashAttribute("success", "Pojištění bylo pojistníkovi odebráno.");
        return "redirect:/insured/{insuredId}";
    }








}
