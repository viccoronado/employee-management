package com.employee.management.infrastructure.repositories;

import com.employee.management.domain.models.Gender;
import com.employee.management.domain.repositories.GenderRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Map;

@Repository
public class InMemoryGenderRepository implements GenderRepository {

    private final Map<Long, Gender> genderStore = new ConcurrentHashMap<>();
    private final AtomicLong currentId = new AtomicLong(1L);

    @Override
    public Gender save(Gender gender) {
        if (gender.getId() == null) {
            gender.setId(currentId.getAndIncrement());
        }
        genderStore.put(gender.getId(), gender);
        return gender;
    }

    @Override
    public Optional<Gender> findById(Long id) {
        return Optional.ofNullable(genderStore.get(id));
    }

    @Override
    public boolean existsById(Long id) {
        return genderStore.containsKey(id);
    }
}
