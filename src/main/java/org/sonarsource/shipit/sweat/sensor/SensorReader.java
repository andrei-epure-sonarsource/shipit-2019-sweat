package org.sonarsource.shipit.sweat.sensor;

import java.io.IOException;

public interface SensorReader {
   boolean isAvailable(int id) throws IOException;
}
