package edu.icet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "items")
public class ItemsEntity {
    @Id
    private String itemCode;
    private String productName;
    private String category;
    private double price;
}
