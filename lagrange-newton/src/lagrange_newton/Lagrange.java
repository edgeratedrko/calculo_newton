package lagrange_newton;

public class Lagrange {
    double e = 2.7183;
    int pontos = 0;
    double x[] = new double[5];
    double y[] = new double[5];
    double respostaL[] = new double[5];
    double P;
    double resposta = 0;

    public Lagrange(double a, double[] b, double[] c){
        this.P = a;
        this.x = b;
        this.y = c;
        for(int h = 0; h < x.length; h++){
            if(x[h]!=999){
                pontos++;
            }
        }
        calculoL();
        calculoP();
    }

    public void calculoL(){

        for(int a = 0; a < x.length; a++) {
            if (a == 0) {
                respostaL[a] = ((P - x[1]) * (P - x[2])) / ((x[0] - x[1]) * (x[0] - x[2]));
            }
            else if (a == 1) {
                respostaL[a] = ((P - x[0]) * (P - x[2])) / ((x[1] - x[0]) * (x[1] - x[2]));
            } else {
                respostaL[a] = ((P - x[0]) * (P - x[a - 1])) / ((x[a] - x[0]) * (x[a] - x[a - 1]));
            }
        }
    }

    public void calculoP(){
        for(int a = 0; a < pontos; a++){
            resposta += (y[a]*respostaL[a]);
        }
    }

    public double retornoP(){
        return resposta;
    }
}
