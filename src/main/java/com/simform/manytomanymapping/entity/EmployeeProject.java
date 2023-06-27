package com.simform.manytomanymapping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employee_project")
public class EmployeeProject {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @ManyToOne
  @JoinColumn(name = "emp_id")
  Employee employee;

  @ManyToOne
  @JoinColumn(name = "prj_id")
  Project project;

}
