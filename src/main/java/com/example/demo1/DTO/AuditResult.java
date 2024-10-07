package com.example.demo1.DTO;

public class AuditResult {
    private boolean isRight;
    private String checkItem;

    public AuditResult(boolean isRight, String checkItem) {
        this.isRight = isRight;
        this.checkItem = checkItem;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    public String getCheckItem() {
        return checkItem;
    }

    public void setCheckItem(String checkItem) {
        this.checkItem = checkItem;
    }
}
