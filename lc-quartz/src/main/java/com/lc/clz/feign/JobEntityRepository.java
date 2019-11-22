package com.lc.clz.feign;

import com.lc.clz.entity.JobEntity;
import org.springframework.data.repository.CrudRepository;

public interface JobEntityRepository extends CrudRepository<JobEntity, Long> {

    JobEntity getById(Integer id);

}