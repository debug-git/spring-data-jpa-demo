package com.example.jpademo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <p>
 * 全国身份证地区编码
 * </p>
 *
 * @author mybatis-plus
 * @since 2019-06-04
 */
@Data
@ToString
@Accessors(chain = true)
@Entity
@Table(name = "city")
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    private String province;

    private String city;

    @Id
    private String zone;

    private String desc;


}
