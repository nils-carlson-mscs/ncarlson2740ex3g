package ex3g;

import java.text.DecimalFormat;
public class Payroll {
	
	private int id;
	private String	name;
	private double payRate;
	private double hours;
	
	
	public Payroll(int id, String name, double payRate) {
		super();
		this.id = id;
		this.name = name;
		this.payRate = payRate;	
		this.hours = 0.0;
	}

	public Payroll(int id, String name, double payRate, double hours) {
		super();
		this.id = id;
		this.name = name;
		this.payRate = payRate;	
		this.hours = hours;
	}

	public int getId() {
		return this.id;
	}
	public boolean setId(int id) {
		if (id > 100) {
			this.id = id;
			return true;
		}
		else {
			return false;
		}
	}
		
	public String getName() {
		return this.name;
	}
	
	public boolean setName(String name) {		
		if(name.isEmpty()){
			return false;			
		}
		else {
			this.name = name;
			return true;
		}
		
	}
	
	public double getPayRate() {
		return this.payRate;
	}
	
	public boolean setPayRate(double payRate) {
		if (payRate >= 7.25 && payRate <= 100) {
			this.payRate = payRate;
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
	
	public double getHours() {
		return this.hours;
	}
	
	public void setHours(double hours) {
		this.hours = hours;
	}

	@Override
	public String toString() {
		DecimalFormat ratefmt	= new DecimalFormat("#####.00");
		return  this.id+" "  + this.name + ", payRate ="+ " " + ratefmt.format(this.payRate);
	}
	
	public double calcGrossPay() {
		double grossPay = 0;
		double overtimePay = 0;
		
		if (this.hours > 40)
		{
			grossPay = 40 * payRate;
			
			overtimePay = (this.hours - 40) * (payRate * 1.5);
			
			grossPay += overtimePay;
		}
		else
		{
			grossPay = payRate * this.hours;
		}
	return grossPay;
	}
	
	public void addHours(double hours) {
		this.hours += hours;
	}
	
/*
	public boolean setId() {
		if (id > 100) {
			this.id = id;
			return true;
		}
		else {
			return false;
		}
	}
 */

}
