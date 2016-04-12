package api.service;

import api.domain.Station;

import java.util.ArrayList;
import java.util.List;

public interface StationService {

    List<Station> findAllStations();

    Station findStationById(Long id);

    List<Station> findStationByStatus(String status);

    void saveStation(Station station);

    void updateStationStatus(Long id, String status);

    List<Station> findStationsByManyId(ArrayList<Long> ids);

}
