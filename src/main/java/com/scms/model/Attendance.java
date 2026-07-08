package com.scms.model;

import java.time.LocalDate;
import java.util.Objects;

public class Attendance {

	private int attendanceId;
	private Student student;
	private Subject subject;
	private Faculty faculty;
	private LocalDate attendanceDate;
	private String status;
	
	public Attendance() {
	}

	public Attendance(int attendanceId, Student student, Subject subject, Faculty faculty, LocalDate attendanceDate,
			String status) {
		super();
		this.attendanceId = attendanceId;
		this.student = student;
		this.subject = subject;
		this.faculty = faculty;
		this.attendanceDate = attendanceDate;
		this.status = status;
	}

	public int getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public LocalDate getAttendanceDate() {
		return attendanceDate;
	}

	public void setAttendanceDate(LocalDate attendanceDate) {
		this.attendanceDate = attendanceDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Attendance [attendanceId=" + attendanceId + ", student=" + student + ", subject=" + subject
				+ ", faculty=" + faculty + ", attendanceDate=" + attendanceDate + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(attendanceDate, attendanceId, faculty, status, student, subject);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attendance other = (Attendance) obj;
		return Objects.equals(attendanceDate, other.attendanceDate) && attendanceId == other.attendanceId
				&& Objects.equals(faculty, other.faculty) && Objects.equals(status, other.status)
				&& Objects.equals(student, other.student) && Objects.equals(subject, other.subject);
	}
	
}
