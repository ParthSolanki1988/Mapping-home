package com.simform.manytomanymapping.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "employee")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "emp_id")
  Long empId;

  @Column(name = "emp_name")
  String empName;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinTable(name = "employee_project",
      joinColumns = @JoinColumn(name = "emp_id"),
      inverseJoinColumns = @JoinColumn(name = "prj_id"))
  List<Project> projects = new ArrayList<>();

  public List<Project> getProjects() {
    return projects;
  }

  public void setProjects(List<Project> projects) {
    this.projects = projects;
  }

  //  public void addProject(Project project) {
//    this.projects.add(project);
//    project.getEmployees().add(this);
//  }
}
