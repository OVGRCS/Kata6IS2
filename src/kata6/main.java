
package kata6;

import java.io.FileNotFoundException; 
import java.io.IOException; 
import java.sql.SQLException;
import java.util.ArrayList;


public class main {


    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
        
        System.out.println("Comenzamos");
        String nameFile = "C:\\pub\\tmp\\kata6\\Data\\emails.txt";
        ArrayList<Person> mailArray = MailListReader.read(nameFile);
        ArrayList<Person1> person = PersonLoader.read();
        
            HistogramBuilder <Person> builder = new HistogramBuilder<>(mailArray);
            HistogramBuilder <Person1> builder1 = new HistogramBuilder<>(person);

            Histogram<String> domains = builder.build(new Attribute <Person, String>(){

            @Override
            public String get(Person item){
                return item.getMail().split("@")[1];
            }
        });

        Histogram<Character> letters = builder.build(new Attribute<Person, Character>(){

                @Override
                public Character get(Person item){
                    return item.getMail().charAt(0);
                }
        });

        Histogram<String> domains1 = builder1.build(new Attribute<Person1, String>(){
            
            @Override
            public String get(Person1 item) {
                return item.getMail().split("@")[1];
            }
            
        });
        
        Histogram<Float> pesos = builder1.build(new Attribute<Person1, Float>() {

            @Override
            public Float get(Person1 item) {
                return item.getPeso();
            }
        });
        
        Histogram<Character> genero = builder1.build(new Attribute<Person1,Character>(){
            @Override
            public Character get(Person1 item) {
                return item.getGenero().charAt(0);
            }
            
        });
        
        
                
                
        new HistogramDisplay(domains,"DOMINIOS").execute();
        new HistogramDisplay(letters,"CARACTER").execute();
        new HistogramDisplay(domains1,"DOMINIOS").execute();
        new HistogramDisplay(pesos,"PESO").execute();
        new HistogramDisplay(genero,"GENERO").execute();
        
        System.out.println("Fin");        
    }
}

     
