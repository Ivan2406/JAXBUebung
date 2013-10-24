package xml.jaxb;

import java.util.ArrayList;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Buecherei 
{
	private ArrayList<Buch> buchLists;
	private String name;
	private String adresse;
	
	
	@XmlElementWrapper(name = "buchList")
	@XmlElement(name = "buch")
	public ArrayList<Buch> getBuchList() 
	{
		return buchLists;
	}
	
	public void setBuchList(ArrayList<Buch> buchList) 
	{
		this.buchLists = buchList;
	}
	
	@XmlAttribute(name = "name")
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	@XmlAttribute(name = "adresse")
	public String getAdresse()
	{
		return adresse;
	}
	
	public void setAdresse(String adresse)
	{
		this.adresse = adresse;
	}
}
