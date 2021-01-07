package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select("SELECT sysdate FROM dual")
	//getTime메소드가 어노테이션에 있는 쿼리문을 실행한다고 명시
	public String getTime();
}
//클래스 로딩
//커넥션 열기
//statment 얻기(여기까지 mybatis가 대신 실행)

//sql query실행("SELECT sysdate FROM dual")

//resultSet 처리(여기부터 또 mybatis가 대신 실행)
//커넥션 닫기
