package devandroid.bruna.appjokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    //Métodos para acionar os botões.
    //View referecia os componentes de interface
    public void pedraSelecionada(View view) {
        this.itemSelecionado("pedra");
        Toast.makeText(this, "Pedra selecionada.", Toast.LENGTH_SHORT).show(); //Toast mensagem na tela do usario
    }

    public void papelSelecionado(View view) {
        this.itemSelecionado("papel");
        Toast.makeText(this, "Papel selecionado.", Toast.LENGTH_SHORT).show(); //Toast mensagem na tela do usario
    }

    public void tesouraSelecionada(View view) {
        this.itemSelecionado("tesoura");
        Toast.makeText(this, "Tesoura selecionada.", Toast.LENGTH_SHORT).show(); //Toast mensagem na tela do usario
    }

    public int itemSelecionado(String itemSelecionado) { //liga as imagens aos étodos de acionamento dos botões

        ImageView imageResult = findViewById(R.id.imageResult);
        TextView textResult = findViewById(R.id.textResult);


        int item = new Random().nextInt(3); // elementos de escolha
        String[] escolhas = {"pedra", "papel", "tesoura"}; // arrey para encontrar os elementos disponiveis no joguinho
        String escolhaAdv = escolhas[item];



    //Gerar as imagens resultantes randomicamente
        if (item == 0) {
            imageResult.setImageResource(R.drawable.pedra);
        } else if (item == 1) {
            imageResult.setImageResource(R.drawable.papel);
        } else if (item == 2) {
            imageResult.setImageResource(R.drawable.tesoura);
        } else {
            imageResult.setImageResource(R.drawable.padrao);
        }

        // if's para informar o resultado do jogo, possiveis situações do jogo
        if ((escolhaAdv.equals("pedra") && itemSelecionado.equals("tesoura")) ||
                (escolhaAdv.equals("papel") && itemSelecionado.equals("pedra")) ||
                (escolhaAdv.equals("tesoura") && itemSelecionado.equals("papel"))) {
            textResult.setText("Você perdeu!");

        } else if ((itemSelecionado.equals("pedra") && escolhaAdv.equals("tesoura")) ||
                (itemSelecionado.equals("papel") && escolhaAdv.equals("pedra")) ||
                (itemSelecionado.equals("tesoura") && escolhaAdv.equals("papel"))){
            textResult.setText("Você Ganhou!");

        } else {
            textResult.setText("Empate!");
        }

        return item;
    }
}
