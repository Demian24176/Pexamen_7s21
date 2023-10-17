package mx.edu.isc.tesoem.jdcg.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import DatosExamen.EstructuraDatos;

public class PrincipalActivity extends AppCompatActivity {

    TextView txtpregunta;
    RadioButton r1, r2, r3;

    Button btnant, btnsig, btncal;

    int Indice = 0; // Agrega esta variable para rastrear el índice de la pregunta actual
    int puntaje = 0;
    int respuestasCorrectas = 0;
    ArrayList<EstructuraDatos> listadatos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtpregunta = findViewById(R.id.txtpregunta);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        r3 = findViewById(R.id.r3);

        btnant = findViewById(R.id.btnant);
        btnsig = findViewById(R.id.btnsig);
        btncal = findViewById(R.id.btncal);

        EstructuraDatos ed = new EstructuraDatos();

        ed.setPregunta("1.- ¿Quién fue el líder de la Revolución Rusa de 1917?");
        ed.setR1("A) Vladimir Putin");
        ed.setR2("B) Leon Trotsky");
        ed.setR3("C) Joseph Stalin");
        ed.setRc("A");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("2.- ¿Cuál es el océano más profundo del mundo?");
        ed.setR1("A) a) Océano Atlántico");
        ed.setR2("B)  Océano Índico");
        ed.setR3("C)  Océano Pacífico");
        ed.setRc("C");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("3.- ¿Quién escribió la novela Don Quijote de la Mancha?");
        ed.setR1("A)   William Faulkner");
        ed.setR2("B)  Miguel de Cervantes");
        ed.setR3("C) Gabriel García Márquez");
        ed.setRc("B");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("4.- ¿Cuál es el río más largo del mundo?");
        ed.setR1("A) El Amazonas");
        ed.setR2("B) El Nilo");
        ed.setR3("C) El Mississippi");
        ed.setRc("A");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("5.- ¿Qué instrumento se utiliza para medir la presión arterial?");
        ed.setR1("A) Termómetro");
        ed.setR2("B) Estetoscopio");
        ed.setR3("C) Esfigmomanómetro");
        ed.setRc("C");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("6.- ¿Cuál es el metal más ligero en la tabla periódica de los elementos?");
        ed.setR1("A) Aluminio");
        ed.setR2("B) Plata");
        ed.setR3("C) Litio");
        ed.setRc("C");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("7.- ¿Quién fue el primer ser humano en viajar al espacio?");
        ed.setR1("A) Buzz Aldrin");
        ed.setR2("B) Neil Armstrong");
        ed.setR3("C) Yuri Gagari");
        ed.setRc("C");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("8.- ¿Cuál es el océano más grande del mundo?");
        ed.setR1("A) Atlántico");
        ed.setR2("B) Pacífico");
        ed.setR3("C) Ártico");
        ed.setRc("B");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("9.- ¿¿En qué continente se encuentra el país de Marruecos?");
        ed.setR1("A)  Europa");
        ed.setR2("B) África");
        ed.setR3("C) Asia");
        ed.setRc("B");
        listadatos.add(ed);
        ed = new EstructuraDatos();
        ed.setPregunta("10.- ¿Cuál es el país más grande del mundo en términos de superficie?");
        ed.setR1("A) Estados Unidos");
        ed.setR2("B) Canadá");
        ed.setR3("C) Rusia");
        ed.setRc("C");
        listadatos.add(ed);
        EstructuraDatos edm = listadatos.get(0);
        //Log.i("informacion", "valor: " + edm.getPregunta());
        txtpregunta.setText(edm.getPregunta());
        r1.setText(edm.getR1());
        r2.setText(edm.getR2());
        r3.setText(edm.getR3());

        btnsig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica si se ha seleccionado una respuesta antes de avanzar
                String respuestaSeleccionada = obtenerRespuesta();
                if (respuestaSeleccionada != null) {
                    listadatos.get(Indice).setRespuestaSeleccionada(respuestaSeleccionada);
                }

                Indice++;

                if (Indice < listadatos.size()) {
                    EstructuraDatos nextQuestion = listadatos.get(Indice);
                    txtpregunta.setText(nextQuestion.getPregunta());
                    r1.setText(nextQuestion.getR1());
                    r2.setText(nextQuestion.getR2());
                    r3.setText(nextQuestion.getR3());

                    // Limpia la selección de respuestas
                    r1.setChecked(false);
                    r2.setChecked(false);
                    r3.setChecked(false);
                }
            }
        });

        btnant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Indice--;

                if (Indice >= 0 && Indice < listadatos.size()) {
                    EstructuraDatos previousQuestion = listadatos.get(Indice);
                    txtpregunta.setText(previousQuestion.getPregunta());
                    r1.setText(previousQuestion.getR1());
                    r2.setText(previousQuestion.getR2());
                    r3.setText(previousQuestion.getR3());

                    // Limpia la selección de respuestas
                    r1.setChecked(false);
                    r2.setChecked(false);
                    r3.setChecked(false);
                }
            }
        });


        btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Califica la pregunta actual si se ha seleccionado una respuesta
                if (Indice >= 0 && Indice < listadatos.size()) {
                    EstructuraDatos preguntaActual = listadatos.get(Indice);
                    String respuestaSeleccionada = obtenerRespuesta();

                    if (respuestaSeleccionada != null) {
                        preguntaActual.setRespuestaSeleccionada(respuestaSeleccionada);
                    }
                }
                puntaje = 0; // Reinicia el puntaje cada vez que se califica
                respuestasCorrectas = 0; // Reinicia el contador de respuestas correctas

                // Califica todas las preguntas y cuenta las respuestas correctas
                for (EstructuraDatos pregunta : listadatos) {
                    String respuestaSeleccionadaPregunta = pregunta.getRespuestaSeleccionada();

                    if (respuestaSeleccionadaPregunta != null) {
                        if (respuestaSeleccionadaPregunta.equals(pregunta.getRc())) {
                            // Respuesta correcta
                            puntaje++; // Aumenta el puntaje
                            respuestasCorrectas++;
                        }
                    }
                }
                Toast.makeText(PrincipalActivity.this, "Puntaje total: " + puntaje + " de 10 preguntas. Respuestas correctas: " + respuestasCorrectas, Toast.LENGTH_LONG).show();
            }
        });
    }

    private String obtenerRespuesta() {
        if (r1.isChecked()) {
            return "A";
        } else if (r2.isChecked()) {
            return "B";
        } else if (r3.isChecked()) {
            return "C";
        } else {
            return null; // Ninguna respuesta seleccionada
        }
    }

}