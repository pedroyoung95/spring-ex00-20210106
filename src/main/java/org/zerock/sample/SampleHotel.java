package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@ToString
@Getter
//@AllArgsConstructor -> 모든 필드를 파라미터로 받는 생성자 만듦
@RequiredArgsConstructor //@NonNull이나 final이 붙은 필드만 파라미터로 받는 생성자 만듦
public class SampleHotel {

	@NonNull
	private Chef chef;
	
//	public SampleHotel(Chef chef) {
//		this.chef = chef;
//	}
}
