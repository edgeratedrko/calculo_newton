/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lagrange_newton;

/**
 *
 * @author yonfo
 */
public class Newton {
    int pontos = 0;
    double x[] = new double[5];
    double y[] = new double[5];
    double z[] = new double[5];
    double RP[] = new double[5];
    double P;
    double Pi;
    double resposta = 0;
    int controle = 0;
    int contador = 0;

    public Newton(double a, double[] b, double[] c){
        this.Pi = a;
        this.x = b;
        this.y = c;
        RP[contador] = y[contador];
        for(int h = 0; h < x.length; h++){
            if(x[h]!=999){
                pontos++;
            }
        }
        controle = pontos;
        for(int q = 1; q < pontos; q++){
            contador++;
            calculoNewton();
        }
        calculaP();
    }

    public void calculoNewton(){

            for(int x = 0; x < 5; x++) {
                try{
                z[x] = (this.y[x] - (this.y[x + 1])) / (this.x[x] - (this.x[x + contador]));
                }
                catch (Exception e){;
                }
            }
            this.y = z;
            try{RP[contador] = z[0];}
            catch (Exception e){;}

    }

    public void calculaP(){
        pontos = 5;
        switch (pontos){
            case 1: P = RP[0];break;
            case 2: P = RP[0]+(RP[1]*(Pi-x[0]));break;
            case 3: P = RP[0]+(RP[1]*(Pi-x[0]))+(RP[2]*(Pi-x[0])*(Pi-x[1]));break;
            case 4: P = RP[0]+(RP[1]*(Pi-x[0]))+(RP[2]*(Pi-x[0])*(Pi-x[1]))+(RP[3]*(Pi-x[0])*(Pi-x[1])*(Pi-x[2]));break;
            case 5: P = RP[0]+(RP[1]*(Pi-x[0]))+(RP[2]*(Pi-x[0])*(Pi-x[1]))+(RP[3]*(Pi-x[0])*(Pi-x[1])*(Pi-x[2]))+(RP[4]*(Pi-x[0])*(Pi-x[1])*(Pi-x[2])*(Pi-x[3]));break;
        }
    }

    public double retornaP(){
        return P;
    }
}
