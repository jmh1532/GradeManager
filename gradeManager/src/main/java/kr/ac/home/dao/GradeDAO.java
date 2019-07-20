package kr.ac.home.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kr.ac.home.model.Grade;

@Repository
public class GradeDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {

		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Grade> getGrade2019() {
		String sqlStatement = "select * from grades where year=2019";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Grade>() {

			@Override
			public Grade mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Grade grade = new Grade();
				grade.setYear(rs.getInt("year"));
				grade.setSemester(rs.getInt("semester"));
				grade.setScore(rs.getInt("score"));
				grade.setLecture(rs.getString("lecture"));
				grade.setCode(rs.getString("code"));
				grade.setDivision(rs.getString("division"));

				return grade;
			}

		});

	}
	//전체 정보
	public List<Grade> getGrades() {
		String sqlStatement = "select * from grades";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Grade>() {

			@Override
			public Grade mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Grade grade = new Grade();
				grade.setYear(rs.getInt("year"));
				grade.setSemester(rs.getInt("semester"));
				grade.setScore(rs.getInt("score"));
				grade.setLecture(rs.getString("lecture"));
				grade.setCode(rs.getString("code"));
				grade.setDivision(rs.getString("division"));

				return grade;
			}

		});

	}
	//연도별 간략 정보
	public List<Grade> getYearsScore() {
		String sqlStatement = "select year, semester, code, lecture, division, sum(score) from grades group by year, semester";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Grade>() {
			@Override
			public Grade mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Grade grade = new Grade();

				grade.setYear(rs.getInt("year"));
				grade.setSemester(rs.getInt("semester"));
				grade.setCode(rs.getString("code"));
				grade.setLecture(rs.getString("lecture"));
				grade.setDivision(rs.getString("division"));
				grade.setScore(rs.getInt("sum(score)"));
				
				return grade;
			}
		});
	}
	//삽입
	public boolean insert(Grade grade) {

		int year = grade.getYear();
		int semester = grade.getSemester();
		int score = grade.getScore();
		String lecture = grade.getLecture();
		String code = grade.getCode();
		String division = grade.getDivision();

		String sqlStatement = "insert into grades (year, semester, code, lecture, division, score) values(?, ?,?, ?,?,?)";
		// 리턴값 integer
		return (jdbcTemplate.update(sqlStatement,
				new Object[] { year, semester, code, lecture, division, score }) == 1);
	}
	
	
	
	/* 업데이트/ 삭제/ 갯수
	public boolean update(Grade grade) {
		int year = grade.getYear();
		int semester = grade.getSemester();
		int score = grade.getScore();
		String code = grade.getCode();
		String division = grade.getDivision();

		String sqlStatement = "update grades set year=?, semester=?, division=?, score=? where code=?";
		// 리턴값 integer
		return (jdbcTemplate.update(sqlStatement, new Object[] { year, semester, division, score, code }) == 1);
	}

	public boolean delete(int code) {
		String sqlStatement = "delete from grades where code=?";
		return (jdbcTemplate.update(sqlStatement, new Object[] { code }) == 1);
	}
	
	public int getRowCount() {
		String sqlStatement = "select count(*) from grades";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}


	public Grade getGrade(int year) {
		String sqlStatement = "select * from grades where year = ?";
		return jdbcTemplate.queryForObject(sqlStatement, new Object[] { year }, new RowMapper<Grade>() {
			@Override
			public Grade mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Grade grade = new Grade();

				grade.setYear(rs.getInt("year"));
				grade.setSemester(rs.getInt("semester"));
				grade.setScore(rs.getInt("score"));
				grade.setLecture(rs.getString("lecture"));
				grade.setCode(rs.getString("code"));
				grade.setDivision(rs.getString("division"));

				return grade;
			}
		});

	}
	 */
}
