package org.gearcode.gpndemoserver.repository;

import org.gearcode.gpndemoserver.entity.DataPack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataPackRepository extends JpaRepository<DataPack, Long> {

    List<DataPack> findByStartTimeGreaterThanEqualAndEndTimeLessThanEqual(long startTime, long endTime);

}
