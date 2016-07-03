package com.davidbejar.animaciones;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class mainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final TextView textoAnimado = (TextView) findViewById(R.id.textoAnimado);
        final Button botonAnimar = (Button) findViewById(R.id.botonAnimar) ;
        final TextSwitcher textSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);

        final Button botonPrueba = (Button) findViewById(R.id.buttonNuevo) ;


        final TextSwitcher textSwitcherprueba = (TextSwitcher) findViewById(R.id.textSwitcherprueba);





        // BEGIN_INCLUDE(setup)
        // Set the factory used to create TextViews to switch between.
        textSwitcher.setFactory(mFactory);

        /*
         * Set the in and out animations. Using the fade_in/out animations
         * provided by the framework.
         */
        Animation in = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_out_right);
        textSwitcher.setInAnimation(in);
        textSwitcher.setOutAnimation(out);
        // END_INCLUDE(setup)

        textSwitcher.setCurrentText("Hola Mundo");

        textSwitcherprueba.setInAnimation(in);
        textSwitcherprueba.setOutAnimation(out);
        final TextView t1 = new TextView(this);
        final TextView t2 = new TextView(this);
        t1.setText("Textview1");
        t1.setTextSize(20);
        t1.setTextColor(getResources().getColor(R.color.colorAccent));
        t2.setTextSize(20);
        t2.setText("Textview2");
        textSwitcherprueba.addView(t1);
        textSwitcherprueba.addView(t2);

        final String textoPrueba;



        botonPrueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String txt = ((TextView) textSwitcherprueba.getCurrentView()).getText().toString();

                if ( txt == t1.getText().toString() ){
                    textSwitcherprueba.setText(t2.getText().toString());
                }
                else{
                    textSwitcherprueba.setText(t1.getText());

                }
            }
        });






        botonAnimar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textoAnimado.getText() != "Hola Mundo"){
                    textoAnimado.setText("Hola Mundo");
                }
                else{
                    textoAnimado.setText("Animaciones en Android");
                }

                //Toma el texto actual del textSwitcher y lo pasa a una cadena de texto
                String texto = ((TextView) textSwitcher.getCurrentView()).getText().toString();


                if ((texto) != "Hola Mundo"){
                    textSwitcher.setText("Hola Mundo");
                }
                else{
                    textSwitcher.setText("Animaciones en Android");
                }
                textoAnimado.setText(texto);
            }
        });
















        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    // BEGIN_INCLUDE(factory)
    /**
     * The {@link android.widget.ViewSwitcher.ViewFactory} used to create {@link android.widget.TextView}s that the
     * {@link android.widget.TextSwitcher} will switch between.
     */
    public ViewSwitcher.ViewFactory mFactory = new ViewSwitcher.ViewFactory() {

        @Override
        public View makeView() {

            // Create a new TextView
            //TextView t = new TextView(mainActivity.this);
            TextView textViewprueba = new TextView(mainActivity.this);
            textViewprueba.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
            textViewprueba.setTextAppearance(mainActivity.this, android.R.style.TextAppearance_Large);
            return textViewprueba;
        }
    };
    // END_INCLUDE(factory)

}
