using System;

/* Capturar 3 notas, sacar el Promedio y determinar si el estudiante ganó o perdió la asignatura (Mayor o igual a 3 ganó en
caso contrario Perdió)*/

namespace Ejercicio1
{
    class Program
    {
        static void Main(string[] args)
        {
            float[] notas = new float[3];
            for(int i=0;i<notas.Length;i++){
                Console.Write("Nota [{0}]: ", i+1);
                notas[i] = float.Parse(Console.ReadLine());
            }
            float aux = 0;
            for(int i=0;i<notas.Length;i++){
                aux += notas[i];
            }

            aux /= 3;

            Console.Write("Su promedio es: {0}, ", aux);

            if(aux >= 3){
                Console.WriteLine("Gano la asignatura...");
            }
            else{
                Console.WriteLine("Perdio la asignatura...");
            }

        }
    }
}