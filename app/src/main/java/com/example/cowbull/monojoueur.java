package com.example.cowbull;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import java.security.SecureRandom;
public class monojoueur extends AppCompatActivity {
    Button rt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monojoueur);


        int codepc=ConstructionCode();
        rt3 = (Button) findViewById(R.id.retour3);
        rt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(monojoueur.this, Main2Activity.class);
                startActivity(i);
            }




        });
        rt3 = (Button) findViewById(R.id.okm);
        rt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView donnee;
                donnee=(TextView)findViewById(R.id.essai);
                if(!(estValide(donnee))){

                }
                else {
                    Test(codepc,donnee);
                }
            }
        });}

        public int  ConstructionCode() {
            int n=10;
            int nbr_chiffre=0;
            int code=0;
            int []numbers={0,1,2,3,4,5,6,7,8,9};
            while(nbr_chiffre<4)
            {
                int var=(int)(Math.random()*n);// choisir par hasard un entier = rang de l'entier à tirer du tableau
                code=(code*10)+numbers[var];// construire le code
                numbers[var]=numbers[n-1];// remplacer l'entier choisit par le dernier entier dans le tableau
                n--;// diminuer n(taille du tableau)
                nbr_chiffre++;
            }// repeter le processus jusqua avoir 4 chiffres diffrents
        }



    public int Test(int code,int p)
    {
        int x=code;
        int t=0;
        int v=0;
        int i=3,j=3;
        while(i>=0&&j>=0)
        {
            int  prop=p;
            while(j>=0)
            {
                int divp=prop/(int)Math.pow(10,j);// extraire les entier en commencant par le gauche,
                // un par un
                int divc=x/(int)Math.pow(10,i);// la meme chose mais sur le code secret
                if(divp==divc)// tester s'il y a égalité de 2 entiers
                {
                    if(i==j)// tester s'ils ont le meme rang ou emplacement dans le code
                        t++;
                    else
                        v++;
                    break;
                }
                prop=prop%(int)(Math.pow(10,j));// prendre les 3 derniers chiffres du code saisie par
                // le user
                j--;// diminuer le nombre de boucle
            }
            j=3;// reinitialiser j à 3 pour retester le code saisie par le user(complet)par
            x=x%(int)(Math.pow(10,i));// le code secret incomplet du premier chiffre.
            i--;
        }
        return((t*10)+v);// retourner un entier indiquant le nombre de T et de V
    }
   public boolean estValide(int prop)
    {
        int [] tab=new int[4];
        int p=prop;
        boolean trouve=false;
        if(p<123)
            trouve=true;
        for(int i=3;i>=0;i--)
        {
            tab[i]=p/(int)(Math.pow(10,i));
            p=p%(int)(Math.pow(10,i));
        }
        int j=0;
        int var=tab[j];
        while(!trouve&&j<3)
        {
            for(int i=j+1;i<4;i++)
            {
                if(var==tab[i])
                {trouve=true;
                    break;}
            }
            j++;
            var=tab[j];
        }
        if (!trouve)
            return true;
        else return false;
    }


    }
