package org.example.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.example.entity.CalenderEvent;

@ApplicationScoped
public class CalenderEventRepository implements PanacheRepository<CalenderEvent> {
}
