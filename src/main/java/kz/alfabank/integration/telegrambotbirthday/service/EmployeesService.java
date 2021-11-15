package kz.alfabank.integration.telegrambotbirthday.service;

import kz.alfabank.integration.telegrambotbirthday.model.Employees;

import java.util.List;

public interface EmployeesService {

    List<Employees> getAll(int month, int day);
}
