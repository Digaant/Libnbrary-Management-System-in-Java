package Entities;

import lombok.Builder;

import java.time.LocalDateTime;


public class Issue {
    private Long IID;
    private Long UID;
    private Long BID;
    private LocalDateTime issueDate;
    private int period;
    private LocalDateTime returnDate;
    private int fine;

    @Builder
    public Issue(Long IID, Long UID, Long BID, LocalDateTime issueDate, int period, LocalDateTime returnDate, int fine) {
        this.IID = IID;
        this.UID = UID;
        this.BID = BID;
        this.issueDate = issueDate;
        this.period = period;
        this.returnDate = returnDate;
        this.fine = fine;
    }

    public Long getIID() {
        return IID;
    }

    public void setIID(Long IID) {
        this.IID = IID;
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public Long getBID() {
        return BID;
    }

    public void setBID(Long BID) {
        this.BID = BID;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "IID=" + IID +
                ", UID=" + UID +
                ", BID=" + BID +
                ", issueDate=" + issueDate +
                ", period=" + period +
                ", returnDate=" + returnDate +
                ", fine=" + fine +
                '}';
    }
}
