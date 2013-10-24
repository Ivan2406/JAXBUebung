package xml.jaxb;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Buch")
public class Buch 
{
	private String name;
	private String autor;
	private String verlag;
	
	@XmlAttribute(name = "name")
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	@XmlAttribute(name = "autor")
	public String getAutor() 
	{
		return autor;
	}
	
	public void setAutor(String autor) 
	{
		this.autor = autor;
	}
	
	@XmlAttribute(name = "verlag")
	public String getVerlag() 
	{
		return verlag;
	}
	
	public void setVerlag(String verlag) 
	{
		this.verlag = verlag;
	}
}
