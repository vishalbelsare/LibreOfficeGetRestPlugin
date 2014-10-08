/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.github.binnarywolf;

import com.github.binnarywolf.json.JSONParser;
import com.github.binnarywolf.rest.RestClient;
import com.sun.star.lang.Locale;
import com.sun.star.lang.XSingleComponentFactory;
import com.sun.star.lib.uno.helper.Factory;
import com.sun.star.lib.uno.helper.WeakBase;
import com.sun.star.registry.XRegistryKey;
import com.sun.star.uno.XComponentContext;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.Request;

/**
 *
 * @author binnarywolf
 */
public class LibreOfficeGetRestPluginImpl extends WeakBase
        implements  XLibreOfficeGetRestPlugin,
        com.sun.star.lang.XServiceInfo,
        com.sun.star.lang.XLocalizable{

    public static XSingleComponentFactory __getComponentFactory(String sImplementationName) {
        XSingleComponentFactory xFactory = null;

        if (sImplementationName.equals(m_implementationName)) {
            xFactory = Factory.createComponentFactory( LibreOfficeGetRestPluginImpl.class, m_serviceNames);
        }
        return xFactory;
    }

    public static boolean __writeRegistryServiceInfo(XRegistryKey xRegistryKey) {
        return Factory.writeRegistryServiceInfo(m_implementationName,
                m_serviceNames,
                xRegistryKey);
    }
    private final XComponentContext m_xContext;
    public LibreOfficeGetRestPluginImpl(XComponentContext context) {
        m_xContext = context;
    }
    
    private static final String m_implementationName = LibreOfficeGetRestPluginImpl.class.getName();
    private static final String[] m_serviceNames = {
        "com.github.binnarywolf.LibreOfficeGetRestPlugin"};
    private com.sun.star.lang.Locale m_locale = new com.sun.star.lang.Locale();
     
    // com.sun.star.lang.XServiceInfo:
    public String getImplementationName() {
        return m_implementationName;
    }

   public boolean supportsService(String sService) {
        int len = m_serviceNames.length;

        for (int i = 0; i < len; i++) {
            if (sService.equals(m_serviceNames[i])) {
                return true;
            }
        }
        return false;
    }

      public String[] getSupportedServiceNames() {
        return m_serviceNames;
    }

   // com.sun.star.lang.XLocalizable:
    public void setLocale(com.sun.star.lang.Locale eLocale) {
        m_locale = eLocale;
    }

    public com.sun.star.lang.Locale getLocale() {
        return m_locale;
    }

    public String get(String URL) {
     return new RestClient().get(URL);
    }

    public String parseJSON(String json, String pattern) {
	System.out.println("Parse json start");
        String result=JSONParser.parseJSON(json,pattern);
       return result;
    }
 

   
}
