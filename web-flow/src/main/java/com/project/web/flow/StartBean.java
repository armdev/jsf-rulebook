/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.web.flow;

import com.project.web.model.ApplicantBean;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Admin
 */
@ManagedBean
@Named(value = "startBean")
@RequestScoped
public class StartBean implements Serializable {

    private static final long serialVersionUID = 1L;
   
    private String message;
   
    private ApplicantBean applicantBean = new ApplicantBean();

    /**
     * Creates a new instance of StartBean
     */
    public StartBean() {
    }

    public void sendMessage() {
        HomeLoanRateDecisionBook homeLoanRateDecisionBook = new HomeLoanRateDecisionBook();
       // ApplicantBean applicant = new ApplicantBean(650, 20000, true);
        homeLoanRateDecisionBook.withDefaultResult(4.5f).given("applicant", applicantBean).run();

        System.out.println("Applicant qualified for the following rate: " + homeLoanRateDecisionBook.getResult());
        message = homeLoanRateDecisionBook.getResult().toString();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ApplicantBean getApplicantBean() {
        return applicantBean;
    }

    public void setApplicantBean(ApplicantBean applicantBean) {
        this.applicantBean = applicantBean;
    }


}
