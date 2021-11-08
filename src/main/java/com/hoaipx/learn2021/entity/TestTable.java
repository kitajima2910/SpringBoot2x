package com.hoaipx.learn2021.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hoaipx.learn2021.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "ABC")
@TableName("ABC")
@ApiModel(value = "ABC")
public class TestTable extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "ID")
    private Integer id;

    @Column(name = "name")
    @ApiModelProperty(value = "Name")
    private String name;

}
