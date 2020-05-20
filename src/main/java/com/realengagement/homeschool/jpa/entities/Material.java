package com.realengagement.homeschool.jpa.entities;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private Long classesId; 
	private Long subjectId; 
	private Long chapterId; 
	private Long materialType; 
	private String fileType; 
	private Long fileSize; 
	private Long authorId; 
	private Blob material_data;
	public Long getId() {
		return id;
	}
	public Long getClassesId() {
		return classesId;
	}
	public void setClassesId(Long classesId) {
		this.classesId = classesId;
	}
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	public Long getChapterId() {
		return chapterId;
	}
	public void setChapterId(Long chapterId) {
		this.chapterId = chapterId;
	}
	public Long getMaterialType() {
		return materialType;
	}
	public void setMaterialType(Long materialType) {
		this.materialType = materialType;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	public Long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
	public Blob getMaterial_data() {
		return material_data;
	}
	public void setMaterial_data(Blob material_data) {
		this.material_data = material_data;
	} 
	
	

}
