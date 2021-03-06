/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.arven.rs.provider;

import javax.ws.rs.core.Context;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * Generates JAXB {@link Marshaller}s configured to emit fragments, rather 
than
 * standalone XML documents. This suppresses the <code>&lt;?xml ... 
&gt;</code>
 * declaration in generated XML, which otherwise would consume considerable
 * bandwidth.
 */
//@Provider
public class AnyElementMarshaller implements ContextResolver<Marshaller> {

        private final Providers providers;

        public AnyElementMarshaller(@Context Providers providers) {
                this.providers = providers;
        }

        @Override
        public Marshaller getContext(Class<?> type) {
            try {
                JAXBContext context = JAXBContext.newInstance("io.github.arven.rs.services.example:io.github.arven.rs.types");
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
                System.out.println("<<<<RETURNING MARSHALLER>>>>");
                return marshaller;
            } catch (JAXBException je) {
                System.out.println("<<<<RETURNING NULLLLLLLL>>>> " + je.getMessage());
                return null;
            }
        }
        
}