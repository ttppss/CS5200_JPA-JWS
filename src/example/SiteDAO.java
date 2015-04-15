package example;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/site")
public class SiteDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JWS_JPA");
	EntityManager em = factory.createEntityManager();
	
	//crud
	//findSite
	@GET
	@Path("/{siteId}")
	private Site findSite(@PathParam("siteId") int siteId)
	{
		return em.find(Site.class, siteId);		
	}
	
	//createSite
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	private List<Site> createSite(Site site) {
		//wrap it into transaction, start transaction and commit any changes
		//only when you need to update the database, you need a transaction;
		em.getTransaction().begin();
		em.persist(site);
		em.getTransaction().commit();
		return (List<Site>) site; //"site" become a managed object, meaning the framwork now aware of this object and is now tracking it
	}
	
	//findAllSites
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	private List<Site> findAllSites()
	{
		
		//JPQL, Object oriented SQL, does not reference any table, only reference object and attributes
		Query query = em.createQuery("select site from Site site");//this is class Site, not table Site;
		return (List<Site>)query.getResultList();//What is "Casts" Mean?		
	}
	
	//updateSite
	@PUT
	@Path("/{siteId}")
	private List<Site> updateSite(@PathParam("siteId") int siteId, Site site)
	{
		em.getTransaction().begin();
		em.merge(site);
		em.getTransaction().commit();
		return findAllSites();
	}
	
	//removeSite 
	@DELETE
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	private void deleteSite(int id) {
		em.getTransaction().begin();
		Site site = em.find(Site.class, id);
		em.remove(site);
		em.getTransaction().commit();
	}
	
	//private Site removeSite(Site site)

	public static void main(String[] args) {
		SiteDAO sitedao = new SiteDAO();
		//Site st = new Site();
		//sitedao.deleteSite(2);
		List<Site> sites = sitedao.findAllSites();
		//sitedao.findSite(3);
		//sitedao.deleteSite(3);
		//System.out.println(site.getName());
		for(Site site : sites)
		{
			System.out.println(site.getLongitude());
		}
//		st.setLongitude(11);
//		sitedao.updateSite(2, st);
	}

	

	

}































