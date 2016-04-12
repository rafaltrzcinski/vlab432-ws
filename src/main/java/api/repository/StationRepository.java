package api.repository;

import api.domain.Station;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;


public interface StationRepository extends JpaRepository<Station, Long> {

    List<Station> findByStatusIgnoreCaseOrderByIdAsc(String status);

    List<Station> findByIdInOrderByIdAsc(ArrayList<Long> ids);

}
