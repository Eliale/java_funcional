package principal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args) {
        //    System.out.println("Mensajes".repeat(4));
        Principal p = new Principal();
        //   p.getSubLista(Arrays.asList("Alejandra", "Alicia", "Andrea", "Mariel", "Laura", "Miroslava"), 2, 30).stream().forEach(System.out::println);
//        for (int i = 0; i < 10; i++) {
//            System.out.println("Numero de pelotas :>" + p.sacaPromedios(300000));
//        }
//        int array[] = new int[]{1, 10, 2, 8, 7, 3};
//        System.out.println("pares :>" + p.numero_pares(array, 10));


        System.out.println(p.caracteresIguales("Cadena 1", "Cadena 2"));

    }


    public List<String> getSubLista(List<String> listaCompleta, int inicio, int tamanio) {
        List<String> listaTemporal = new ArrayList<>();
        if (listaCompleta.size() >= inicio) {
            listaTemporal = listaCompleta.subList(inicio - 1, listaCompleta.size());
            tamanio = tamanio >= listaTemporal.size() ? listaTemporal.size() : tamanio;
            listaTemporal = listaTemporal.subList(0, tamanio);
        }
        return listaTemporal;

    }

    public String juntaExtension(String nombreArchivo_conExt, String acompletar) {
        StringBuilder sb = new StringBuilder();
        sb.append(nombreArchivo_conExt);
        String textAlreves = sb.reverse().toString();

        int posicion_punto = textAlreves.lastIndexOf(".");


        return sb.toString();
    }

    private int calculaVolumenCubo(int a, int b, int c) {
        return a * b * c;
    }

    private double calculaVolumenEsfera(double diametro) {
        double r = diametro / 2;
        return ((4 / 3) * Math.PI * (Math.pow(r, 3)));
    }

    public double metePelota() {
        int posicionSacada = (int) (Math.random() * 8);
        double[] array = {19.0, 13.0, 6.0, 5.0, 4.0, 3.5, 3.0, 1.5};
        return array[posicionSacada];
    }

    public int determinaPelotas() {
        double volumenRecipiente = calculaVolumenCubo(50, 50, 124);
        int contadorPelotas = 0;
        while (volumenRecipiente >= 0) {
            // Meter en el recipiente bolita
            volumenRecipiente -= calculaVolumenEsfera(metePelota());
            contadorPelotas++;
        }
        System.out.println("Cantidad Pelotas" + contadorPelotas);
        return contadorPelotas;
    }

    public int sacaPromedios(int n) {
        ArrayList<Integer> promedios = new ArrayList<>();
        while (n >= 0) {
            promedios.add(new Integer(determinaPelotas()));
            n--;
        }
        int promedio = (int) promedios.stream().mapToInt(s -> s).average().orElse(0.0);

        return promedio;
    }

    public int numero_pares(int[] array, int sum) {
        int conteo = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j) {
                    continue;
                } else {
                    if (array[i] + array[j] == sum) {
                        conteo++;
                    }
                }
            }
        }
        return conteo / 2;
    }

    public int numero_pares_v2(int[] array, int sum) {
        int conteo = 0;
        for (int i = 0; i < array.length; i++) {

        }
        return conteo / 2;
    }

    public List<Character> caracteresIguales(String a, String b) {
        List<Character> repetidos = new ArrayList<>();
        char[] al = a.toCharArray();
        char[] bl = b.toCharArray();
        for (int i = 0; i < al.length; i++) {
            for (int j = 0; j < bl.length; j++) {
                if (al[i] == bl[j]) {
                    // caracter igual
                    repetidos.add(al[i]);
                }
            }
        }
        return repetidos.stream().distinct().collect(Collectors.toList());

    }


}
