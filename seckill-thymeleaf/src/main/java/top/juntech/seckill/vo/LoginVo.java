package top.juntech.seckill.vo;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@ToString(callSuper = true)
public class LoginVo {
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	

}
