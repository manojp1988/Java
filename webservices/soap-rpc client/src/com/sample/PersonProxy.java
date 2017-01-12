package com.sample;

public class PersonProxy implements com.sample.Person {
  private String _endpoint = null;
  private com.sample.Person person = null;
  
  public PersonProxy() {
    _initPersonProxy();
  }
  
  public PersonProxy(String endpoint) {
    _endpoint = endpoint;
    _initPersonProxy();
  }
  
  private void _initPersonProxy() {
    try {
      person = (new com.sample.PersonServiceLocator()).getPerson();
      if (person != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)person)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)person)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (person != null)
      ((javax.xml.rpc.Stub)person)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.sample.Person getPerson() {
    if (person == null)
      _initPersonProxy();
    return person;
  }
  
  public java.lang.String getCategory(int age) throws java.rmi.RemoteException{
    if (person == null)
      _initPersonProxy();
    return person.getCategory(age);
  }
  
  
}