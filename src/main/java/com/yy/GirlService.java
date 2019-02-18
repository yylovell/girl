package com.yy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional(rollbackOn = Exception.class)
    public void insertTwo() {
        Girl girlOne = new Girl();
        girlOne.setCupSize("A");
        girlOne.setAge(18);

        girlRepository.save(girlOne);

        Girl girlTwo = new Girl();
        girlTwo.setCupSize("Cccc");
        girlTwo.setAge(19);

        girlRepository.save(girlTwo);
    }
}
