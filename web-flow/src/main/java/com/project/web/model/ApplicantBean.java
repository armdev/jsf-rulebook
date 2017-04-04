/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.web.model;

public class ApplicantBean {

    private int creditScore;
    private float cashOnHand;
    private boolean firstTimeHomeBuyer;

    public ApplicantBean() {
    }

    public ApplicantBean(int creditScore, float cashOnHand, boolean firstTimeHomeBuyer) {
        this.creditScore = creditScore;
        this.cashOnHand = cashOnHand;
        this.firstTimeHomeBuyer = firstTimeHomeBuyer;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public float getCashOnHand() {
        return cashOnHand;
    }

    public void setCashOnHand(float cashOnHand) {
        this.cashOnHand = cashOnHand;
    }

    public boolean isFirstTimeHomeBuyer() {
        return firstTimeHomeBuyer;
    }

    public void setFirstTimeHomeBuyer(boolean firstTimeHomeBuyer) {
        this.firstTimeHomeBuyer = firstTimeHomeBuyer;
    }

}
