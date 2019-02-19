package com.metacube.soap.service;

public class TriangleAreaProxy implements com.metacube.soap.service.TriangleArea {
  private String _endpoint = null;
  private com.metacube.soap.service.TriangleArea triangleArea = null;
  
  public TriangleAreaProxy() {
    _initTriangleAreaProxy();
  }
  
  public TriangleAreaProxy(String endpoint) {
    _endpoint = endpoint;
    _initTriangleAreaProxy();
  }
  
  private void _initTriangleAreaProxy() {
    try {
      triangleArea = (new com.metacube.soap.service.TriangleAreaServiceLocator()).getTriangleArea();
      if (triangleArea != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)triangleArea)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)triangleArea)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (triangleArea != null)
      ((javax.xml.rpc.Stub)triangleArea)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.metacube.soap.service.TriangleArea getTriangleArea() {
    if (triangleArea == null)
      _initTriangleAreaProxy();
    return triangleArea;
  }
  
  public double calculateArea(double side1, double side2, double side3) throws java.rmi.RemoteException{
    if (triangleArea == null)
      _initTriangleAreaProxy();
    return triangleArea.calculateArea(side1, side2, side3);
  }
  
  
}