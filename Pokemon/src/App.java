import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Pokedex rf = new Pokedex();
		rf.read("src/files/Pokedex.txt");
		int i = -1;
		while(i!=0){

			Scanner s = new Scanner(System.in);
			System.out.println("Ingresa el numero de pokemon para visualizarlo");
			i = s.nextInt();
			if(i == -1)
				rf.fullPokedex();
			else if(i==-2)
				rf.guardar();
			else{
				
				rf.buscarPokemon();
				rf.buscarPokemonEnPokedex(i);
			}
			
		}
    }
}
