package com.yy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "girlList")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "girlAdd")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                          @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);
    }

    /**
     * 查找女生 by id
     * @param id
     * @return
     */
    @GetMapping(value = "girlUpdate/{id}")
    public Optional<Girl> girlUpdate(@PathVariable("id") Integer id) {
        Optional<Girl> arr = girlRepository.findById(id);

        return arr;
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
        girlRepository.deleteById(id);
    }

    @PostMapping(value = "girls/two")
    public void girlTwo() {
        girlService.insertTwo();
    }
}
