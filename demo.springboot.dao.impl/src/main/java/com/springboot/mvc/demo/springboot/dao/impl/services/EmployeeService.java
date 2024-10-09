package com.springboot.mvc.demo.springboot.dao.impl.services;

import java.text.DateFormat.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.el.util.ReflectionUtil;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import com.springboot.mvc.demo.springboot.dao.impl.dto.EmployeeDTO;
import com.springboot.mvc.demo.springboot.dao.impl.entitle.EmployeeEntity;
import com.springboot.mvc.demo.springboot.dao.impl.repo.EmployeeRepo;

@Service
public  class EmployeeService {

	private final EmployeeRepo employeeRepo;
	private final ModelMapper modelMapper;
	

    public EmployeeService(EmployeeRepo employeeRepo, ModelMapper modelMapper) {
        this.employeeRepo = employeeRepo;
        this.modelMapper = modelMapper;
    }

    public Optional<EmployeeDTO> getEmployeeById(Long id) {
//      Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
//      return employeeEntity.map(employeeEntity1 -> modelMapper.map(employeeEntity1, EmployeeDTO.class));

      return employeeRepo.findById(id).map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class));
  }

    	  public List<EmployeeDTO> getAllEmployees() {
    	        List<EmployeeEntity> employeeEntities = employeeRepo.findAll();
    	        return employeeEntities
    	                .stream()
    	                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
    	                .collect(Collectors.toList());
    	    }
    	  public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {
//            to check if user is admin
//            log something
            EmployeeEntity toSaveEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);
            System.out.println(toSaveEntity);
            EmployeeEntity savedEmployeeEntity = employeeRepo.save(toSaveEntity);
            return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
        }

		public EmployeeDTO updateNewEmployee(Long Id, EmployeeDTO employeeDTO) {
			EmployeeEntity employeeEntity=modelMapper.map(employeeDTO, EmployeeEntity.class);
			employeeEntity.setId(Id);
			EmployeeEntity savedEmployee=employeeRepo.save(employeeEntity);
			return modelMapper.map(savedEmployee, EmployeeDTO.class);
		}
		public void deleteNewEmployee(Long Id) {
			 employeeRepo.deleteById(Id);
		}

		public EmployeeDTO changeNewEmployee(Long id, Map<String, Object> updates) {
			boolean exists=employeeRepo.existsById(id);
			if (!exists) return null;
			EmployeeEntity employeeEntity=employeeRepo.findById(id).orElse(null);
			updates.forEach((field, value)-> {
				java.lang.reflect.Field fieldToBeUpdated=ReflectionUtils.findRequiredField(EmployeeEntity.class, field);
						fieldToBeUpdated.setAccessible(true);
						ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value);
			});
			return modelMapper.map(employeeRepo.save(employeeEntity), EmployeeDTO.class);
		}
}
