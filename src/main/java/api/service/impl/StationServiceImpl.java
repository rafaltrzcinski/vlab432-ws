package api.service.impl;

import api.domain.Station;
import api.repository.StationRepository;
import api.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StationServiceImpl implements StationService {

    private StationRepository stationRepository;

    @Autowired
    public StationServiceImpl(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    public List<Station> findAllStations() {
        return stationRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
    }

    @Override
    public Station findStationById(Long id) {
        return stationRepository.findOne(id);
    }

    @Override
    public List<Station> findStationsByManyId(ArrayList<Long> ids) {
        return stationRepository.findByIdInOrderByIdAsc(ids);
    }

    @Override
    public List<Station> findStationByStatus(String status) {
        return stationRepository.findByStatusIgnoreCaseOrderByIdAsc(status);
    }

    @Override
    public void saveStation(Station station) {
        stationRepository.save(station);
    }

    @Override
    public void updateStationStatus(Long id, String status) {
        Station station = findStationById(id);
        if (station != null) {
            try {
                station.setStatus(status);
                saveStation(station);
            } catch (DataIntegrityViolationException e) {
                throw new NoSuchElementException(String.format("Status=%s is not allowed", status));
            }
        } else {
            throw new NoSuchElementException(String.format("Station not found by id=%s", id));
        }
    }
}
