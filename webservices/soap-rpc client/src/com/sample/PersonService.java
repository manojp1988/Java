/**
 * PersonService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sample;

public interface PersonService extends javax.xml.rpc.Service {
    public java.lang.String getPersonAddress();

    public com.sample.Person getPerson() throws javax.xml.rpc.ServiceException;

    public com.sample.Person getPerson(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
