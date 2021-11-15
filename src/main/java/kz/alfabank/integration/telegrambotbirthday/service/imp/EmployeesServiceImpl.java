package kz.alfabank.integration.telegrambotbirthday.service.imp;

import kz.alfabank.integration.telegrambotbirthday.model.Employees;
import kz.alfabank.integration.telegrambotbirthday.repository.EmployeesRepository;
import kz.alfabank.integration.telegrambotbirthday.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    private final EmployeesRepository repository;

    @Autowired
    public EmployeesServiceImpl(EmployeesRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employees> getAll(int month, int day) {
        return repository.findByMatchMonthAndMatchDay(month, day);
    }
}