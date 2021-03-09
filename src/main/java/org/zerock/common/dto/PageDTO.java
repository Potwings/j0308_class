package org.zerock.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageDTO {
	
	@Default
	private int page = 1;
	
	@Default
	private int perSheet = 10;
	
	public int getSkip() {
		
		return (page - 1) * perSheet;
		
	}

}
