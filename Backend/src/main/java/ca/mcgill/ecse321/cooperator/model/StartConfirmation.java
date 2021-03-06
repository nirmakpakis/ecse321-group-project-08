package ca.mcgill.ecse321.cooperator.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import java.sql.Date;
import javax.persistence.Id;

@Entity
public class StartConfirmation{
private CoopPosition coopPosition;

@OneToOne
public CoopPosition getCoopPosition() {
   return this.coopPosition;
}

public void setCoopPosition(CoopPosition coopPosition) {
   this.coopPosition = coopPosition;
}

private Employer employer;

@ManyToOne
public Employer getEmployer() {
   return this.employer;
}

public void setEmployer(Employer employer) {
   this.employer = employer;
}

private Date evaluationDate;

public void setEvaluationDate(Date value) {
this.evaluationDate = value;
    }
public Date getEvaluationDate() {
return this.evaluationDate;
    }
private int confirmationID;

public void setConfirmationID(int value) {
this.confirmationID = value;
    }
@Id
public int getConfirmationID() {
return this.confirmationID;
       }
   }
