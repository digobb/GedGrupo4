package br.upf.ads.topicos.appged;
import javax.persistence.EntityManager;

import br.upf.ads.topicos.entities.Usuario;
import br.upf.ads.topicos.jpa.JpaUtil;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        EntityManager em = JpaUtil.getInstance().getEntityManager();
        em.getTransaction().begin();
        //em.merge(new Usuario(null, "Administrador", "admin@admin", "123456"));
        em.getTransaction().commit(); 
    	assertTrue( true );
    }
}
