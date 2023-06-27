package com.simform.manytomanymapping.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "project")
public class Project {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "prj_id")
  Long proId;

  @Column(name = "prj_name")
  String proName;

  @ManyToMany(mappedBy = "projects")
      @JsonIgnore
  List<Employee> employees = new ArrayList<>();

  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }

  public void addEmployee(Employee employee) {
    this.employees.add(employee);
    employee.getProjects().add(this);
  }

}
