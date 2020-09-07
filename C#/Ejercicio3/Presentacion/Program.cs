using System;
/*
Capturar la información financiera de un cliente, nombre, numero de cuenta y saldo de apertura 
y permitirle realizar consignaciones y retiros a la cuenta, finalmente consultar el saldo con 
el que queda la cuenta.
*/
namespace Ejercicio3
{
    
class Program{
        static void Main(string[] args)
        {
            Cuenta personal = datos();
            do{}while(opciones(menu(), personal));
        }

        public static Cuenta datos(){
            String nombre;
            long numeroCuenta;

            Console.Write("Nombre: ");
            nombre = Console.ReadLine();
            Console.Write("# Cuenta: ");
            numeroCuenta = long.Parse(Console.ReadLine());

            return new Cuenta(nombre, numeroCuenta);
        }   

        public static int menu(){
            Console.Write("\t.:OPCIONES:.\n"
            + "Retirar..............(1)\n"
            + "Consignar............(2)\n"
            + "Ver saldo............(3)\n"
            + "Salir................(0)\n"
            + "Seleccione: ");

            int op = int.Parse(Console.ReadLine());
            return op;
        }

        public static bool opciones(int c, Cuenta personal){
            logicaCuenta funcionesCuenta = new logicaCuenta(personal);

            bool tr = true;
            switch(c){
                case 0:{
                    tr = false;
                    break;
                }
                case 1:{
                    funcionesCuenta.retirarSaldo();
                    break;
                }
                case 2:{
                    funcionesCuenta.consignarSaldo();
                    break;
                }
                case 3:{
                    Console.WriteLine("\nSu saldo es: {0}", funcionesCuenta.getCuentaUsuario().getSaldo());
                    break;
                }
            }
            return tr;
        }

    }
}
