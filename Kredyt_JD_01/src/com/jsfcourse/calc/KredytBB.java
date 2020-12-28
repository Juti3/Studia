package com.jsfcourse.calc;

import javax.inject.Inject;
import static java.lang.Math.*;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
//@SessionScoped
public class KredytBB {
	private String a;
	private String b;
	private String n;
	private Double result;

	@Inject
	FacesContext ctx;


	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getN() {
		return n;
	}

	public void setN(String n) {
		this.n = n;
	}
	

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	public boolean doTheMath() {
		try {
			double a = Double.parseDouble(this.a);
			double b = Double.parseDouble(this.b);
			double n = Double.parseDouble(this.n);
			
			b=b/100;
			double q=1+(b/12);
	
			result =a*(pow(q,n))*(q-1)/((pow(q,n))-1);

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "B³¹d podczas przetwarzania parametrów", null));
			return false;
		}
	}
	
		public String calc() {
			if (doTheMath()) {
				ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Rata: " + result, null));
			}
			return null;
		}

	}
