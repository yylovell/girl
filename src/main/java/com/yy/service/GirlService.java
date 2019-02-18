package com.yy.service;

import com.yy.domain.Girl;
import com.yy.enums.ResultEnum;
import com.yy.exception.GirlException;
import com.yy.repository.GirlRepository;
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

    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);

        } else if (age > 10 && age < 16) {
            //
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过id查询女生的测试方法
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }
}
