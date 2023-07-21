package com.merdekacloud.Springjpaexample.Entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name ="product")
//@Table(name = "stock_daily_record", catalog = "mkyongdb",
//        uniqueConstraints = @UniqueConstraint(columnNames = "DATE"))
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId", unique = true, nullable = false)
    private Long productId;

    @Column(name = "productName", unique = false, nullable = false, length = 100)
    private String productName;

    @Column(name = "productPrice", nullable = false)
    private BigDecimal productPrice;

    //technically optional but still needed to save data
    @Column(name = "category_id")
    private Long category_id;

}
