package com.javamaster.spring_crud.prototype;

import com.javamaster.spring_crud.dto.BusDto;
import com.javamaster.spring_crud.entity.Bus;

public class BusPrototype {

    public static Bus aBus() {
        Bus b = new Bus();
        //b.setMest("test_mest");
        b.setNum("test_num");
        return b;
    }

    public static BusDto aBusDTO() {
        return BusDto.builder()
                //.mest("test_mest")
                .num("test_num")
                .build();
    }
}
