package org.example.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import org.example.dto.AddCalenderEventDTO;
import org.example.entity.CalenderEvent;
import org.example.repository.CalenderEventRepository;

import java.util.List;

@ApplicationScoped
public class CalenderEventService {

    @Inject
    CalenderEventRepository calenderEventRepository;


    @Transactional
    public CalenderEvent addCalenderEvent(AddCalenderEventDTO calenderEventDTO) {

        if(calenderEventDTO == null) {
            throw new IllegalArgumentException("CalenderEventDTO cannot be null");
        }
        CalenderEvent calenderEvent = new CalenderEvent();
        calenderEvent.setTitle(calenderEventDTO.getTitle());
        calenderEvent.setDescription(calenderEventDTO.getDescription());
        calenderEvent.setStartTime(calenderEventDTO.getStartDate());
        calenderEvent.setEndTime(calenderEventDTO.getEndDate());

        calenderEventRepository.persist(calenderEvent);
        return calenderEvent;
    }

    @Transactional
    public CalenderEvent updateCalenderEvent(Long id, AddCalenderEventDTO calenderEventDTO) {

        if(id == null) {
            throw new WebApplicationException("Id cannot be null", 400);
        }

        CalenderEvent calenderEvent = calenderEventRepository.findById(id);

        if(calenderEvent == null) {
            throw new WebApplicationException("CalenderEvent not found", 400);
        }
        calenderEvent.setTitle(calenderEventDTO.getTitle());
        calenderEvent.setDescription(calenderEventDTO.getDescription());
        calenderEvent.setStartTime(calenderEventDTO.getStartDate());
        calenderEvent.setEndTime(calenderEventDTO.getEndDate());

        calenderEventRepository.persist(calenderEvent);
        return calenderEvent;
    }

    public void removeCalenderEvent(Long id) {

            if(id == null) {
                throw new WebApplicationException("Id cannot be null", 400);
            }

            CalenderEvent calenderEvent = calenderEventRepository.findById(id);

            if(calenderEvent == null) {
                throw new WebApplicationException("CalenderEvent not found", 400);
            }

            calenderEventRepository.deleteById(id);
    }

    public CalenderEvent getCalenderEventById(Long id) {

        if(id == null) {
            throw new WebApplicationException("Id cannot be null", 400);
        }

        CalenderEvent calenderEvent = calenderEventRepository.findById(id);

        if(calenderEvent == null) {
            throw new WebApplicationException("CalenderEvent not found", 400);
        }

        return calenderEvent;
    }

    public List<CalenderEvent> getAllCalenderEvents() {
        return calenderEventRepository.listAll();
    }
}
