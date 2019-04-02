package com.yy.controller;

import com.yy.domain.Result;
import com.yy.repository.GirlRepository;
import com.yy.service.GirlService;
import com.yy.domain.Girl;
import com.yy.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 女生列表
     * @return
     */
    @GetMapping(value = "girlList")
    public List<Girl> girlList() {
        logger.info("list fuc");
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @return
     */
    @PostMapping(value = "girlAdd")
    public Object girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
//            return null;
            return ResultUtil.error(0, bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 查找女生 by id
     * @param id
     * @return
     */
    @GetMapping(value = "girlUpdate/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id) {

        return girlRepository.findOne(id);
    }

    /**
     * 查找女生 by age
     * @param age
     * @return
     */
    @GetMapping(value = "getGirlByAge/{age}")
    public List<Girl> getGirlByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    /**
     * 更新女生
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value = "girlUpdate/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                                     @RequestParam("cupSize") String cupSize,
                                     @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);
    }

    /**
     * 删除女生
     * @param id
     */
    @DeleteMapping(value = "girlDel/{id}")
    public void girlDel(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

    @PostMapping(value = "girls/two")
    public void girlTwo() {
        girlService.insertTwo();
    }

    @GetMapping(value = "girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }








}
