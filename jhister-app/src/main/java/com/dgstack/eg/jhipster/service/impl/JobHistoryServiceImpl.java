package com.dgstack.eg.jhipster.service.impl;

import com.dgstack.eg.jhipster.service.JobHistoryService;
import com.dgstack.eg.jhipster.domain.JobHistory;
import com.dgstack.eg.jhipster.repository.JobHistoryRepository;
import com.dgstack.eg.jhipster.repository.search.JobHistorySearchRepository;
import com.dgstack.eg.jhipster.service.dto.JobHistoryDTO;
import com.dgstack.eg.jhipster.service.mapper.JobHistoryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing JobHistory.
 */
@Service
@Transactional
public class JobHistoryServiceImpl implements JobHistoryService{

    private final Logger log = LoggerFactory.getLogger(JobHistoryServiceImpl.class);
    
    @Inject
    private JobHistoryRepository jobHistoryRepository;

    @Inject
    private JobHistoryMapper jobHistoryMapper;

    @Inject
    private JobHistorySearchRepository jobHistorySearchRepository;

    /**
     * Save a jobHistory.
     *
     * @param jobHistoryDTO the entity to save
     * @return the persisted entity
     */
    public JobHistoryDTO save(JobHistoryDTO jobHistoryDTO) {
        log.debug("Request to save JobHistory : {}", jobHistoryDTO);
        JobHistory jobHistory = jobHistoryMapper.jobHistoryDTOToJobHistory(jobHistoryDTO);
        jobHistory = jobHistoryRepository.save(jobHistory);
        JobHistoryDTO result = jobHistoryMapper.jobHistoryToJobHistoryDTO(jobHistory);
        jobHistorySearchRepository.save(jobHistory);
        return result;
    }

    /**
     *  Get all the jobHistories.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public Page<JobHistoryDTO> findAll(Pageable pageable) {
        log.debug("Request to get all JobHistories");
        Page<JobHistory> result = jobHistoryRepository.findAll(pageable);
        return result.map(jobHistory -> jobHistoryMapper.jobHistoryToJobHistoryDTO(jobHistory));
    }

    /**
     *  Get one jobHistory by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public JobHistoryDTO findOne(Long id) {
        log.debug("Request to get JobHistory : {}", id);
        JobHistory jobHistory = jobHistoryRepository.findOne(id);
        JobHistoryDTO jobHistoryDTO = jobHistoryMapper.jobHistoryToJobHistoryDTO(jobHistory);
        return jobHistoryDTO;
    }

    /**
     *  Delete the  jobHistory by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete JobHistory : {}", id);
        jobHistoryRepository.delete(id);
        jobHistorySearchRepository.delete(id);
    }

    /**
     * Search for the jobHistory corresponding to the query.
     *
     *  @param query the query of the search
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<JobHistoryDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of JobHistories for query {}", query);
        Page<JobHistory> result = jobHistorySearchRepository.search(queryStringQuery(query), pageable);
        return result.map(jobHistory -> jobHistoryMapper.jobHistoryToJobHistoryDTO(jobHistory));
    }
}
