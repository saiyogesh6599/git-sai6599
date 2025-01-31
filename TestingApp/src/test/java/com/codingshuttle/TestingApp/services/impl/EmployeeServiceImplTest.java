package com.codingshuttle.TestingApp.services.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;

import com.codingshuttle.TestingApp.TestContainerConfiguration;
import com.codingshuttle.TestingApp.dto.EmployeeDto;
import com.codingshuttle.TestingApp.entities.Employee;
import com.codingshuttle.TestingApp.exceptions.ResourceNotFoundException;
import com.codingshuttle.TestingApp.repositories.EmployeeRepository;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(TestContainerConfiguration.class)
@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

	@Mock
	private EmployeeRepository employeeRepository;

	@Spy
	private ModelMapper modelMapper;

	@InjectMocks
	private EmployeeServiceImpl employeeService;

	private Employee mockEmployee;
	private EmployeeDto mockEmployeeDto;

	@BeforeEach
	void setUp() {
		// Initialize mockEmployee using setters
		mockEmployee = new Employee();
		mockEmployee.setId(1L);
		mockEmployee.setEmail("sai@gmail.com");
		mockEmployee.setFullName("sai");
		mockEmployee.setSalary(200L);

		// Map mockEmployee to mockEmployeeDto using ModelMapper
		mockEmployeeDto = modelMapper.map(mockEmployee, EmployeeDto.class);
	}

	@Test
	void testGetEmployeeById_WhenEmployeeIdIsPresent_ThenReturnEmployeeDto() {
		Long id = mockEmployee.getId();
		when(employeeRepository.findById(id)).thenReturn(Optional.of(mockEmployee));

		EmployeeDto employeeDto = employeeService.getEmployeeById(id);

		assertThat(employeeDto).isNotNull();
		assertThat(employeeDto.getId()).isEqualTo(id);
		assertThat(employeeDto.getEmail()).isEqualTo(mockEmployee.getEmail());
		verify(employeeRepository, only()).findById(id);
	}

	@Test
    void testGetEmployeeById_whenEmployeeIsNotPresent_thenThrowException() {
        when(employeeRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThatThrownBy(() -> employeeService.getEmployeeById(1L))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage("Employee not found with id: 1");

        verify(employeeRepository).findById(1L);
    }

	@Test
    void testCreateNewEmployee_WhenValidEmployee_ThenCreateNewEmployee() {
        when(employeeRepository.findByEmail(anyString())).thenReturn(List.of());
        when(employeeRepository.save(any(Employee.class))).thenReturn(mockEmployee);

        EmployeeDto employeeDto = employeeService.createNewEmployee(mockEmployeeDto);

        assertThat(employeeDto).isNotNull();
        assertThat(employeeDto.getEmail()).isEqualTo(mockEmployeeDto.getEmail());

        ArgumentCaptor<Employee> employeeArgumentCaptor = ArgumentCaptor.forClass(Employee.class);
        verify(employeeRepository).save(employeeArgumentCaptor.capture());

        Employee capturedEmployee = employeeArgumentCaptor.getValue();
        assertThat(capturedEmployee.getEmail()).isEqualTo(mockEmployee.getEmail());
    }

	@Test
    void testCreateNewEmployee_whenAttemptingToCreateEmployeeWithExistingEmail_thenThrowException() {
        when(employeeRepository.findByEmail(mockEmployeeDto.getEmail())).thenReturn(List.of(mockEmployee));

        assertThatThrownBy(() -> employeeService.createNewEmployee(mockEmployeeDto))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Employee already exists with email: " + mockEmployee.getEmail());

        verify(employeeRepository).findByEmail(mockEmployeeDto.getEmail());
        verify(employeeRepository, never()).save(any());
    }

	@Test
    void testUpdateEmployee_whenEmployeeDoesNotExists_thenThrowException() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> employeeService.updateEmployee(1L, mockEmployeeDto))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage("Employee not found with id: 1");

        verify(employeeRepository).findById(1L);
        verify(employeeRepository, never()).save(any());
    }

	@Test
    void testUpdateEmployee_whenAttemptingToUpdateEmail_thenThrowException() {
        when(employeeRepository.findById(mockEmployeeDto.getId())).thenReturn(Optional.of(mockEmployee));
        mockEmployeeDto.setName("Random");
        mockEmployeeDto.setEmail("random@gmail.com");

        assertThatThrownBy(() -> employeeService.updateEmployee(mockEmployeeDto.getId(), mockEmployeeDto))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("The email of the employee cannot be updated");

        verify(employeeRepository).findById(mockEmployeeDto.getId());
        verify(employeeRepository, never()).save(any());
    }

	@Test
    void testUpdateEmployee_whenValidEmployee_thenUpdateEmployee() {
        when(employeeRepository.findById(mockEmployeeDto.getId())).thenReturn(Optional.of(mockEmployee));
        mockEmployeeDto.setName("Random name");
        mockEmployeeDto.setSalary(199L);

        Employee newEmployee = modelMapper.map(mockEmployeeDto, Employee.class);
        when(employeeRepository.save(any(Employee.class))).thenReturn(newEmployee);

        EmployeeDto updatedEmployeeDto = employeeService.updateEmployee(mockEmployeeDto.getId(), mockEmployeeDto);

        assertThat(updatedEmployeeDto).isEqualTo(mockEmployeeDto);

        verify(employeeRepository).findById(1L);
        verify(employeeRepository).save(any());
    }

	@Test
    void testDeleteEmployee_whenEmployeeDoesNotExists_thenThrowException() {
        when(employeeRepository.existsById(1L)).thenReturn(false);

        assertThatThrownBy(() -> employeeService.deleteEmployee(1L))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage("Employee not found with id: " + 1L);

        verify(employeeRepository, never()).deleteById(anyLong());
    }

	@Test
    void testDeleteEmployee_whenEmployeeIsValid_thenDeleteEmployee() {
        when(employeeRepository.existsById(1L)).thenReturn(true);

        assertThatCode(() -> employeeService.deleteEmployee(1L))
                .doesNotThrowAnyException();

        verify(employeeRepository).deleteById(1L);
    }
}
