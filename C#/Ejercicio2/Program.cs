using System;
/*
Calcular el número de pulsaciones que debe tener una persona por cada 10 segundos 
de ejercicio aeróbico; la formula que se aplica cuando el

sexo es femenino es:
pulsaciones = (220 -edad)/10
si el sexo es masculino:
pulsaciones = (210 -edad)/10
*/
namespace Ejercicio2
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Escriba su nombre: ");
            string nombre = Console.ReadLine();
            Console.Write("Edad: ");
            int edad = int.Parse(Console.ReadLine());
            string sexo;

            do{
                Console.Write("Sexo (M/F): ");
                sexo = Console.ReadLine();
                sexo = sexo.ToUpper();
            }while(!"M".Equals(sexo) && !"F".Equals(sexo));

            Persona pacientePrueba = new Persona(nombre,edad,sexo);
            Logica funcion = new Logica(pacientePrueba);

            Console.WriteLine("{0}, usted tiene {1} pulsaciones por cada 10 segundos...", pacientePrueba.getNombre(), funcion.CalcularPulsaciones());

        }
    }
}
