package hotel.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Notice {

	private int id;
	private String title;
	private String detail;
	private String writer;
	private Timestamp date;
	private int count;
	
	public Notice() { }

	public Notice(int id, String title, String detail, String writer, Timestamp date, int count) {
		super();
		this.id = id;
		this.title = title;
		this.detail = detail;
		this.writer = writer;
		this.date = date;
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", detail=" + detail + ", writer=" + writer + ", date=" + date
				+ ", count=" + count + "]";
	}

}
