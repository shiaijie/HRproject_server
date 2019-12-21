package hrms.controller;

import hrms.com.shiaj.hr.Response;
import hrms.entity.Salary;
import hrms.service.ISalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/salary")
public class SalaryController {
    private final ISalaryService service;

    @Autowired
    public SalaryController(ISalaryService service) {
        this.service = service;
    }

    @RequestMapping(value = "/get-all", method = RequestMethod.POST)
    public Response getAll() throws Exception {
        return new Response().success(service.getAll());
    }

    @RequestMapping(value = "/search-salary", method = RequestMethod.POST)
    public Response searchSalary(Map<String,Object> params) throws Exception {
        return new Response().success(service.searchSalary(params));
    }

    @RequestMapping(value = "/delete-salary", method = RequestMethod.POST)
    public Response deleteSalary(String jobCode, String date) throws Exception {
        service.deleteSalary(jobCode, date);
        return new Response().success();
    }

    @RequestMapping(value = "/update-salary", method = RequestMethod.POST)
    public Response updateSalary(Salary salary) throws Exception {
        service.updateSalary(salary);
        return new Response().success();
    }

    @RequestMapping(value = "/add-salary", method = RequestMethod.POST)
    public Response addSalary(Salary salary) throws Exception {
        service.addSalary(salary);
        return new Response().success();
    }

    @RequestMapping(value = "/check-salary", method = RequestMethod.POST)
    public Response checkSalary(String jobCode, Date date) throws Exception {
        return new Response().success(service.checkSalary(jobCode, date));
    }
}
