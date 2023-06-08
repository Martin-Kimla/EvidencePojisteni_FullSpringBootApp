package pojisteni.app.controlles;

import jakarta.validation.Valid;
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
import pojisteni.app.models.dto.mappers.InsuranceMapper;
import pojisteni.app.models.services.ConnectionService;
import pojisteni.app.models.services.InsuranceService;

import java.util.List;

@Controller
@RequestMapping("/insurance")
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;
    @Autowired
    private InsuranceMapper insuranceMapper;
    @Autowired
    private ConnectionService connectionService;

    @GetMapping
    public String renderIndex(Model model) {
        List<InsuranceDTO> insurances = insuranceService.getAll();
        model.addAttribute("insurances", insurances);
        return "pages/insurance/index";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("create")
    public String renderCreateForm(@ModelAttribute
                                   InsuranceDTO insuranceDTO) {
        return "pages/insurance/create";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("create")
    public String createInsurance(
            @Valid @ModelAttribute InsuranceDTO insurance,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors())
            return renderCreateForm(insurance);
        redirectAttributes.addFlashAttribute("success", "Pojištění bylo uloženo.");
        insuranceService.create(insurance);
        return "redirect:/insurance";
    }

    @GetMapping("{insuranceId}")
    public String renderDetail(
            @PathVariable long insuranceId,
            Model model
    ) {
        InsuranceDTO insurance = insuranceService.getById(insuranceId);
        model.addAttribute("insurance", insurance);

        return "pages/insurance/detail";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("edit/{insuranceId}")
    public String renderEditForm(
            @PathVariable Long insuranceId,
            InsuranceDTO insurance
    ) {
        InsuranceDTO fetchedInsurance = insuranceService.getById(insuranceId);
        insuranceMapper.updateInsuranceDTO(fetchedInsurance, insurance);
        return "pages/insurance/edit";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("edit/{insuranceId}")
    public String editInsurance(
            @PathVariable long insuranceId,
            @Valid InsuranceDTO insurance,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors())
            return renderEditForm(insuranceId, insurance);

        insurance.setInsuranceId(insuranceId);
        insuranceService.edit(insurance);
        redirectAttributes.addFlashAttribute("success", "Editace pojištění byla uložena.");

        return "redirect:/insurance";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("delete/{insuranceId}")
    public String deleteInsurance(
            @PathVariable long insuranceId,
            RedirectAttributes redirectAttributes
    ) {

        long connectionId;
        List<ConnectionDTO> connections = connectionService.getAllFromInsured();
        for(ConnectionDTO c : connections) {
            if(c.getInsuranceId() == insuranceId) {
                connectionId = c.getConnectionId();
                connectionService.remove(connectionId);
            }
        }

        insuranceService.remove(insuranceId);
        redirectAttributes.addFlashAttribute("success", "Pojištění bylo smazáno.");
        return "redirect:/insurance";
    }

}