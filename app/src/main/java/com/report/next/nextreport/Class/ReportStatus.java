package com.report.next.nextreport.Class;

/**
 * Created by USER on 12/01/2017.
 */

public enum ReportStatus {

    PROCESSED(0, "Process"),
    APPROVED(1, "Approved"),
    REJECTED(2, "Rejected");

    private final int code;
    private final String status;

    public int code() {
        return code;
    }

    public String status() {
        return status;
    }

    ReportStatus(int code, String status) {
        this.code = code;
        this.status = status;
    }
}
