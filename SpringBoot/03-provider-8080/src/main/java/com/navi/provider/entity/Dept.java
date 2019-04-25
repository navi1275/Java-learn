package com.navi.provider.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Dept Class
 *
 * @author navi
 * @date 2019-04-12
 * @since 1.0.0
 */
@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Dept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String deptName;
}
