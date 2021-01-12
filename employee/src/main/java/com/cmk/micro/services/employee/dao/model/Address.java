package com.cmk.micro.services.employee.dao.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Address {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
 private long id;
 private int doorNumber;
 private String street;
 private String city;
 private String state;
 private long pincode;
 
 @OneToOne(fetch = FetchType.LAZY, optional = false)
 @JoinColumn(name="id")
 private Employee employee;
}
