import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class Pokedex {
    long longitudLineas;
	String [][] pokemons;

	public void read(String fileName){
		
		Scanner s = null;

		try{
			Path path = Paths.get(fileName);
			File f = new File(fileName);
			longitudLineas = Files.lines(path).count();
			pokemons = new String[(int)longitudLineas][2];

			s = new Scanner(f);
			int cont = 0;
			while(s.hasNextLine()){
				String line = s.nextLine();
				pokemons[cont][0] = line;
				cont++;
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			s.close();
		}
	}

	public void buscarPokemon(){
		Random r = new Random();
		int i = r.nextInt((int)longitudLineas)-1;
		System.out.println("Te encontraste con el pokemon "+(i+1)+" "+pokemons[i][0]);
		pokemons[i][1]="Visto";
	}

	public void buscarPokemonEnPokedex(int n){
		if(pokemons[n-1][1]!= null){
			System.out.println(pokemons[n-1][0]);
		}
		else{
			System.out.println("Pokemon desconocido");
		}
		
	}

	public void fullPokedex(){
		for (int i =0;i< pokemons.length ;i++ ) {
			System.out.print((i+1)+"\t");
			for (int j=0;j<pokemons[0].length ;j++ ) {
				System.out.print(pokemons[i][j]+"\t");
			}
			System.out.println("");
		}
	}

	public void guardar(){
		crearArchivo();
		savePokedex();
	}

	public void crearArchivo(){
		try {
			File myObj = new File("src/Pokedex_saved.txt");
				if (myObj.createNewFile()) {
				  System.out.println("Se ha creado el archivo: " + myObj.getName());
				} else {
				  System.out.println("File already exists.");
				}
		  } catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
		  }
	}

	public void savePokedex() {
        File file = new File("src/Pokedex_saved.txt");
        FileWriter fr = null;
        BufferedWriter br = null;
		
        try{
            fr = new FileWriter(file);
            br = new BufferedWriter(fr);
            for(int i = 0; i<pokemons.length; i++){
				if(pokemons[i][1]!=null)
                	br.write(""+(i+1)+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
