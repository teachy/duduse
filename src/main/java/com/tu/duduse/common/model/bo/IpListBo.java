package com.tu.duduse.common.model.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IpListBo {
  private String ip;
  private String query;
  private long useTime;
}
