package com.javamaster.spring_crud.repository;

import com.javamaster.spring_crud.entity.Bus;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.javamaster.spring_crud.prototype.BusPrototype.aBus;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
class BusRepositoryTest {

    @Autowired
    private BusRepository busRepository;

    @Test
    void findByNum() {
        busRepository.save(aBus());
        Bus foundBus = busRepository.findByNum(aBus().getNum());
        assertThat(foundBus).isNotNull();
        //assertThat(foundBus.getMest()).isEqualTo(aBus().getMest());
    }

}
