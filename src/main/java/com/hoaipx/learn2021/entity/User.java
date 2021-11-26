package com.hoaipx.learn2021.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hoaipx.learn2021.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@Setter
@DynamicUpdate
@DynamicInsert
@Accessors(chain = true)
@Entity
@Table(name = "`User`")
@TableName("User")
@ApiModel(value = "User")
public class User extends BaseEntity {

    @Id
    @Column(name = "username")
    @ApiModelProperty(value = "Username")
    private String username;

    @Column(name = "password")
    @ApiModelProperty(value = "Password")
    private String password;

}
