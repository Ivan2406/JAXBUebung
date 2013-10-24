package xml.jaxbtest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException; 
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import xml.jaxb.*;

public class BuechereiTest 
{
	private static final String BUECHEREI_XML ="./buecherei-jaxb.xml";
	
	public static void main(String[] args) throws JAXBException, FileNotFoundException 
	{
		// TODO Auto-generated method stub
		ArrayList<Buch> buchlist = new ArrayList<Buch>();
		
		//Create books
		Buch buch1 = new Buch();
		buch1.setName("Besuch der alten Dame");
		buch1.setAutor("Friedrich Dürrenmatt");
		buch1.setVerlag("Frick");
		buchlist.add(buch1);
		
		Buch buch2 = new Buch();
		buch1.setName("Die Vermessung der Welt");
		buch1.setAutor("Daniel Kehlmann");
		buch1.setVerlag("OEGB");
		buchlist.add(buch2);
		
		//Create library & assigning books
		Buecherei buecherei = new Buecherei();
		buecherei.setName("Thalia");
		buecherei.setAdresse("Mariahilferstraße 22");
		buecherei.setBuchList(buchlist);
		
		//create JAXB context and instantiate marshaller
		JAXBContext context = JAXBContext.newInstance(Buecherei.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				
		//Write to System.out
		m.marshal(buecherei, System.out);
				
		//Write to File
		m.marshal(buecherei, new File(BUECHEREI_XML));
		
		//get variable from the xml file, created in the lines above
		System.out.println();
		System.out.println("Output from the xml file");
		
		Unmarshaller um = context.createUnmarshaller();
		
		Buecherei buecherei2 = (Buecherei)um.unmarshal(new FileReader(BUECHEREI_XML));
		ArrayList<Buch> list = buecherei2.getBuchList();
		for(Buch b:list)
		{
			System.out.println("Buch: " + b.getName() + " @Bucherei: " + buecherei2.getName() + "\nAutor: " + b.getAutor() + "\nVerlag: " + b.getVerlag());
			System.out.println();
		}
	}
}
