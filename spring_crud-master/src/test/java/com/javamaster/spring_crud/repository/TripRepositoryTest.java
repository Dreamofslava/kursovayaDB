package com.javamaster.spring_crud.repository;

import com.javamaster.spring_crud.entity.Trip;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.javamaster.spring_crud.prototype.TripPrototype.aTrip;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
class TripRepositoryTest {

    @Autowired
    private TripRepository tripRepository;

    @Test
    void findByProtyaj() {
        tripRepository.save(aTrip());
        Trip foundTrip = tripRepository.findByNumber(aTrip().getNumber());
        assertThat(foundTrip).isNotNull();
    }
}
