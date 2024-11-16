package Project1.UberX.dto;

import lombok.Data;

@Data
public class RideStartDTO {
	
	private String otp;

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public RideStartDTO(String otp) {
		this.otp = otp;
	}

}
