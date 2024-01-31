package com.app.service;

public class SettlementInfo {

    private int numberOfMembers;
    private double equalShare;
    private double settlementAmount;

    // Constructors, getters, and setters

    public SettlementInfo() {
    }

    public SettlementInfo(int numberOfMembers, double equalShare, double settlementAmount) {
        this.numberOfMembers = numberOfMembers;
        this.equalShare = equalShare;
        this.settlementAmount = settlementAmount;
    }

    public int getNumberOfMembers() {
        return numberOfMembers;
    }

    public void setNumberOfMembers(int numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

    public double getEqualShare() {
        return equalShare;
    }

    public void setEqualShare(double equalShare) {
        this.equalShare = equalShare;
    }

    public double getSettlementAmount() {
        return settlementAmount;
    }

    public void setSettlementAmount(double settlementAmount) {
        this.settlementAmount = settlementAmount;
    }
}

