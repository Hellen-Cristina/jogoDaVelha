package br.senai.sp.cotia.jogodavelha.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.senai.sp.cotia.jogodavelha.R;
import br.senai.sp.cotia.jogodavelha.databinding.FragmentJogoBinding;


public class JogoFragment extends Fragment {
    //variavel para acessar o elementos da view

    private FragmentJogoBinding binding;
    //vetor de botoes para referenciar os botoes

    private Button[] botoes;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //instanciar o binding

        binding = FragmentJogoBinding.inflate(inflater, container,  false);
        botoes = new Button[9];

        //associar o vetor aos botoes
        botoes[0] = binding.bt00;
        botoes[1] = binding.bt01;
        botoes[2] = binding.bt02;
        botoes[3] = binding.bt10;
        botoes[4] = binding.bt11;
        botoes[5] = binding.bt12;
        botoes[6] = binding.bt20;
        botoes[7] = binding.bt21;
        botoes[8] = binding.bt22;

        //associa o listener aos botoes

        for (Button bt : botoes){
            bt.setOnClickListener(listenerBotoes);
        }

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private View.OnClickListener listenerBotoes = btPress -> {
        // obtem o nome do botao
        String nomeBotao = getContext().getResources().getResourceName(btPress.getId());

        //extrai a poicao atraves do nome do botao

        String posicao = nomeBotao.substring(nomeBotao.length()-2);

        //extrai linha e coluna da string posicao

        int linha = Character.getNumericValue(posicao.charAt(0));
        int coluna = Character.getNumericValue(posicao.charAt(1));

        Log.w("BOTAO", linha+"");
        Log.w("BOTAO", coluna+"");
    };
}