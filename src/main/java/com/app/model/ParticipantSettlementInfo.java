package com.app.model;

public class ParticipantSettlementInfo {

    private String participantName;
    private double equalShare;
    private double settlementAmount;

    public ParticipantSettlementInfo(String participantName, double equalShare, double settlementAmount) {
        this.participantName = participantName;
        this.equalShare = equalShare;
        this.settlementAmount = settlementAmount;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
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
