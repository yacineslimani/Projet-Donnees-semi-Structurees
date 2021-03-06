package fr.uvsq;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;

public class MusicbrainzLoadData {

	String url;
	MusicbrainzDOMTransform musicbrainzDOMTransform = new MusicbrainzDOMTransform();

	public MusicbrainzLoadData() {
		super();

	}

	public void getSongsByAuthor (String artist){
			
		this.url ="http://musicbrainz.org/ws/2/recording/?query=artist:"+artist+"&limit=10";


		try{
			System.out.println(url);
			BufferedReader urlReader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));

			FileWriter localFile = new FileWriter(new File("src/main/resources/xmlFile/MusicBrainzSong.xml"));


			
					

			System.out.println("Telechargement términé");
			String s;
			while((s = urlReader.readLine()) != null){
				localFile.write(s);
			}
			urlReader.close();
			localFile.close();
			
			musicbrainzDOMTransform.transformSong();
			
		}
		catch(Exception e){
			System.out.println("Erreur : " + e);
		}
	}

	
	
	public void getAlbumsByAuthor (String artist){
		
		this.url ="http://musicbrainz.org/ws/2/release/?query=artist:"+artist+"%20AND%20status:Official&limit=10";

		try{
			System.out.println(url);
			BufferedReader urlReader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
			FileWriter localFile = new FileWriter(new File("src/main/resources/xmlFile/MusicBrainzAlbum.xml"));


			System.out.println("Telechargement términé");
			String s;
			while((s = urlReader.readLine()) != null){
				localFile.write(s);
			}
			urlReader.close();
			localFile.close();
			
			musicbrainzDOMTransform.transformAlbum();
			
			
		}
		catch(Exception e){
			System.out.println("Erreur : " + e);
		}
	}


}
