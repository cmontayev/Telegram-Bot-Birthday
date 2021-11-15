package kz.alfabank.integration.telegrambotbirthday.repository;

import kz.alfabank.integration.telegrambotbirthday.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long> {
    @Query(value = "SELECT * FROM employees " +
            "WHERE firstname IS NOT NULL " +
            "AND extract(MONTH FROM birthday) = :m " +
            "AND extract(DAY FROM birthday) = :d",
            nativeQuery = true)
    List<Employees> findByMatchMonthAndMatchDay(@Param("m") int month, @Param("d") int day);
}
