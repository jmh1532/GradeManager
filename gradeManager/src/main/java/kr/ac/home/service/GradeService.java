package kr.ac.home.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.home.dao.GradeDAO;
import kr.ac.home.model.Grade;

@Service
public class GradeService {
	
	@Autowired
	private GradeDAO gradeDao;
	public List<Grade> getCurrent() {
		
		return gradeDao.getGrades();
	}
	public void insert(Grade grade) {
		gradeDao.insert(grade);
		
	}
	public List<Grade> getYears(){
		return gradeDao.getYearsScore();
	}
	public List<Grade> getGrade2019(){
		return gradeDao.getGrade2019();
	}

}
