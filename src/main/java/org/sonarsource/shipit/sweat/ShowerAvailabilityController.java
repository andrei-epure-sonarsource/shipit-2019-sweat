package org.sonarsource.shipit.sweat;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ShowerAvailabilityController {

  private static ShowerAvailability WRONG_INPUT = new ShowerAvailability(-1, "Wrong Input");

  @RequestMapping("/shower")
  public ShowerAvailability greeting(@RequestParam(value="id", defaultValue="0") String id) {
    int parsedId = parseShowerId(id);
    if (parsedId == -1) {
      return WRONG_INPUT;
    }

    return new ShowerAvailability(parsedId, "available");
  }

  private int parseShowerId(String input) {
    int id;
    try {
      id = Integer.parseInt(input);
    }
    catch (NumberFormatException nfe) {
      id = -1;
    }
    if (id > 2) {
      id = -1;
    }
    return id;
  }
}
