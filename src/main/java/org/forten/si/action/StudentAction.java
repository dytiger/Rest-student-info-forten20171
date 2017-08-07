package org.forten.si.action;

import org.forten.si.data.dto.StudentInfo;
import org.forten.si.data.ro.Message;
import org.forten.utils.common.StringUtil;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/7.
 */
@RestController// Rest风格的控制器：所有方法返回的数据默认被@ResponseBody修饰
public class StudentAction {
    private static final List<StudentInfo> list = new ArrayList<>(5);
    private static final Map<Integer,StudentInfo> map = new HashMap<>(5);

    public StudentAction() {
        StudentInfo si1 = new StudentInfo(1,"Mike",20,"M");
        StudentInfo si2 = new StudentInfo(2,"Mary",30,"F");
        StudentInfo si3 = new StudentInfo(3,"Tom",25,"M");
        StudentInfo si4 = new StudentInfo(4,"John",18,"M");
        StudentInfo si5 = new StudentInfo(5,"Green",23,"F");

        list.add(si1);
        list.add(si2);
        list.add(si3);
        list.add(si4);
        list.add(si5);

        map.put(1,si1);
        map.put(2,si2);
        map.put(3,si3);
        map.put(4,si4);
        map.put(5,si5);
    }

    @RequestMapping(value="/student",method = RequestMethod.POST)
    public Message save(@RequestBody StudentInfo si){
        System.out.println(si);
        return new Message("保存成功");
    }

    @RequestMapping(value="/student",method = RequestMethod.GET)
    public List<StudentInfo> listAll(){
        return list;
    }

    @RequestMapping(value="/student/{id}",method = RequestMethod.GET)
    public StudentInfo listById(@PathVariable int id){
        return map.get(id);
    }

    @RequestMapping(value="/student/{id}",method = RequestMethod.DELETE)
    public Message delete(@PathVariable int id){
        map.remove(id);
        map.values().stream().forEach(System.out::println);
        return new Message("Delete Success");
    }

    @RequestMapping(value="/student",method = RequestMethod.PUT)
    public Message update(@RequestBody StudentInfo si){
        map.put(si.getId(),si);
        System.out.println(map.get(si.getId()));

        return new Message("Update Success");
    }


//    用于传统表单提交的后台Action
//    @RequestMapping(value="/student",method = RequestMethod.PUT)
//    public Message update(StudentInfo si){
//        map.put(si.getId(),si);
//        System.out.println(map.get(si.getId()));
//
//        return new Message("Update Success");
//    }
}
