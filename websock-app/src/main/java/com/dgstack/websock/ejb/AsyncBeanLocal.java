/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgstack.websock.ejb;

import javax.ejb.Local;
import javax.ws.rs.container.AsyncResponse;

/**
 *
 * @author dbhakuni
 */
@Local
public interface AsyncBeanLocal {
     public void compute(final AsyncResponse response);
}
