package com.hoaipx.learn2021.payload.request;

import com.hoaipx.learn2021.entity.TestTable;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class TestTableRequest extends TestTable  {

    List<TestTableRequest> list;

}
