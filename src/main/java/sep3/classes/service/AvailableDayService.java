package sep3.classes.service;

import sep3.classes.Model.AvailableDay;

import java.util.Date;
import java.util.List;

public interface AvailableDayService {

    void deleteAvailableDay(AvailableDay availableDay);
    void updateAvailableDay(AvailableDay availableDay);
    List<AvailableDay> getAvailableDays(int doctorId);
    void addAvailableDay(AvailableDay availableDay);
}
