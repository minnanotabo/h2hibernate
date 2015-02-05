package com.ms.h2hibernate;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SUBSCRIPTIONPLAN")
public class SubscriptionPlan {
	String planId;
	String title;
	String desc;
	String type; // ongoing, one-time
	float basePrice;
	Date buyStartDate;
	Date buyEndDate;
}
