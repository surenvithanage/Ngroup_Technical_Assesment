package org.assessment.bean;

import org.beanio.annotation.Field;

public class Trailer {
    @Field(at = 1, length = 1)
    private String recordType;

    @Field(at = 14, length = 15, literal = "FLAT_FILE")
    private String fileType;

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
