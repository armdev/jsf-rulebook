package com.project.web.flow;

import com.deliveredtechnologies.rulebook.DecisionBook;
import com.deliveredtechnologies.rulebook.StandardDecision;
import com.project.web.model.ApplicantBean;

/**
 *
 * @author Admin
 */
public class HomeLoanRateDecisionBook extends DecisionBook<ApplicantBean, Float> {

    @Override
    protected void defineRules() {
        //credit score under 600 gets a 4x rate increase
        addRule(StandardDecision.create(ApplicantBean.class, Float.class)
                .when(facts -> facts.getOne().getCreditScore() < 600)
                .then((facts, result) -> result.setValue(result.getValue() * 4f))
                .stop());

        //credit score between 600 and 700 pays a 1 point increase
        addRule(StandardDecision.create(ApplicantBean.class, Float.class)
                .when(facts -> facts.getOne().getCreditScore() < 700)
                .then((facts, result) -> result.setValue(result.getValue() + 1f)));

        //credit score is 700 and they have at least $25,000 cash on hand
        addRule(StandardDecision.create(ApplicantBean.class, Float.class)
                .when(facts
                        -> facts.getOne().getCreditScore() >= 700
                && facts.getOne().getCashOnHand() >= 25000f)
                .then((facts, result) -> result.setValue(result.getValue() - 0.25f)));

        //first time homebuyers get 20% off their rate (except if they have a creditScore < 600)
        addRule(StandardDecision.create(ApplicantBean.class, Float.class)
                .when(facts -> facts.getOne().isFirstTimeHomeBuyer())
                .then((facts, result) -> result.setValue(result.getValue() * 0.80f)));
    }
}
