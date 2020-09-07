using System;
using System.Threading;

namespace ListasEnlazadas
{
    class Program
    {
        static Nodo cabeza, ultimo;
        public static void agregarNodo(Nodo nodo){
            if(cabeza == null){
                cabeza = nodo;
            }
            else{
                ultimo.siguiente = nodo;
            }
            ultimo = nodo;
        }

        public static Nodo crearNodo(){
            Nodo nodo = new Nodo();
            nodo.numero = new Random().Next(20);
            nodo.siguiente = null;
            return nodo;
        }

        public static void mostrarListaEnlazada(){
            Nodo actual = cabeza;
            while(actual != null){
                Console.Write("{0} ", actual.numero);
                Thread.Sleep(1000);
                actual = actual.siguiente;
            }
            Console.WriteLine();
        }

        public static void Main(){
            for(int i=0;i<10;i++){
                Nodo nuevo = crearNodo();
                agregarNodo(nuevo);
            }
            mostrarListaEnlazada();
        }

    }
}
