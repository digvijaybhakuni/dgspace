/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgstack.jee7.jsf.ui;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.dgstack.jee7.jsf.utils.SessionUtils;

/**
 *
 * @author digvijayb
 */
@ManagedBean(name = "login")
@SessionScoped
public class LoginBean implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String validateUsernamePassword() {
        if ("admin".equals(getUsername()) && "admin".equals(getPassword())) {
            SessionUtils.getSession().setAttribute("username", "Admin");
            return "admin";
        } else {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Invalid Username or Password", "LOL"));
            
            return "login";
        }   
    }
    
    public String logout(){
    	SessionUtils.getSession().setAttribute("username", null);
    	SessionUtils.getSession().invalidate();
    	return "index";
    }
    
    
    
}
