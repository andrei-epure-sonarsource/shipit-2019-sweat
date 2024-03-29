package org.sonarsource.shipit.sweat;

import org.sonarsource.shipit.sweat.sensor.SensorReader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {
  private ShowerAvailabilityController showerAvailabilityController;

  public ViewController(ShowerAvailabilityController showerAvailabilityController) {
    this.showerAvailabilityController = showerAvailabilityController;
  }

  @GetMapping("/")
  public String viewStatus(Model model) {
    return "index";
  }

  @GetMapping("/shower/status")
  public String statusView(@RequestParam(value="id", defaultValue="1") String id, Model model) {

    ShowerAvailability sa = showerAvailabilityController.greeting(id);

    model.addAttribute("status", sa.getStatus());

    return "shower";
  }
}
