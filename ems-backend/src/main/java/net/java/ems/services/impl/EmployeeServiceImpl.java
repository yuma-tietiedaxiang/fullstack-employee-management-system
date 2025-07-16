package net.java.ems.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import net.java.ems.dto.EmployeeDto;
import net.java.ems.entity.Employee;
import net.java.ems.exception.ResourceNotFoundException;
import net.java.ems.mapper.EmployeeMapper;
import net.java.ems.repository.EmployeeRepository;
import net.java.ems.services.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    /*
     * 这个service接口的实现类Impl，实现了EmployeeService接口，并重写了createEmployee方法
     * 这个方法的目的是创建一个员工，并返回一个EmployeeDto对象
     * 这个方法的实现步骤是：
     * 1. 将EmployeeDto对象转换为Employee对象
     * 2. 将Employee对象保存到数据库中 用employeeRepository.save会返回保存后的Employee对象
     * 3. 将保存后的Employee对象转换为EmployeeDto对象
     * 4. 返回EmployeeDto对象
     */
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        // save将employee对象保存到数据库中
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeesById(Long id) {
        Employee foundEmoloyee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        return EmployeeMapper.mapToEmployeeDto(foundEmoloyee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> allEmployees = employeeRepository.findAll();
        return allEmployees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());

    }

    @Override
    @Transactional
    public EmployeeDto updateEmployee(Long id, EmployeeDto EmployeeDto) {
        System.out.println("Updating employee with ID: " + id);
        Employee foundEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        System.out.println("Found employee: " + foundEmployee.getFirstName() + " " + foundEmployee.getLastName());
        foundEmployee.setFirstName(EmployeeDto.getFirstName());
        foundEmployee.setLastName(EmployeeDto.getLastName());
        foundEmployee.setEmail(EmployeeDto.getEmail());

        Employee updatedEmployee = employeeRepository.save(foundEmployee);
        System.out.println("Updated employee: " + updatedEmployee.getFirstName() + " " + updatedEmployee.getLastName());

        EmployeeDto updatedEmployeeDto = EmployeeMapper.mapToEmployeeDto(updatedEmployee);
        return updatedEmployeeDto;
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee foundEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        employeeRepository.deleteById(id);
    }



}
