package com.tepsivo.pv.report.web.api.dto;

public enum ReportStatus {
    NEW(0),
    IN_REVIEW(1),
    CLOSED(2);

    private final int code;

    ReportStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ReportStatus fromCode(int code) {
        for (ReportStatus status : values()) {
            if (status.code == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid ReportStatus code: " + code);
    }
}
