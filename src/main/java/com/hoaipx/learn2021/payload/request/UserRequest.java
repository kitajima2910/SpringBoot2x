package com.hoaipx.learn2021.payload.request;

import com.hoaipx.learn2021.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class UserRequest extends User {
}
