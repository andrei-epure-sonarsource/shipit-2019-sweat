package org.sonarsource.shipit.sweat.sensor;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.RaspiPin;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

public class GpioSensorReader implements SensorReader {
  Logger logger = LoggerFactory.getLogger(FileSensorReader.class);
  final GpioController gpio = GpioFactory.getInstance();
  final GpioPinDigitalInput showerInput = gpio.provisionDigitalInputPin(RaspiPin.GPIO_00, "ShowerSensor");

  @Override
  public boolean isAvailable(int id) throws IOException {

    logger.info("Reading showerInput for ID '{}' - got state '{}', is high '{}', value '{}' ",
                id,
                showerInput.getState(),
                showerInput.isHigh(),
                showerInput.getState().getValue());

    return showerInput.getState().isLow();
  }
}
