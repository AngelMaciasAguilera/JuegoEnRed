/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author Angel
 */
public class Juego {

    public static int PUNTOSCLIENTE = 0;
    public static int PUNTOSSERVIDOR = 0;
    private HashMap<Integer, Pregunta> preguntas;

    public Juego() {
        this.preguntas = this.rellenarPreguntas();
    }


    public HashMap<Integer, Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(HashMap<Integer, Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.PUNTOSCLIENTE;
        hash = 83 * hash + Objects.hashCode(this.preguntas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Juego other = (Juego) obj;
        if (PUNTOSCLIENTE != other.PUNTOSCLIENTE) {
            return false;
        }
        return Objects.equals(this.preguntas, other.preguntas);
    }

    @Override
    public String toString() {
        return "Juego{" + "contador=" + PUNTOSCLIENTE + ", preguntas=" + preguntas + '}';
    }

    //Metodo para obtener una pregunta aleatoria
    public synchronized Pregunta obtenerPreguntaAleatoria() {
        int index = (int)(Math.random() * 70);
        Pregunta pregunta = this.preguntas.get(index);
        return pregunta;
    }

    //Este metodo lo usaremos para sobreCargar el hashMap de preguntas
    private HashMap<Integer, Pregunta> rellenarPreguntas() {
        HashMap<Integer, Pregunta> preguntasObtenidas = new HashMap<>();
        preguntasObtenidas.put(1, new Pregunta("¿Cuál es la capital de Australia?", new ArrayList<String>() {
            {
                add("Sydney");
                add("Canberra ");
                add("Melbourne");
                add("Brisbane");
            }
        }, "Canberra"));
        preguntasObtenidas.put(2, new Pregunta("¿En qué año se llevó a cabo la Revolución Rusa?", new ArrayList<String>() {
            {
                add("1905");
                add("1917 ");
                add("1923");
                add("1931");
            }
        }, "1917"));
        preguntasObtenidas.put(3, new Pregunta("¿Quién escribió 'Cien años de soledad'?", new ArrayList<String>() {
            {
                add("Julio Cortázar");
                add("Gabriel García Márquez");
                add("Mario Vargas Llosa");
                add("Isabel Allende");
            }
        }, "Gabriel García Márquez"));
        preguntasObtenidas.put(4, new Pregunta("¿Cuál es el río más largo del mundo?", new ArrayList<String>() {
            {
                add("Nilo");
                add("Amazonas");
                add("Yangtsé");
                add("Mississippi");
            }
        }, "Amazonas"));
        preguntasObtenidas.put(5, new Pregunta("¿En qué país se encuentra la Torre Eiffel?", new ArrayList<String>() {
            {
                add("Italia");
                add("España");
                add("Francia");
                add("Alemania");
            }
        }, "Francia"));
        preguntasObtenidas.put(6, new Pregunta("¿Cuál es la capital de Japón?", new ArrayList<String>() {
            {
                add("Pekín");
                add("Seúl");
                add("Tokio");
                add("Bangkok");
            }
        }, "Tokio"));
        preguntasObtenidas.put(7, new Pregunta("¿Qué científico formuló la teoría de la relatividad?", new ArrayList<String>() {
            {
                add("Isaac Newton");
                add("Galileo Galilei");
                add("Albert Einstein");
                add("Stephen Hawking");
            }
        }, "Albert Einstein"));
        preguntasObtenidas.put(8, new Pregunta("¿Cuál es el océano más grande del mundo?", new ArrayList<String>() {
            {
                add("Atlántico");
                add("Índico");
                add("Antártico");
                add("Pacífico");
            }
        }, "Pacífico"));
        preguntasObtenidas.put(9, new Pregunta("¿En qué año llegó el hombre a la Luna por primera vez?", new ArrayList<String>() {
            {
                add("1965");
                add("1969");
                add("1973");
                add("1981");
            }
        }, "1969"));
        preguntasObtenidas.put(10, new Pregunta("¿Cuál es la moneda oficial de Japón?", new ArrayList<String>() {
            {
                add("Won");
                add("Yen");
                add("Dólar");
                add("Euro");
            }
        }, "Yen"));
        preguntasObtenidas.put(11, new Pregunta("¿En qué continente se encuentra el desierto del Sahara?", new ArrayList<String>() {
            {
                add("África");
                add("Asia");
                add("América");
                add("Europa");
            }
        }, "África"));
        preguntasObtenidas.put(12, new Pregunta("¿Quién fue el primer presidente de Estados Unidos?", new ArrayList<String>() {
            {
                add("John Adams");
                add("Thomas Jefferson");
                add("George Washington");
                add("James Madison");
            }
        }, "George Washington"));
        preguntasObtenidas.put(13, new Pregunta("¿Cuál es la ciudad conocida como la Ciudad de los Vientos?", new ArrayList<String>() {
            {
                add("Chicago");
                add("Nueva York");
                add("Los Ángeles");
                add("Miami");
            }
        }, "Chicago"));
        preguntasObtenidas.put(14, new Pregunta("¿Cuál es el país más grande del mundo en términos de superficie?", new ArrayList<String>() {
            {
                add("Rusia");
                add("China");
                add("Estados Unidos");
                add("India");
            }
        }, "Rusia"));
        preguntasObtenidas.put(15, new Pregunta("¿Quién escribió la obra 'Romeo y Julieta'?", new ArrayList<String>() {
            {
                add("William Shakespeare");
                add("Jane Austen");
                add("Charles Dickens");
                add("Mark Twain");
            }
        }, "William Shakespeare"));
        preguntasObtenidas.put(16, new Pregunta("¿Cuál es el elemento más abundante en la corteza terrestre?", new ArrayList<String>() {
            {
                add("Oxígeno");
                add("Silicio");
                add("Hierro");
                add("Aluminio");
            }
        }, "Oxígeno"));
        preguntasObtenidas.put(17, new Pregunta("¿Cuál es el proceso mediante el cual las plantas fabrican su propio alimento?", new ArrayList<String>() {
            {
                add("Fotosíntesis");
                add("Respiración");
                add("Transpiración");
                add("Germinación");
            }
        }, "Fotosíntesis"));
        preguntasObtenidas.put(18, new Pregunta("¿Cuál es el instrumento musical más antiguo?", new ArrayList<String>() {
            {
                add("Lira");
                add("Flauta");
                add("Tambor");
                add("Arpa");
            }
        }, "Flauta"));
        preguntasObtenidas.put(19, new Pregunta("¿En qué año se firmó la Declaración de Independencia de Estados Unidos?", new ArrayList<String>() {
            {
                add("1776");
                add("1789");
                add("1804");
                add("1812");
            }
        }, "1776"));
        preguntasObtenidas.put(20, new Pregunta("¿Cuál es la montaña más alta del mundo?", new ArrayList<String>() {
            {
                add("Everest");
                add("K2");
                add("Kangchenjunga");
                add("Lhotse");
            }
        }, "Everest"));
        preguntasObtenidas.put(21, new Pregunta("¿Quién fue el autor de 'Don Quijote de la Mancha'?", new ArrayList<String>() {
            {
                add("Miguel de Cervantes");
                add("Lope de Vega");
                add("Garcilaso de la Vega");
                add("Federico García Lorca");
            }
        }, "Miguel de Cervantes"));
        preguntasObtenidas.put(22, new Pregunta("¿En qué año se inauguró el Canal de Panamá?", new ArrayList<String>() {
            {
                add("1914");
                add("1919");
                add("1925");
                add("1930");
            }
        }, "1914"));
        preguntasObtenidas.put(23, new Pregunta("¿Cuál es el segundo planeta del sistema solar?", new ArrayList<String>() {
            {
                add("Venus");
                add("Marte");
                add("Júpiter");
                add("Saturno");
            }
        }, "Venus"));
        preguntasObtenidas.put(24, new Pregunta("¿Quién fue la primera mujer en ganar un Premio Nobel?", new ArrayList<String>() {
            {
                add("Marie Curie");
                add("Rosa Parks");
                add("Mother Teresa");
                add("Wangari Maathai");
            }
        }, "Marie Curie"));
        preguntasObtenidas.put(25, new Pregunta("¿En qué país se encuentra la Gran Barrera de Coral?", new ArrayList<String>() {
            {
                add("Australia");
                add("Brasil");
                add("Indonesia");
                add("México");
            }
        }, "Australia"));
        preguntasObtenidas.put(26, new Pregunta("¿Cuál es la capital de Canadá?", new ArrayList<String>() {
            {
                add("Toronto");
                add("Vancouver");
                add("Ottawa");
                add("Montreal");
            }
        }, "Ottawa"));
        preguntasObtenidas.put(27, new Pregunta("¿Quién fue el primer emperador romano?", new ArrayList<String>() {
            {
                add("Julio César");
                add("Augusto");
                add("Nerón");
                add("Trajano");
            }
        }, "Augusto"));
        preguntasObtenidas.put(28, new Pregunta("¿Qué famoso inventor desarrolló la primera bombilla eléctrica práctica?", new ArrayList<String>() {
            {
                add("Thomas Edison");
                add("Nikola Tesla");
                add("Alexander Graham Bell");
                add("George Westinghouse");
            }
        }, "Thomas Edison"));
        preguntasObtenidas.put(29, new Pregunta("¿Cuál es el río que atraviesa la ciudad de París?", new ArrayList<String>() {
            {
                add("Sena");
                add("Támesis");
                add("Danubio");
                add("Ródano");
            }
        }, "Sena"));
        preguntasObtenidas.put(30, new Pregunta("¿Cuál es el país más poblado del mundo?", new ArrayList<String>() {
            {
                add("India");
                add("Estados Unidos");
                add("China");
                add("Brasil");
            }
        }, "China"));
        preguntasObtenidas.put(31, new Pregunta("¿Quién fue el líder del movimiento de derechos civiles en Estados Unidos que pronunció el famoso discurso 'Tengo un sueño'?", new ArrayList<String>() {
            {
                add("Malcolm X");
                add("John F. Kennedy");
                add("Lyndon B. Johnson");
                add("Martin Luther King Jr.");
            }
        }, "Martin Luther King Jr."));
        preguntasObtenidas.put(32, new Pregunta("¿Cuál es el metal más abundante en la corteza terrestre?", new ArrayList<String>() {
            {
                add("Hierro");
                add("Aluminio");
                add("Cobre");
                add("Oro");
            }
        }, "Aluminio"));
        preguntasObtenidas.put(33, new Pregunta("¿En qué año comenzó la Primera Guerra Mundial?", new ArrayList<String>() {
            {
                add("1914");
                add("1916");
                add("1918");
                add("1920");
            }
        }, "1914"));
        preguntasObtenidas.put(34, new Pregunta("¿Cuál es la capital de Rusia?", new ArrayList<String>() {
            {
                add("San Petersburgo");
                add("Moscú");
                add("Kiev");
                add("Varsovia");
            }
        }, "Moscú"));
        preguntasObtenidas.put(35, new Pregunta("¿Qué instrumento se utiliza para medir la presión atmosférica?", new ArrayList<String>() {
            {
                add("Termómetro");
                add("Barómetro");
                add("Higrómetro");
                add("Anemómetro");
            }
        }, "Barómetro"));
        preguntasObtenidas.put(36, new Pregunta("¿Cuál es la película más taquillera de todos los tiempos?", new ArrayList<String>() {
            {
                add("Titanic");
                add("Avengers: Endgame");
                add("Avatar");
                add("El Rey León");
            }
        }, "Avengers: Endgame"));
        preguntasObtenidas.put(37, new Pregunta("¿En qué continente se encuentra el Monte Kilimanjaro?", new ArrayList<String>() {
            {
                add("Asia");
                add("África");
                add("Europa");
                add("Oceanía");
            }
        }, "África"));
        preguntasObtenidas.put(38, new Pregunta("¿Cuál es el compuesto químico del agua?", new ArrayList<String>() {
            {
                add("Hidrógeno y Oxígeno");
                add("Nitrógeno y Oxígeno");
                add("Carbono y Hidrógeno");
                add("Sodio y Cloro");
            }
        }, "Hidrógeno y Oxígeno"));
        preguntasObtenidas.put(39, new Pregunta("¿Quién escribió 'El Gran Gatsby'?", new ArrayList<String>() {
            {
                add("Ernest Hemingway");
                add("F. Scott Fitzgerald");
                add("J.D. Salinger");
                add("Harper Lee");
            }
        }, "F. Scott Fitzgerald"));
        preguntasObtenidas.put(40, new Pregunta("¿Cuál es el océano más grande del mundo?", new ArrayList<String>() {
            {
                add("Atlántico");
                add("Índico");
                add("Antártico");
                add("Pacífico");
            }
        }, "Pacífico"));
        preguntasObtenidas.put(41, new Pregunta("¿En qué año se fundó la Organización de las Naciones Unidas (ONU)?", new ArrayList<String>() {
            {
                add("1945");
                add("1950");
                add("1955");
                add("1960");
            }
        }, "1945"));
        preguntasObtenidas.put(42, new Pregunta("¿Cuál es el país más pequeño del mundo?", new ArrayList<String>() {
            {
                add("San Marino");
                add("Vaticano");
                add("Mónaco");
                add("Nauru");
            }
        }, "Vaticano"));
        preguntasObtenidas.put(43, new Pregunta("¿Cuál es el metal conocido como el oro rojo?", new ArrayList<String>() {
            {
                add("Oro");
                add("Cobre");
                add("Plata");
                add("Aluminio");
            }
        }, "Cobre"));
        preguntasObtenidas.put(44, new Pregunta("¿Cuál es la capital de Sudáfrica?", new ArrayList<String>() {
            {
                add("Johannesburgo");
                add("Pretoria");
                add("Durban");
                add("Ciudad del Cabo");
            }
        }, "Ciudad del Cabo"));
        preguntasObtenidas.put(45, new Pregunta("¿Quién fue el primer hombre en viajar al espacio?", new ArrayList<String>() {
            {
                add("Neil Armstrong");
                add("Buzz Aldrin");
                add("Yuri Gagarin");
                add("John Glenn");
            }
        }, "Yuri Gagarin"));
        preguntasObtenidas.put(46, new Pregunta("¿En qué continente se encuentra la Gran Muralla China?", new ArrayList<String>() {
            {
                add("Asia");
                add("África");
                add("Europa");
                add("América");
            }
        }, "Asia"));
        preguntasObtenidas.put(47, new Pregunta("¿Cuál es el gas más abundante en la atmósfera terrestre?", new ArrayList<String>() {
            {
                add("Oxígeno");
                add("Nitrógeno");
                add("Dióxido de carbono");
                add("Hidrógeno");
            }
        }, "Nitrógeno"));
        preguntasObtenidas.put(49, new Pregunta("¿Quién pintó 'La noche estrellada'?", new ArrayList<String>() {
            {
                add("Pablo Picasso");
                add("Vincent van Gogh");
                add("Leonardo da Vinci");
                add("Claude Monet");
            }
        }, "Vincent van Gogh"));
        preguntasObtenidas.put(50, new Pregunta("¿Cuál es el río más largo de África?", new ArrayList<String>() {
            {
                add("Nilo");
                add("Amazonas");
                add("Congo");
                add("Níger");
            }
        }, "Nilo"));
        preguntasObtenidas.put(51, new Pregunta("¿Cuál es el país conocido como la Tierra del Sol Naciente?", new ArrayList<String>() {
            {
                add("China");
                add("Japón");
                add("Corea del Sur");
                add("Vietnam");
            }
        }, "Japón"));
        preguntasObtenidas.put(52, new Pregunta("¿Quién escribió 'Orgullo y prejuicio'?", new ArrayList<String>() {
            {
                add("Jane Austen");
                add("Charlotte Brontë");
                add("Emily Brontë");
                add("Charles Dickens");
            }
        }, "Jane Austen"));
        preguntasObtenidas.put(53, new Pregunta("¿Cuál es el instrumento principal en una orquesta que es tocado por un violinista?", new ArrayList<String>() {
            {
                add("Violonchelo");
                add("Viola");
                add("Violín");
                add("Contrabajo");
            }
        }, "Violín"));
        preguntasObtenidas.put(54, new Pregunta("¿En qué año se fundó la Cruz Roja?", new ArrayList<String>() {
            {
                add("1863");
                add("1876");
                add("1901");
                add("1924");
            }
        }, "1863"));
        preguntasObtenidas.put(55, new Pregunta("¿Cuál es la capital de Argentina?", new ArrayList<String>() {
            {
                add("Buenos Aires");
                add("Córdoba");
                add("Rosario");
                add("Mendoza");
            }
        }, "Buenos Aires"));
        preguntasObtenidas.put(56, new Pregunta("¿Cuál es el único planeta del sistema solar que rota en sentido horario?", new ArrayList<String>() {
            {
                add("Mercurio");
                add("Venus");
                add("Urano");
                add("Plutón");
            }
        }, "Venus"));
        preguntasObtenidas.put(57, new Pregunta("¿En qué año se proclamó la Declaración de los Derechos Humanos?", new ArrayList<String>() {
            {
                add("1945");
                add("1948");
                add("1952");
                add("1956");
            }
        }, "1948"));
        preguntasObtenidas.put(58, new Pregunta("¿Cuál es el país más grande de América del Sur?", new ArrayList<String>() {
            {
                add("Brasil");
                add("Argentina");
                add("Colombia");
                add("Perú");
            }
        }, "Brasil"));
        preguntasObtenidas.put(59, new Pregunta("¿Cuál es el símbolo químico del oro?", new ArrayList<String>() {
            {
                add("O");
                add("Au");
                add("Ag");
                add("Fe");
            }
        }, "Au"));
        preguntasObtenidas.put(60, new Pregunta("¿Quién fue la primera mujer en ganar un Premio Nobel de la Paz?", new ArrayList<String>() {
            {
                add("Madre Teresa");
                add("Rigoberta Menchú");
                add("Wangari Maathai");
                add("Aung San Suu Kyi");
            }
        }, "Madre Teresa"));
        preguntasObtenidas.put(61, new Pregunta("¿Cuál es el país más poblado de Europa?", new ArrayList<String>() {
            {
                add("Francia");
                add("Alemania");
                add("Reino Unido");
                add("Rusia");
            }
        }, "Rusia"));
        preguntasObtenidas.put(62, new Pregunta("¿Quién fue el autor de 'Crimen y castigo'?", new ArrayList<String>() {
            {
                add("León Tolstói");
                add("Fyodor Dostoevsky");
                add("Anton Chekhov");
                add("Nikolai Gogol");
            }
        }, "Fyodor Dostoevsky"));
        preguntasObtenidas.put(63, new Pregunta("¿Cuál es el río más largo de América del Norte?", new ArrayList<String>() {
            {
                add("Misisipi");
                add("Yukón");
                add("Colorado");
                add("Columbia");
            }
        }, "Misisipi"));
        preguntasObtenidas.put(64, new Pregunta("¿En qué año se inauguró el Canal de Suez?", new ArrayList<String>() {
            {
                add("1859");
                add("1869");
                add("1879");
                add("1889");
            }
        }, "1869"));
        preguntasObtenidas.put(65, new Pregunta("¿Cuál es el período de tiempo que abarca un siglo?", new ArrayList<String>() {
            {
                add("50 años");
                add("75 años");
                add("100 años");
                add("125 años");
            }
        }, "100 años"));
        preguntasObtenidas.put(66, new Pregunta("¿Quién escribió '1984'?", new ArrayList<String>() {
            {
                add("Aldous Huxley");
                add("Ray Bradbury");
                add("George Orwell");
                add("Philip K. Dick");
            }
        }, "George Orwell"));
        preguntasObtenidas.put(67, new Pregunta("¿Cuál es el metal más ligero?", new ArrayList<String>() {
            {
                add("Aluminio");
                add("Titanio");
                add("Litio");
                add("Magnesio");
            }
        }, "Litio"));
        preguntasObtenidas.put(68, new Pregunta("¿En qué país se encuentra la antigua ciudad de Petra?", new ArrayList<String>() {
            {
                add("Irak");
                add("Egipto");
                add("Israel");
                add("Jordania");
            }
        }, "Jordania"));
        preguntasObtenidas.put(69, new Pregunta("¿Cuál es el autor de la obra 'Romeo y Julieta'?", new ArrayList<String>() {
            {
                add("William Shakespeare");
                add("Christopher Marlowe");
                add("John Milton");
                add("Jane Austen");
            }
        }, "William Shakespeare"));
        preguntasObtenidas.put(70, new Pregunta("¿En qué año se firmó el Tratado de Versalles, poniendo fin a la Primera Guerra?", new ArrayList<String>() {
            {
                add("1917");
                add("1919");
                add("1921");
                add("1923");
            }
        }, "1919"));

        return preguntasObtenidas;
    }

}
